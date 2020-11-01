package pl.osa.osaapplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.osa.osaapplication.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
}
