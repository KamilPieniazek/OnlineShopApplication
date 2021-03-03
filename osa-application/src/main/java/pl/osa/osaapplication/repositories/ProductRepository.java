package pl.osa.osaapplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.osa.osaapplication.domain.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,String> {
    @Query(value = "SELECT p FROM products p WHERE p.title LIKE %?1%")
    List<Product> searchByTitleKeyword(String keyword);
}
