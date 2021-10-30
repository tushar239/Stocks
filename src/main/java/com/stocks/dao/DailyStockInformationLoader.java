package com.stocks.dao;

import com.stocks.dao.dto.dailystockinfo.StockDailyInformation;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class DailyStockInformationLoader implements IDailyStockInformationLoader {

    private final String baseUrl, hostName, host, keyName, key;

    public DailyStockInformationLoader(String baseUrl, String hostName, String host, String keyName, String key) {
        this.baseUrl = baseUrl;
        this.hostName = hostName;
        this.host = host;
        this.keyName = keyName;
        this.key = key;
    }

    @Override
    public StockDailyInformation load(String timeFrame, String symbol) {
        // TODO: you need a builder class
        String url = baseUrl + "function="+timeFrame+"&symbol="+symbol+"&outputsize=compact&datatype=json";

        // RestTemplate vs WebClient - https://www.baeldung.com/spring-webclient-resttemplate
        // Mon vs Flux - https://vinsguru.medium.com/java-reactive-programming-flux-vs-mono-c94316b55f36
        WebClient webClient = WebClient.builder().defaultHeaders(httpHeaders -> {
            httpHeaders.set(hostName, host);
            httpHeaders.set(keyName, key);
        }).build();

        WebClient.ResponseSpec responseSpec = webClient.get().uri(url).retrieve();
        Mono<StockDailyInformation> stockDailyInformationMono = responseSpec.bodyToMono(StockDailyInformation.class);
        StockDailyInformation stockDailyInformation = stockDailyInformationMono.block();

        return stockDailyInformation;
    }
}
