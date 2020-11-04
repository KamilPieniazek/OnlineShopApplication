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
public interface UserRepository extends JpaRepository<User, String> {
    List<User> findAllByEmail(String email);

    @Query("SELECT u.email FROM users u WHERE u.email=:email")
   String findByEmail(@Param("email") String email);


        }



