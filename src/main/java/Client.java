import com.github.pnpninja.nsetools.NSETools;
import com.github.pnpninja.nsetools.domain.IndexQuote;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import org.ta4j.core.*;
import org.ta4j.core.analysis.criteria.ReturnOverMaxDrawdownCriterion;
import org.ta4j.core.analysis.criteria.VersusBuyAndHoldCriterion;
import org.ta4j.core.analysis.criteria.WinningPositionsRatioCriterion;
import org.ta4j.core.analysis.criteria.pnl.GrossReturnCriterion;
import org.ta4j.core.indicators.SMAIndicator;
import org.ta4j.core.indicators.helpers.ClosePriceIndicator;
import org.ta4j.core.num.Num;
import org.ta4j.core.rules.CrossedDownIndicatorRule;
import org.ta4j.core.rules.CrossedUpIndicatorRule;
import org.ta4j.core.rules.StopGainRule;
import org.ta4j.core.rules.StopLossRule;

import ta4jexamples.loaders.CsvTradesLoader;

import com.intrinio.api.*;
import com.intrinio.models.*;
import com.intrinio.invoker.*;
import com.intrinio.invoker.auth.*;
import org.threeten.bp.*;
import java.math.BigDecimal;
import java.util.*;

/*
    These apis are taken from
    rapidapi.com

    https://rapidapi.com/twelvedata/api/twelve-data1/
    https://rapidapi.com/alphavantage/api/alpha-vantage/
 */
