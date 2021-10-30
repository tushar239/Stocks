package com.stocks.config;

import com.stocks.dao.DailyStockInformationLoader;
import com.stocks.dao.DaoConfiguration;
import com.stocks.service.DailyStockInformationLoaderService;
import com.stocks.service.config.ServiceConfiguration;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@Import(ServiceConfiguration.class)
public class Application {

}
