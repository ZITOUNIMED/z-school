package z.school.library.initializers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import z.school.library.entities.Book;
import z.school.library.repositories.BooksRepository;

@Component
@Order(1)
public class BooksInitializer implements ApplicationRunner {
    private final Logger LOGGER = LoggerFactory.getLogger(BooksInitializer.class);

    @Autowired
    private BooksRepository repository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        LOGGER.info("Initilize books ...");
        
        Book b1 = new Book();
        b1.setAuthor("Med ZITOUNI");
        b1.setPrice(26);
        b1.setRef("Java in action");
        repository.save(b1);
        
        Book b2 = new Book();
        b2.setAuthor("Kamel Hamrouni");
        b2.setPrice(26);
        b2.setRef("La loi de la vie");
        repository.save(b2);

        Book b3 = new Book();
        b3.setAuthor("Samir Zmertni");
        b3.setPrice(10);
        b3.setRef("Life in the jungle");
        repository.save(b3);
    }
}