package pl.osa.osaapplication.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.osa.osaapplication.model.AuthenticationProvider;
import pl.osa.osaapplication.model.Role;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
@Builder
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

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


    @Column(name = "address")
    private String address;

    //    private  Byte avatar;

    @Column(name = "preferredWayOdComunication")
    private String preferredWayOfComunication;

    @Column(name = "auth_provider")
    @Enumerated(EnumType.STRING)
    private AuthenticationProvider auth_provider;

    @NotNull
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

    public Role getRole() {
        return role;
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    public Set<Address> addresses;

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }


}
