package com.stocks.client;

import com.stocks.config.Application;
import com.stocks.service.IAllStocksBasicInformationRetriever;
import com.stocks.service.IDailyStockInformationRetrieverService;
import com.stocks.service.IStocksBasicInformationAggregator;
import com.stocks.service.dto.StockInformation;
import com.stocks.service.dto.StocksBasicInformation;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

import javax.annotation.Resource;
import java.util.Optional;

@SpringBootApplication
@Import(Application.class)
public class ApplicationRunner implements CommandLineRunner {

    @Resource
    @Qualifier("allStocksBasicInformationLoader")
    private IAllStocksBasicInformationRetriever allStocksBasicInformationRetriever;

    @Resource
    @Qualifier("stocksBasicInformationAggregator")
    private IStocksBasicInformationAggregator<StocksBasicInformation> stocksBasicInformationAggregator;

    @Resource
    @Qualifier("dailyStockInformationRetrieverService")
    private IDailyStockInformationRetrieverService dailyStockInformationRetrieverService;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ApplicationRunner.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Information from orders.xlsx
        StocksBasicInformation stocksBasicInformation = allStocksBasicInformationRetriever.retrieveAll();
        System.out.println(stocksBasicInformation);

        // Aggregating multiple StocksBasicInformation for the same stock in one StocksBasicInformation
        StocksBasicInformation aggregatedStocksBasicInformation = stocksBasicInformationAggregator.aggregate(stocksBasicInformation);

       /* StockSymbols stockSymbols = new StockSymbols();
        stocksBasicInformation.getStream().forEach(stockBasicInformation -> stockSymbols.addAll(stockBasicInformation.getStockSymbols()));*/

        // Information from external service that gives me prices of stocks
        aggregatedStocksBasicInformation.getStream().forEach(stock -> {
            Optional<StockInformation> stockInformation = dailyStockInformationRetrieverService.execute(stock);
            stockInformation.ifPresent(si -> System.out.println(si));
        });
    }
}
