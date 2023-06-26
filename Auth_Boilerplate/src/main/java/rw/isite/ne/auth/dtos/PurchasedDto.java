package rw.isite.ne.auth.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchasedDto {
    //@NotBlank
    private  String product_code;

    //@NotBlank
    private  int quantity;

    //@NotBlank
    private int total;
}
