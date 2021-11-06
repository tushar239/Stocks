package com.stocks.client;

import com.stocks.config.Application;
import com.stocks.dao.IAllStocksBasicInformationLoader;
import com.stocks.dao.dto.StocksBasicInformation;
import com.stocks.dao.dto.dailystockinfo.StockDailyInformation;
import com.stocks.service.AllStockBasicInformationRetriever;
import com.stocks.service.DailyStockInformationLoaderService;
import com.stocks.service.IAllStockBasicInformationRetriever;
import com.stocks.service.dto.StockBasicInformation;
import com.stocks.service.dto.StockInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
@Import(Application.class)
public class ApplicationRunner implements CommandLineRunner {

    @Autowired
    IAllStocksBasicInformationLoader allStocksBasicInformationLoader;

    @Autowired
    private DailyStockInformationLoaderService dailyStockInformationLoaderService;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ApplicationRunner.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        StocksBasicInformation stocks = allStocksBasicInformationLoader.load();
        System.out.println(stocks);

        IAllStockBasicInformationRetriever allStockBasicInformationRetriever = new AllStockBasicInformationRetriever();
        final List<StockBasicInformation> stocksBasicInformation = allStockBasicInformationRetriever.retrieveAll();
        for (StockBasicInformation stockBasicInformation: stocksBasicInformation) {
            Optional<StockInformation> stockInformation = dailyStockInformationLoaderService.execute(stockBasicInformation);
            stockInformation.ifPresent(si -> System.out.println(si));
        }
    }
}
