package pl.osa.osaapplication.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
public class User {

    @Id
    private  String email;

    @NotNull
    private  String password;

    @NotNull
    private  String city;

    @NotNull
    private  String address;

    private  Byte avatar;

    private  enum Role{}

    private  String preferredCWayOfComunication;




}
