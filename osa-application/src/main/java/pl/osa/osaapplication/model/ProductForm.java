package pl.osa.osaapplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductForm {

    @NotEmpty(message = "Please insert a title")
    private String title;

    @NotEmpty(message = "Please write the description")
    private String description;

    //url

    //kategoria


   // @NotEmpty(message = "Please add price")
    private double price;

    @Enumerated(EnumType.STRING)
   // @NotNull(message = "Please pick from the list")
    private ProductType productType;




}
