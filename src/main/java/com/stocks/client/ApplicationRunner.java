package com.stocks.client;

import com.stocks.config.Application;
import com.stocks.service.IAllStocksBasicInformationRetriever;
import com.stocks.service.IDailyStockInformationRetrieverService;
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
    @Qualifier("dailyStockInformationRetrieverService")
    private IDailyStockInformationRetrieverService dailyStockInformationRetrieverService;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ApplicationRunner.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        StocksBasicInformation stocksBasicInformation = allStocksBasicInformationRetriever.retrieveAll();
        System.out.println(stocksBasicInformation);

       /* StockSymbols stockSymbols = new StockSymbols();
        stocksBasicInformation.getStream().forEach(stockBasicInformation -> stockSymbols.addAll(stockBasicInformation.getStockSymbols()));*/

        stocksBasicInformation.getStream().forEach(stock -> {
            Optional<StockInformation> stockInformation = dailyStockInformationRetrieverService.execute(stock);
            stockInformation.ifPresent(si -> System.out.println(si));
        });
    }
}
