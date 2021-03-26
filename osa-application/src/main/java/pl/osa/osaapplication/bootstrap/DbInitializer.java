package pl.osa.osaapplication.bootstrap;

import lombok.RequiredArgsConstructor;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import pl.osa.osaapplication.domain.*;
import pl.osa.osaapplication.model.ProductType;
import pl.osa.osaapplication.model.Role;
import pl.osa.osaapplication.repositories.*;


import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Collections;
import java.util.HashSet;
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

//        EntityManager entityManager= Persistence.createEntityManagerFactory("DbInitializer").createEntityManager();
//
//        entityManager.getTransaction().begin();


        String kamilpie12 = passwordEncoder.encode("Kamilpie12");

        User u1 = new User(1L, "Kamil@o2.pl",
                kamilpie12,
                "Gdansk",
                "Dragana",
                "mail",
                null,
                Role.ROLE_ADMIN,
                Collections.emptySet());
//        Address a1 = new Address(null, "a", "s", "d", "", "s",u1);
//        u1.getAddresses().add(a1);

//        entityManager.persist(u1);
//        entityManager.persist(a1);
//        entityManager.getTransaction().commit();
//        entityManager.close();

        userRepository.save(new User(2L, "Pamil@o2.pl", kamilpie12, "Gdansk", "Dragana", "mail", null,
                Role.ROLE_USER,
                Collections.emptySet()));


        authorRepository.save(new Author("Kamil Jastrzembowski", List.of()));
        Author kamil_pieniążek = authorRepository.save(new Author("Kamil Pieniążek", List.of()));
        Author remigiusz_mroz = authorRepository.save(new Author("Remigiusz Mróz", List.of()));
        Stock stock = stockRepository.save(new Stock());

        productRepository.save(
                new Product("Kasacja. Joanna Chyłka. Tom 1",
                        "Świetna książka znanego polskiego pisarza, Remigiusza Mroza. Autor tym razem opisuje bezwzględny prawniczy świat, pełen intryg i manipulacji.",
                        readImage("src/main/resources/static/images/chylka_kasacja.jpg"),
                        "book",
                        34.0,
                        ProductType.BOOK,
                        kamil_pieniążek,
                        100));
        productRepository.save(
                new Product("Zaginięcie. Joanna Chyłka. Tom 2",
                        "Chyłka. Zaginięcie to bestsellerowy thriller prawniczy od Remigiusza Mroza. Przenieś się w świat prawniczych intryg, wielkich ambicji i trudnych spraw.",
                        readImage("src/main/resources/static/images/chylka_zaginiecie.jpg"),
                        "book",
                        34.0,
                        ProductType.BOOK,
                        kamil_pieniążek,
                        100));
        productRepository.save(
                new Product("Rewizja. Joann Chylka. Tom 3",
                        "Rewizja jest trzecim tomem popularnej serii Remigiusza Mroza opisującym sprawę, w którą zamieszana jest Joanna Chyłka.",
                        readImage("src/main/resources/static/images/chylka_zaginiecie.jpg"),
                        "book",
                        34.0,
                        ProductType.BOOK,
                        kamil_pieniążek,
                        100));
        productRepository.save(
                new Product("Immunitet. Joann Chylka. Tom 4",
                        "Immunitet, sensacyjna powieść kryminalna Remigiusza Mroza. Thriller prawniczy stanowiący czwartą część bestsellerowej serii opowiadającej o przygodach Joanny Chyłki i Kordiana Oryńskiego.",
                        readImage("src/main/resources/static/images/chylka_immunitet.jpg"),
                        "book",
                        34.0,
                        ProductType.BOOK,
                        kamil_pieniążek,
                        100));

    }

    public byte[] readImage(String filePath) throws IOException {
        BufferedImage read = ImageIO.read(new File(filePath));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(read, "jpg", byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();

    }


}
