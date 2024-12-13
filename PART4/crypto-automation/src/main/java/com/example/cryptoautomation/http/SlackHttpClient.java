package com.example.cryptoautomation.http;

import com.slack.api.Slack;
import com.slack.api.webhook.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class SlackHttpClient {
    public void sendMessage(String message){
        try{
            Slack instance = Slack.getInstance();
            Payload payload = Payload.builder()
                    .text(message)
                    .build();
            instance.send("https://hooks.slack.com/services/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", payload);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
