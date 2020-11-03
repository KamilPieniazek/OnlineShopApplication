package pl.osa.osaapplication.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    Long id;

    @Email
    @Column(name = "email")
    @NotNull(message = "This field is mandatory")
    private String email;

    @NotNull(message = "This field is mandatory")
    @Column(name = "password")
    private String password;

    @NotNull
    @Column(name = "city")
    private String city;

    @NotNull
    @Column(name = "address")
    private String address;

    //    private  Byte avatar;

    @Column(name = "preferredWayOdComunication")
    private String preferredWayOfComunication;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "users_to_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "name")
    )
    private List<Role> roles = new ArrayList<>();

}
