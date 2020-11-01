package pl.osa.osaapplication.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
@Table(name = "users")
public class User {

    @Id
    private String email;

    @NotNull
    private String password;

    @NotNull
    private String city;

    @NotNull
    private String address;


    //    private  Byte avatar;
    private String preferredCWayOfComunication;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "users_to_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "email"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "name")
    )
    private List<Role> roles = new ArrayList<>();

}
