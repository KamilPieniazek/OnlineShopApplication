package pl.osa.osaapplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.osa.osaapplication.domain.Address;

public interface AdressRepository extends JpaRepository<Address, Long> {

}
