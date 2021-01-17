package pl.osa.osaapplication.bootstrap;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import pl.osa.osaapplication.domain.*;
import pl.osa.osaapplication.model.ProductType;
import pl.osa.osaapplication.model.Role;
import pl.osa.osaapplication.repositories.*;

import java.util.List;

@Component
@RequiredArgsConstructor
@Transactional
public class DbInitializer implements CommandLineRunner {
    @Value("test@test.com")
    private String email;
    private final UserRepository userRepository;
    private final AuthorRepository authorRepository;
    private final ProductRepository productRepository;
    private final PasswordEncoder passwordEncoder;
    private final StockRepository stockRepository;

    @Override
    public void run(String... args) throws Exception {

        String kamilpie12 = passwordEncoder.encode("Kamilpie12");
        userRepository.save(new User("Kamil@o2.pl",
                kamilpie12,
                "Gdansk",
                "Dragana",
                "mail",
                Role.ROLE_ADMIN));

        userRepository.save(new User("Pamil@o2.pl", kamilpie12, "Gdansk", "Dragana", "mail",
                Role.ROLE_USER));



        authorRepository.save(new Author("Kamil Jastrzembowski", List.of()));
        Author kamil_pieniążek = authorRepository.save(new Author("Kamil Pieniążek", List.of()));
        Stock stock=stockRepository.save(new Stock());


        productRepository.save(new Product("Ksiazka", "Opis", new byte[]{}, "book", 34.0, ProductType.BOOK, kamil_pieniążek,10));
        productRepository.save(new Product("Gazeta", "Opis", new byte[]{}, "book", 34.0, ProductType.BOOK, kamil_pieniążek,  100));
        productRepository.save(new Product("Plyta", "Opis", new byte[]{}, "book", 34.0, ProductType.BOOK, kamil_pieniążek,100));

      //  OrderLine ksiazka = orderLineRepository.save(new OrderLine(null, "Ksiazka", 4L, 34.0, null));
//        orderRepository.save(new Order(null,"kamilpieniazek96@gmail.com",34.0,"Dupa","Dupa", ksiazka));
    }


}
