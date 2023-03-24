package co.com.challengecti.usecase.getalllocations;

import co.com.challengecti.model.result.Result;
import co.com.challengecti.model.result.gateways.ResultConsumer;
import lombok.RequiredArgsConstructor;

import java.io.IOException;

@RequiredArgsConstructor
public class GetAllLocationsUseCase {

    private final ResultConsumer resultConsumer;

    public Result getAllLocations() throws Exception {
        return resultConsumer.getResult();
    }

}
