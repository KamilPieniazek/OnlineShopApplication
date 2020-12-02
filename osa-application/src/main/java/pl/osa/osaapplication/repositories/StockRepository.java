package pl.osa.osaapplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.osa.osaapplication.domain.Stock;

public interface StockRepository extends JpaRepository<Stock, Long> {
    Stock findByProduct(String product);
}
