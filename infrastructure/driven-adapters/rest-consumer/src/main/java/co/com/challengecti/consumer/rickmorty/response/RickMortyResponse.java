package co.com.challengecti.consumer.rickmorty.response;



import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class RickMortyResponse {
    InfoResponse info;
    List<LocationResponse> results;
}
