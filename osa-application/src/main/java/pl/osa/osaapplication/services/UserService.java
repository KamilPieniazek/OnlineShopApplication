package pl.osa.osaapplication.services;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.osa.osaapplication.domain.User;
import pl.osa.osaapplication.model.UserForm;
import pl.osa.osaapplication.repositories.UserRepository;

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
        final User user = userMapper.toUser(userForm);
        userRepository.save(user);
    }

    public List<User> getByEmail(String email) {
        return userRepository.findAllByEmail(email);
    }

}
