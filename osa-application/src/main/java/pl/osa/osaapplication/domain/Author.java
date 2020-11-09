package pl.osa.osaapplication.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "authors")
public class Author {

    @NotEmpty
    @Id
    @Column(name = "name")
    private String name;


    @OneToMany()
    @JoinColumn(name = "author_name")
    private List<Product> products;


}
