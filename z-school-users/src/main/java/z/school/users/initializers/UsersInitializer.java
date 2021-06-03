package z.school.users.initializers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Component;

import z.school.users.entities.User;
import z.school.users.repositories.UsersRepository;
import z.school.users.utils.UsersRolesEnum;


@Component
@Order(1)
public class UsersInitializer implements ApplicationRunner {
    private final Logger LOGGER = LoggerFactory.getLogger(UsersInitializer.class);

    @Autowired
    private UsersRepository repository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        LOGGER.info("Initialize users ...");

        Streamable.of("Samir Zmertni", "Med Zitouni")
        .map(name -> new User(name.split(" ")[0], name.split(" ")[1], UsersRolesEnum.PROFESSOR.name()))
        .map(user -> repository.save(user))
        .forEach(res -> {
            LOGGER.info("New Proffessor was added with ID: " + res.getId());
        });

        Streamable.of("Ahmed ZITOUNI", "Salah Mizouri", "Kamal Labyadh", "Jamila Hchaychi", "Safa Ghdemssi")
        .map(name -> new User(name.split(" ")[0], name.split(" ")[1], UsersRolesEnum.STUDENT.name()))
        .map(user -> repository.save(user))
        .forEach(res -> {
            LOGGER.info("New Student was added with ID: " + res.getId());
        });
    }
}