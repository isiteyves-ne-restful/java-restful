package rw.rca.ne.pacis.client.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class Link {
    private Integer id;

    private Website website;

    private String linkName;

    private Long totalElapsedTime;

    private Long totalDownloadedKilobytes;
}
