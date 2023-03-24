package co.com.challengecti.consumer.rickmorty;

import co.com.challengecti.consumer.rickmorty.response.InfoResponse;
import co.com.challengecti.consumer.rickmorty.response.LocationResponse;
import co.com.challengecti.consumer.rickmorty.response.RickMortyResponse;
import co.com.challengecti.model.info.Info;
import co.com.challengecti.model.location.Location;
import co.com.challengecti.model.result.Result;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
@RequiredArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class RickMortyMapper {

    private final ObjectMapper mapper;

    public RickMortyResponse mapJsonObjectToRestResponse(JSONObject jsonObject) throws Exception {

        InfoResponse infoResponse = getInfoResponse(jsonObject);

        List<LocationResponse> results = getLocationResponses(jsonObject);

        return RickMortyResponse.builder()
                .info(infoResponse)
                .results(results)
                .build();

    }

    private static InfoResponse getInfoResponse(JSONObject jsonObject) {

        return InfoResponse.builder()
                .count(jsonObject.getJSONObject("info").getInt("count"))
                .pages(jsonObject.getJSONObject("info").getInt("pages"))
                .next(jsonObject.getJSONObject("info").getString("next"))
                .prev( jsonObject.getJSONObject("info").get("prev") == null ? "empty" : jsonObject.getJSONObject("info").get("prev") )
                .build();
    }

    private List<LocationResponse> getLocationResponses(JSONObject jsonObject) {

        return StreamSupport.stream(jsonObject.getJSONArray("results").spliterator(), false).map( m -> {
            try{
                return mapper.readValue(m.toString(), LocationResponse.class);
            }catch (Exception e){
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toList());

    }

    public Result mapRickMortyResponseToResult(RickMortyResponse dto) {
        return Result.builder()
                .info(Info.builder()
                        .count(dto.getInfo().getCount())
                        .next(dto.getInfo().getNext())
                        .pages(dto.getInfo().getPages())
                        .prev(dto.getInfo().getPrev())
                        .build())
                .results(dto.getResults().stream().map(d -> Location.builder()
                        .id(d.getId())
                        .name(d.getName())
                        .type(d.getType())
                        .dimension(d.getDimension())
                        .residents(d.getResidents())
                        .url(d.getUrl())
                        .created(d.getCreated())
                        .build()
                ).collect(Collectors.toList()))
                .build();
    }
}
