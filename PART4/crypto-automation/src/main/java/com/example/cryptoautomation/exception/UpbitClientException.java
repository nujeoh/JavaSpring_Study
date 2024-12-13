package com.example.cryptoautomation.exception;

public class UpbitClientException extends RuntimeException {
    public UpbitClientException(String message) {
        super(String.format("Error while calling upbit API. error=%s", message));
    }
}
