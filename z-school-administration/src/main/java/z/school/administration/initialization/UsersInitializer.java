package z.school.administration.initialization;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Component;

import z.school.administration.entities.dto.UserDTO;
import z.school.administration.reactive.services.UsersReactiveService;
import z.school.administration.utils.UsersRolesEnum;

@Component
@Order(1)
public class UsersInitializer implements ApplicationRunner{
    private final static Logger LOGGER = LoggerFactory.getLogger(UsersInitializer.class);

    @Autowired
    private UsersReactiveService service;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        LOGGER.info("Initialize users ...");

        try {
            Streamable.of("Samir Zmertni", "Med Zitouni")
            .map(name -> new UserDTO(name.split(" ")[0], name.split(" ")[1], UsersRolesEnum.PROFESSOR.name()))
            .map(userDto -> service.addUser(userDto))
            .forEach(mono -> {
                mono.subscribe(res -> {
                    LOGGER.info("New Proffessor was added with ID: " + res.getId());
                });
            });

            service.addUser(new UserDTO("", "", UsersRolesEnum.PROFESSOR.name()))
            .subscribe(res -> {
                LOGGER.info("New Proffessor was added with ID: " + res.getId());
            });

            Streamable.of("Ahmed ZITOUNI", "Salah Mizouri", "Kamal Labyadh", "Jamila Hchaychi", "Safa Ghdemssi")
            .map(name -> new UserDTO(name.split(" ")[0], name.split(" ")[1], UsersRolesEnum.STUDENT.name()))
            .map(userDto -> service.addUser(userDto))
            .forEach(mono -> {
                mono.subscribe(res -> {
                    LOGGER.info("New Student was added with ID: " + res.getId());
                });
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
