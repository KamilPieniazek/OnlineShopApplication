package pl.osa.osaapplication.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.osa.osaapplication.model.ProductType;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "products")

public class Product {

    @Id
    @NotEmpty
    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;


    @Column(name = "image")
    private byte[] image;

    //kategoria
    @Column(name = "category")
    private String category;

    //  @NotEmpty
    @Column(name = "price")
    private double price;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private ProductType type;

    @ManyToOne()
    private Author author;

    @Column(name = "quantity")
    private Long quantity;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Stock stocks;



}
