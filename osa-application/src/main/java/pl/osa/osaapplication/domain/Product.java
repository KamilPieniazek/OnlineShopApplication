package pl.osa.osaapplication.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.osa.osaapplication.model.ProductType;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

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

    //private url miniaturka

    //kategoria

    //  @NotEmpty
    @Column(name = "price")
    private double price;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private ProductType type;

    @ManyToOne
    @JoinColumn(name = "author",referencedColumnName = "name")

    private Author author;


}