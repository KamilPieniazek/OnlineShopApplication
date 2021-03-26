package pl.osa.osaapplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.osa.osaapplication.domain.User;
import pl.osa.osaapplication.model.UserForm;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByEmail(String email);

    Optional<User> findByEmail(String email);
}
