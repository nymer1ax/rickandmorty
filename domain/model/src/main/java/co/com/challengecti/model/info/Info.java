package co.com.challengecti.model.info;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Info {
    private Integer count;
    private Integer pages;
    private String next;
    private Object prev;
}
