package pl.osa.osaapplication.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    Long id;

//    @ManyToOne()
//    private User users;
//    @OneToMany()
//    @JoinColumn(name = "user_name")
//    private List<User> users;

    @Column(name = "username")
    private String username;

    @Column(name = "totalPrice")
    private Double totalPrice;

    @Column(name = "clientAddress")
    private String clientAdrress;

    @Column(name = "shipmentAddress")
    private String shipmentAddress;

    //data

    @ManyToOne()
    private OrderLine orderLine;


    //status
}
