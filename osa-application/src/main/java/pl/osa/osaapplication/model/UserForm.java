package pl.osa.osaapplication.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.validator.constraints.Length;
//import pl.osa.osaapplication.domain.Role;

import javax.persistence.Column;
import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserForm {


    @NotEmpty(message = "This form cannot be empty!")
    //  @Column(unique = true,name = "email")
    @Email
    private String email;

    @NotEmpty(message = "This form  can not be blank!")
    @Length(min = 8, message = "Password must contain at least 8 characters")
    private String password;

    @NotEmpty(message = "This form can not be blank!")
    private String address;

    @NotEmpty(message = "Please pick an option")
    private String preferredWayOfComunication;

    private String street;

    private String building_number;

    private String flat_number;

    private String postal_code;

    private String city;

    @AssertTrue
    public boolean isPasswordValid() {
        if (password == null) {

            return false;
        }
        return !password.toLowerCase().equals(password) &&
                password.chars().anyMatch(Character::isDigit) &&
                password.chars().anyMatch(Character::isAlphabetic);
    }

    private boolean shouldProceedWithCart = true;


}
