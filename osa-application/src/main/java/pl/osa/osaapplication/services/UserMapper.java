package pl.osa.osaapplication.services;

import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pl.osa.osaapplication.domain.User;
import pl.osa.osaapplication.model.UserForm;

@Component
@RequiredArgsConstructor
public class UserMapper {

    //private final PasswordEncoder passwordEncoder;

    public User toUser(final UserForm userForm) {
        final User user = new User();
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        //   user.setPassword(passwordEncoder.encode(userForm.getPassword()));
        user.setCity(userForm.getCity());
        user.setAddress(userForm.getAddress());
        user.setPreferredCWayOfComunication(userForm.getPreferredCWayOfComunication());
        return user;
    }
}

