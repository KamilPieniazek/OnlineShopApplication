package pl.osa.osaapplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductForm {

    @NotEmpty(message = "Please insert a title")
    private String title;

    @NotEmpty(message = "Please write the description")
    private String description;

    //url
    //@NotEmpty(message = "Please load a picture of a product")
    private byte[] image;


    // @NotEmpty(message = "Please add price")
    private double price;

    @Enumerated(EnumType.STRING)
    private ProductType productType;

    private String authorName;

    private String categoryName;

    private Long quantity;




}
