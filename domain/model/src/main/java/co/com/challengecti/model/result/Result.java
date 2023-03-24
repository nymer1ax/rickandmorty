package co.com.challengecti.model.result;

import co.com.challengecti.model.info.Info;
import co.com.challengecti.model.location.Location;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Result {
    Info info;
    List<Location> results;
}
