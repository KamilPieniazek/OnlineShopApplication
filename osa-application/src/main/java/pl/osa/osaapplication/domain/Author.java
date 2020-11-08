package pl.osa.osaapplication.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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


    @OneToMany(mappedBy = "author")
    private List<Product> products;


}
