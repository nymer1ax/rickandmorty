package co.com.challengecti.consumer.rickmorty;

import co.com.challengecti.consumer.RestConsumerURL;
import co.com.challengecti.consumer.rickmorty.response.RickMortyResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.RequiredArgsConstructor;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class RickMortyRestConsumer {

    private final OkHttpClient client;

    private final RestConsumerURL restConsumerURL;

    private final RickMortyMapper rickMortyMapper;



    public RickMortyResponse findAllLocation() throws Exception {

        HttpUrl httpUrl = restConsumerURL.generateUrl().newBuilder().addPathSegment("location").build();

        Request request = restConsumerURL.generateRequest(httpUrl).newBuilder().get().build();

        Response response = client.newCall(request).execute();

        String jsonData = response.body().string();

        JSONObject jsonObject = new JSONObject(jsonData);

        return rickMortyMapper.mapJsonObjectToRestResponse(jsonObject);
    }
}
