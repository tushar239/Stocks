package com.stocks.service.config;

import com.stocks.dao.IAllStocksBasicInformationLoader;
import com.stocks.dao.IDailyStockInformationLoader;
import com.stocks.dao.config.DaoConfiguration;
import com.stocks.service.AllStocksBasicInformationRetriever;
import com.stocks.service.DailyStockInformationRetrieverService;
import com.stocks.service.IAllStocksBasicInformationRetriever;
import com.stocks.service.IDailyStockInformationRetrieverService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(DaoConfiguration.class)
public class ServiceConfiguration {

    @Bean("dailyStockInformationRetrieverService")
    public IDailyStockInformationRetrieverService dailyStockInformationRetrieverService(@Qualifier("dailyStockInformationLoader")
                                                                                         IDailyStockInformationLoader dailyStockInformationLoader) {
        return new DailyStockInformationRetrieverService(dailyStockInformationLoader);
    }

    @Bean("allStocksBasicInformationRetriever")
    public IAllStocksBasicInformationRetriever allStocksBasicInformationRetriever(@Qualifier("allStocksBasicInformationLoader")
                                                                                       IAllStocksBasicInformationLoader allStocksBasicInformationLoader) {
        return new AllStocksBasicInformationRetriever(allStocksBasicInformationLoader);
    }
}
