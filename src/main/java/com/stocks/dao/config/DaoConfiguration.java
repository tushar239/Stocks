package com.stocks.dao.config;

import com.stocks.dao.AllStocksBasicInformationLoader;
import com.stocks.dao.DailyStockInformationLoader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources(value={
        @PropertySource(value="classpath:dao.properties")
})
public class DaoConfiguration {

    @Bean("dailyStockInformationLoader")
    public DailyStockInformationLoader dailyStockInformationLoader(@Value("${daily_stock_information_base_url}") String baseUrl,
                                                                   @Value("${daily_stock_information_host_property_name}") String hostName,
                                                                   @Value("${daily_stock_information_host}") String host,
                                                                   @Value("${daily_stock_information_key_property_name}") String keyName,
                                                                   @Value("${daily_stock_information_key}") String key) {
        return new DailyStockInformationLoader(baseUrl, hostName, host, keyName, key);
    }

    @Bean("allStocksBasicInformationLoader")
    public AllStocksBasicInformationLoader allStocksBasicInformationLoader(@Value("${stocks_basic_information_path}") String path) {
        return new AllStocksBasicInformationLoader(path);
    }
}
