package com.stocks.service.config;

import com.stocks.dao.DailyStockInformationLoader;
import com.stocks.dao.config.DaoConfiguration;
import com.stocks.service.DailyStockInformationLoaderService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(DaoConfiguration.class)
public class ServiceConfiguration {
    @Bean
    public DailyStockInformationLoaderService dailyStockInformationLoaderService(@Qualifier("dailyStockInformationLoader")
                                                                                         DailyStockInformationLoader dailyStockInformationLoader) {
        return new DailyStockInformationLoaderService(dailyStockInformationLoader);
    }
}