public class Client {
    public static void main(String[] args) throws Exception {

        /*
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://indianstockexchange.p.rapidapi.com/index.php?id=532540")
                .get()
                .addHeader("x-rapidapi-host", "indianstockexchange.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "038bef5886mshdfa9ad5c48e29eap18da81jsnbfb5bdb84b94")
                .build();

        Response response = client.newCall(request).execute();
        ResponseBody body = response.body();
        String stringResponse = body.string();
        System.out.println(stringResponse);

        */
        // api to get information about a stock symbol
        {
            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url("https://twelve-data1.p.rapidapi.com/stocks?country=INDIA&symbol=TCS&format=json")
                    .get()
                    .addHeader("x-rapidapi-host", "twelve-data1.p.rapidapi.com")
                    .addHeader("x-rapidapi-key", "038bef5886mshdfa9ad5c48e29eap18da81jsnbfb5bdb84b94")
                    .build();

            Response response = client.newCall(request).execute();
            ResponseBody body = response.body();
            String stringResponse = body.string();
            System.out.println(stringResponse);
        }

        // api to get prices of multiple days of a stock
        {
            OkHttpClient client = new OkHttpClient();
            String url = "https://alpha-vantage.p.rapidapi.com/query?function=TIME_SERIES_DAILY&outputsize=compact&datatype=json" + "&symbol=507685.BSE";
            Request request = new Request.Builder()
                    .url(url)
                    .get()
                    .addHeader("x-rapidapi-host", "alpha-vantage.p.rapidapi.com")
                    .addHeader("x-rapidapi-key", "038bef5886mshdfa9ad5c48e29eap18da81jsnbfb5bdb84b94")
                    .build();

            Response response = client.newCall(request).execute();
            ResponseBody body = response.body();
            String stringResponse = body.string();
            System.out.println(stringResponse);
        }
       /* NSETools nseTools = new NSETools();
        List<IndexQuote> allIndicesQuotes = nseTools.getAllIndicesQuotes();
        allIndicesQuotes.stream().forEach(indexQuote -> {System.out.println(indexQuote.getName());
            System.out.println(indexQuote.getLastPrice());
        });
*/
        /*
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        ApiKeyAuth auth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
        auth.setApiKey("OmM1Njk5NzRkNGQwZDY1ZTg0NWIxODY0MDViMDY5MWYy");
        //auth.setApiKey("OjJlMWIwN2IwZWJmOTQ5NmZjNjMyZjE1MGNmODRlOWQ5");
        //auth.setApiKey("OjgwM2MzMzI1YmVhYjVmMWJhMzMwZmVjNWFlN2E4MDg1");//
        defaultClient.setAllowRetries(true);

        SecurityApi securityApi = new SecurityApi();
        String identifier = "AAPL";
        String source = "bats";

        RealtimeStockPrice result = securityApi.getSecurityRealtimePrice(identifier, source);
        System.out.println(result);

        */

        /*
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        ApiKeyAuth auth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");
        auth.setApiKey("OjJlMWIwN2IwZWJmOTQ5NmZjNjMyZjE1MGNmODRlOWQ5");
        defaultClient.setAllowRetries(true);

        StockExchangeApi stockExchangeApi = new StockExchangeApi();
        String identifier = "USCOMP";
        String source = null;
        Integer pageSize = 100;
        String nextPage = null;

        ApiResponseStockExchangeRealtimeStockPrices result = stockExchangeApi.getStockExchangeRealtimePrices(identifier, source, pageSize, nextPage);
        System.out.println(result);
    */
        //-------------------------------------------------------------------------



/*
        // https://github.com/ta4j/ta4j

        // Getting a bar series (from any provider: CSV, web service, etc.)
        //BarSeries series = CsvTradesLoader.loadBitstampSeries();
        BarSeries series = new BaseBarSeriesBuilder().withName("TCS").build();

        // Getting the close price of the bars
        Num firstClosePrice = series.getBar(0).getClosePrice();
        System.out.println("First close price: " + firstClosePrice.doubleValue());
        // Or within an indicator:
        ClosePriceIndicator closePrice = new ClosePriceIndicator(series);
        // Here is the same close price:
        System.out.println(firstClosePrice.isEqual(closePrice.getValue(0))); // equal to firstClosePrice

        // Getting the simple moving average (SMA) of the close price over the last 5
        // bars
        SMAIndicator shortSma = new SMAIndicator(closePrice, 5);
        // Here is the 5-bars-SMA value at the 42nd index
        System.out.println("5-bars-SMA value at the 42nd index: " + shortSma.getValue(42).doubleValue());

        // Getting a longer SMA (e.g. over the 30 last bars)
        SMAIndicator longSma = new SMAIndicator(closePrice, 30);

        // Ok, now let's building our trading rules!c

        // Buying rules
        // We want to buy:
        // - if the 5-bars SMA crosses over 30-bars SMA
        // - or if the price goes below a defined price (e.g $800.00)
        Rule buyingRule = new CrossedUpIndicatorRule(shortSma, longSma)
                .or(new CrossedDownIndicatorRule(closePrice, 800));

        // Selling rules
        // We want to sell:
        // - if the 5-bars SMA crosses under 30-bars SMA
        // - or if the price loses more than 3%
        // - or if the price earns more than 2%
        Rule sellingRule = new CrossedDownIndicatorRule(shortSma, longSma)
                .or(new StopLossRule(closePrice, series.numOf(3)))
                .or(new StopGainRule(closePrice, series.numOf(2)));

        // Running our juicy trading strategy...
        BarSeriesManager seriesManager = new BarSeriesManager(series);
        TradingRecord tradingRecord = seriesManager.run(new BaseStrategy(buyingRule, sellingRule));
        System.out.println("Number of positions for our strategy: " + tradingRecord.getPositionCount());

        // Analysis

        // Getting the winning positions ratio
        AnalysisCriterion winningPositionsRatio = new WinningPositionsRatioCriterion();
        System.out.println("Winning positions ratio: " + winningPositionsRatio.calculate(series, tradingRecord));
        // Getting a risk-reward ratio
        AnalysisCriterion romad = new ReturnOverMaxDrawdownCriterion();
        System.out.println("Return over Max Drawdown: " + romad.calculate(series, tradingRecord));

        // Total return of our strategy vs total return of a buy-and-hold strategy
        AnalysisCriterion vsBuyAndHold = new VersusBuyAndHoldCriterion(new GrossReturnCriterion());
        System.out.println("Our return vs buy-and-hold return: " + vsBuyAndHold.calculate(series, tradingRecord));*/
    }
}
