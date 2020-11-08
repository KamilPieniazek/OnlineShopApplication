package pl.osa.osaapplication.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.validator.constraints.Length;
import pl.osa.osaapplication.domain.Role;

import javax.persistence.Column;
import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserForm {


    @NotEmpty(message = "This form cannot be empty!")
    //  @Column(unique = true,name = "email")
    @Email
    private String email;

    @NotEmpty(message = "This form  can not be blank!")
    @Length(min = 8, message = "Password must contain at least 8 characters")
    private String password;

    @NotEmpty(message = "This form can not be blank!")
    private String city;

    @NotEmpty(message = "This form can not be blank!")
    private String address;

    @NotEmpty(message = "Please pick an option")
    private String preferredWayOfComunication;

    @Column(name = "name", columnDefinition = "varchar(255) default 'USER'")
    private Role role;

    @AssertTrue
    public boolean isPasswordValid() {
        if (password == null) {

            return false;
        }
        return !password.toLowerCase().equals(password) &&
                password.chars().anyMatch(ch -> Character.isDigit(ch)) &&
                password.chars().anyMatch(ch -> Character.isAlphabetic(ch));
    }


}
