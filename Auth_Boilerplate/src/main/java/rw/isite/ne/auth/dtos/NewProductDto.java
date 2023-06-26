package rw.isite.ne.auth.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewProductDto {
    //@NotBlank
    private  String name;

    //@NotBlank
    private  String productType;

    //@NotBlank
    private  int price;

    //@NotBlank
    private Date in_date;

    //@NotBlank
    private String image;
}
