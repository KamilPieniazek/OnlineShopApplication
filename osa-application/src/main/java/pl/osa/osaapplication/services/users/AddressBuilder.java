package pl.osa.osaapplication.services.users;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.osa.osaapplication.domain.Address;
import pl.osa.osaapplication.model.UserForm;

import java.util.Set;

@Component
@RequiredArgsConstructor
@Transactional
public class AddressBuilder {

    public Address createAddress(UserForm userForm) {
        return Address.builder()
                .street(userForm.getStreet())
                .build();
    }
}
