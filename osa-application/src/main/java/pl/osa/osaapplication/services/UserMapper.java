package pl.osa.osaapplication.services;

import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pl.osa.osaapplication.domain.User;
import pl.osa.osaapplication.model.Role;
import pl.osa.osaapplication.model.UserForm;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserMapper {

    //private final PasswordEncoder passwordEncoder;

    public User createUser(final UserForm userForm){
        return User.builder()
                .email(userForm.getEmail())
                .password(userForm.getPassword())
                .address(userForm.getAddress())
                .city(userForm.getCity())
                .preferredWayOfComunication(userForm.getPreferredWayOfComunication())
                .role(Role.USER)
                .build();
    }
//    public User toUser(final UserForm userForm) {
//        final User user = new User();
//        user.setEmail(userForm.getEmail());
//        user.setPassword(userForm.getPassword());
//        //   user.setPassword(passwordEncoder.encode(userForm.getPassword()));
//        user.setCity(userForm.getCity());
//
//       // user.getRoles(List.of(new Role("USER","User gruop",List.of())));
//        user.setAddress(userForm.getAddress());
//        user.setPreferredWayOfComunication(userForm.getPreferredWayOfComunication());
//        return user;
//    }
}

