package pl.osa.osaapplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.osa.osaapplication.domain.OrderLine;

import java.util.List;

public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {
    OrderLine findByProduct(String name);

    List<OrderLine> findByUsername(String username);

    // OrderLine findByUsernames(String username);


}
