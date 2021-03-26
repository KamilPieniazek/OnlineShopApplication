package pl.osa.osaapplication.services.users;

import lombok.RequiredArgsConstructor;
import lombok.Singular;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.osa.osaapplication.domain.Address;
import pl.osa.osaapplication.domain.User;
import pl.osa.osaapplication.model.Role;
import pl.osa.osaapplication.model.UserForm;
import pl.osa.osaapplication.repositories.AdressRepository;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


@Component
@RequiredArgsConstructor
@Transactional
public class UserMapper {

    private final PasswordEncoder passwordEncoder;

    public User createUser(final UserForm userForm) {
        HashSet<Address> addresses = new HashSet<>();
        addresses.add(createAddres(userForm));
        User user = User.builder()
                .email(userForm.getEmail())
                .password(passwordEncoder.encode(userForm.getPassword()))
                .city(userForm.getCity())
                .addresses(addresses)
                .preferredWayOfComunication(userForm.getPreferredWayOfComunication())
                .role(Role.ROLE_USER)
                .build();
       // user.addresses.forEach(address -> address.setUser(user));

        return user;
    }

    public Address createAddres(final UserForm userForm) {
        return Address.builder()
                .street("a")
                .building_number("a")
                .flat_number("a")
                .postal_code("a")
                .city("a")
                .build();
    }
}

