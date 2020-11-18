package pl.osa.osaapplication.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "OrderLine")
public class OrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String product;

    private Long quantity;

    private double price;

    @OneToMany
    @JoinColumn(name = "orders")
    private List<Order> orders;


}
