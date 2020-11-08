package pl.osa.osaapplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.osa.osaapplication.domain.Author;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

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


}
