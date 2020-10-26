package pl.osa.osaapplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.osa.osaapplication.domain.User;

public interface UserRepository extends JpaRepository<User,String> {
}
