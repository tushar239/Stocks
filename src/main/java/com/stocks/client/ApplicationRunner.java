package com.stocks.client;

import com.stocks.config.Application;
import com.stocks.dao.dto.dailystockinfo.StockDailyInformation;
import com.stocks.service.DailyStockInformationLoaderService;
import com.stocks.service.dto.StockInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(Application.class)
public class ApplicationRunner implements CommandLineRunner {

    @Autowired
    private DailyStockInformationLoaderService dailyStockInformationLoaderService;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ApplicationRunner.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        StockInformation stockInformation = dailyStockInformationLoaderService.execute();
        System.out.println(stockInformation);
    }
}
