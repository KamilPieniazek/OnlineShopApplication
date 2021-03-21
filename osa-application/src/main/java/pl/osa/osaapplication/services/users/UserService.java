package pl.osa.osaapplication.services.users;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.osa.osaapplication.domain.User;
import pl.osa.osaapplication.model.AuthenticationProvider;
import pl.osa.osaapplication.model.Role;
import pl.osa.osaapplication.model.UserForm;
import pl.osa.osaapplication.repositories.UserRepository;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void createUser(final UserForm userForm) {
        final User user = userMapper.createUser(userForm);
        userRepository.save(user);

    }

    public User createUser(User user) {
        return userRepository.save(user);
    }


    public User getById(String email) {
        return userRepository.findById(email)
                .orElseThrow(() -> new RuntimeException(String.format("User with id %s does not exist", email)));
    }


    public Optional<User> findById(String email) {
        return userRepository.findById(email);
    }


    public void updateUserAfterOAuthLoginSuccess(User user, AuthenticationProvider provider) {
         user.setAuth_provider(provider);

         userRepository.save(user);
    }

    public void updateUser(UserForm userForm) {

        //TODO: Object user (current user), save change from userform to user

    }
}
