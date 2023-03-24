package co.com.challengecti.api;
import co.com.challengecti.model.result.Result;
import co.com.challengecti.usecase.getalllocations.GetAllLocationsUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {

    private final GetAllLocationsUseCase getAllLocationsUseCase;


    @GetMapping(path = "/location")
    public Result getLocations() throws Exception {
        return getAllLocationsUseCase.getAllLocations();
    }
}
