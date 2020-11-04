package pl.osa.osaapplication.services.validation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import pl.osa.osaapplication.model.UserForm;
import pl.osa.osaapplication.repositories.UserRepository;

@Component
@RequiredArgsConstructor
public class UserValidator {

    private final UserRepository userRepository;

    public void validateEmail(final UserForm userForm,final Errors errors){
        if(!userRepository.findAllByEmail(userForm.getEmail()).isEmpty()){
            errors.rejectValue("email","Email is in use");
        }
    }

}


