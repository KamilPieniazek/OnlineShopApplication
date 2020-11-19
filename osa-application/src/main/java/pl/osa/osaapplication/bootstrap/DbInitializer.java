package pl.osa.osaapplication.bootstrap;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import pl.osa.osaapplication.domain.*;
import pl.osa.osaapplication.model.ProductType;
import pl.osa.osaapplication.repositories.*;

import java.util.List;

@Component
@RequiredArgsConstructor
@Transactional
public class DbInitializer implements CommandLineRunner  {
    @Value("test@test.com")
    private String email;
    private final UserRepository userRepository;

    private final AuthorRepository authorRepository;

    private  final ProductRepository productRepository;

    private final OrderRepository orderRepository;

    private final OrderLineRepository orderLineRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.save(new User("Kamil@o2.pl","kamil12","Gdansk","Dragana","mail",
                List.of(new Role("Admin","Admin group",List.of()))));

        authorRepository.save(new Author("Kamil Jastrzembowski",List.of()));
        Author kamil_pieniążek = authorRepository.save(new Author("Kamil Pieniążek", List.of()));


        productRepository.save(new Product("Ksiazka","Opis", new byte[]{},"book", 34.0, ProductType.BOOK,kamil_pieniążek,1L));

        OrderLine ksiazka = orderLineRepository.save(new OrderLine(null, "Ksiazka", 4L, 34.0, List.of()));
//        orderRepository.save(new Order(null,"kamilpieniazek96@gmail.com",34.0,"Dupa","Dupa", ksiazka));
    }



}
