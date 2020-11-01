package pl.osa.osaapplication.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.Email;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserForm{

    @NotNull
    @Email
    private String email;

    private String password;

    private String city;

    private String address;

    private  String preferredWayOfComunication;
}
