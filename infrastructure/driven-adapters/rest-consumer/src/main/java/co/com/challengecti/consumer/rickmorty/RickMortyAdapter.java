package co.com.challengecti.consumer.rickmorty;

import co.com.challengecti.consumer.rickmorty.response.RickMortyResponse;
import co.com.challengecti.model.result.Result;
import co.com.challengecti.model.result.gateways.ResultConsumer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;
@RequiredArgsConstructor
@Repository
public class RickMortyAdapter implements ResultConsumer {
    private final RickMortyRestConsumer rickMortyConsumer;
    private final RickMortyMapper rickMortyMapper;

    @Override
    public Result getResult() throws Exception {
       RickMortyResponse consumerDto = rickMortyConsumer.findAllLocation();
        return rickMortyMapper.mapRickMortyResponseToResult(consumerDto);
    }
}
