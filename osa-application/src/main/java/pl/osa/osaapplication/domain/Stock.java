package pl.osa.osaapplication.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "stocs")
public class Stock {

    @Id
    @GeneratedValue
    private Long id;


    @Column(name = "quantity")
    private Long quantity;


    @JsonIgnore
    @ManyToOne
    private Product product;
}
