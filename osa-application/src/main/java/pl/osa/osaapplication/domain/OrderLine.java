package pl.osa.osaapplication.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "OrderLine")
public class OrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "product")
    private String product;

    @Column(name = "quantity")
    private Long quantity;

    @Column(name = "price")
    private double price;

    @Column(name = "username")
    private String username;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;




}
