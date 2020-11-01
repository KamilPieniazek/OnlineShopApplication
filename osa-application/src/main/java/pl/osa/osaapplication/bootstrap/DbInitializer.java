package pl.osa.osaapplication.bootstrap;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.osa.osaapplication.config.UserProperties;
import pl.osa.osaapplication.domain.Role;
import pl.osa.osaapplication.domain.User;
import pl.osa.osaapplication.repositories.UserRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
@Transactional
public class DbInitializer implements CommandLineRunner {
    @Value("${sda.user.email:default@email.com}")
    private String email;
    private final UserRepository userRepository;
    private final UserProperties userProperties;

    @Override
    public void run(String... args) throws Exception {
        userRepository.save(new User(userProperties.getEmail(), "dupa", "Gdansk", "Gdansk12", "email",
                List.of(new Role("ADMIN", "admin group", List.of()))));
    }
}
