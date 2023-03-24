package co.com.challengecti.model.result.gateways;

import co.com.challengecti.model.result.Result;

import java.io.IOException;

public interface ResultConsumer {
    public Result getResult() throws Exception;
}
