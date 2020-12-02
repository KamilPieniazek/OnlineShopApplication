package pl.osa.osaapplication.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class OrderForm {

    private String username;

    private String productsName;

    private String shippingAddress;


}
