package pl.osa.osaapplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.osa.osaapplication.domain.Author;

public interface AuthorRepository extends JpaRepository<Author,String> {
    Author findAuthorByName(String name);
}
