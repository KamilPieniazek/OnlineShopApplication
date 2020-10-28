package pl.osa.osaapplication.services;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.osa.osaapplication.repositories.UserRepository;


@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;


}
