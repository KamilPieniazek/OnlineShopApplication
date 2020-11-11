package pl.osa.osaapplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.osa.osaapplication.domain.OrderLine;

public interface OrderLineRepository extends JpaRepository<OrderLine,Long> {
}
