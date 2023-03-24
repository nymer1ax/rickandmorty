package co.com.challengecti.consumer;

import lombok.RequiredArgsConstructor;
import okhttp3.HttpUrl;
import okhttp3.Request;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;
@RequiredArgsConstructor
@Component
public class RestConsumerURL {

    @Value("${adapter.restconsumer.url}")
    private String base;

    public HttpUrl generateUrl(){
        return HttpUrl.parse(base);

    }

    public Request generateRequest(HttpUrl httpUrl){
        return new Request.Builder()
                .addHeader("Content-Type", "application/json")
                .url(httpUrl)
                .build();
    }

}
