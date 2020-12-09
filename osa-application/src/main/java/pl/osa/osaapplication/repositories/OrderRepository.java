package pl.osa.osaapplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.osa.osaapplication.domain.Order;

public interface OrderRepository  extends JpaRepository<Order,Long> {

}
