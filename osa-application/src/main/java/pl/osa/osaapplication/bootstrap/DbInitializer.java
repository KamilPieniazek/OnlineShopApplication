package pl.osa.osaapplication.bootstrap;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.osa.osaapplication.domain.Role;
import pl.osa.osaapplication.domain.User;
import pl.osa.osaapplication.repositories.UserRepository;

import java.util.List;

@Component
@RequiredArgsConstructor

public class DbInitializer implements CommandLineRunner {
    private final UserRepository userRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
            userRepository.save(new User("kamil@kamil.pl","dupa","Gdansk","Gdansk12","email",
                    List.of(new Role("ADMIN","admin group",List.of()))));
        }
}
