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


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
@Builder
public class User {


    @Id
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

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }

//    @Column(columnDefinition = "varchar(255) default 'USER'")
//    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//    @JoinTable(name = "users_to_roles",
//            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "email"),
//            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "name")
//    )
//    private List<Role> roles = new ArrayList<>();

    //    @JoinColumn(name = "user_id",referencedColumnName = "id")
//    @JoinColumn(name = "role_id",referencedColumnName = "name")
//    private String role;

    public boolean hasAddressDefined() {
        return !this.getAddress().equals("default");
    }
}
