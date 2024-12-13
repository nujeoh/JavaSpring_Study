package com.example.cryptoautomation.service;

import com.example.cryptoautomation.http.SlackHttpClient;
import com.example.cryptoautomation.http.UpbitHttpClient;
import com.example.cryptoautomation.http.UpbitTickerDto;
import com.example.cryptoautomation.repository.ReportHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.DecimalFormat;

@Service
@RequiredArgsConstructor
public class UpbitSlackService {
    private final SlackHttpClient slackHttpClient;
    private final UpbitHttpClient upbitHttpClient;
    private final ReportHistoryRepository repository;

    public void execute(String market) {
        // upbit
        UpbitTickerDto tickerByMarket =
                upbitHttpClient.getTickerByMarket(market);

        // slack
        StringBuilder sb = new StringBuilder();
        DecimalFormat df = new DecimalFormat("₩###,###");
        BigDecimal price = new BigDecimal(
                tickerByMarket.getTrade_price().toString()
        );
        sb.append("[실시간 데이터]");
        sb.append("\n");
        sb.append(market);
        sb.append(" 시세");
        sb.append("\n");
        sb.append(df.format(price));
        slackHttpClient.sendMessage(sb.toString());

        repository.save(market, String.valueOf(tickerByMarket.getTrade_price()));
    }
}
