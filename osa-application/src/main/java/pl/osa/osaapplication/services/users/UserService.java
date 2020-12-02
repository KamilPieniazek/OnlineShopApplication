package pl.osa.osaapplication.services.users;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.osa.osaapplication.domain.User;
import pl.osa.osaapplication.model.UserForm;
import pl.osa.osaapplication.repositories.UserRepository;
import pl.osa.osaapplication.services.users.UserMapper;

import java.util.List;


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

//    public User getById(String email) {
//        return userRepository.findByEmail(email);
//    }

    public User getById(String email) {
        return userRepository.findById(email)
                .orElseThrow(() -> new RuntimeException(String.format("User with id %s does not exist", email)));
    }
}
