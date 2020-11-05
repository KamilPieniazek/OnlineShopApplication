package pl.osa.osaapplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.osa.osaapplication.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,String> {
}
