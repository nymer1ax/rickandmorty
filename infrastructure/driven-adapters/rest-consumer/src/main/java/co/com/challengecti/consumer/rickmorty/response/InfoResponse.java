package co.com.challengecti.consumer.rickmorty.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class InfoResponse {
    private Integer count;
    private Integer pages;
    private String next;
    private Object prev;
}
