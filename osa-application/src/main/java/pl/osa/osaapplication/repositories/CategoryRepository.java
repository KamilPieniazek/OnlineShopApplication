package pl.osa.osaapplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.osa.osaapplication.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, String> {
}
