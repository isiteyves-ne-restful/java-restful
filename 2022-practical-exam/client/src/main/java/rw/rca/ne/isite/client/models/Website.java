package rw.rca.ne.isite.client.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
public class Website {

    private Integer id;

    private String websiteName;

    private String downloadStartDateTime;

    private String downloadEndDateTime;

    private Long totalElapsedTime;

    private Long totalDownloadedKilobytes;
}
