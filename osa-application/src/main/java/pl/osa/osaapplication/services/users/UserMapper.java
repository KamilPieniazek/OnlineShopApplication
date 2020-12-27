package pl.osa.osaapplication.services.users;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.osa.osaapplication.domain.User;
import pl.osa.osaapplication.model.Role;
import pl.osa.osaapplication.model.UserForm;



@Component
@RequiredArgsConstructor
@Transactional
public class UserMapper {

    private final PasswordEncoder passwordEncoder;

    public User createUser(final UserForm userForm){
        return User.builder()
                .email(userForm.getEmail())
                .password(passwordEncoder.encode(userForm.getPassword()))
                .address(userForm.getAddress())
                .city(userForm.getCity())
                .preferredWayOfComunication(userForm.getPreferredWayOfComunication())
                .role(Role.ROLE_USER)
                .build();
    }
}

