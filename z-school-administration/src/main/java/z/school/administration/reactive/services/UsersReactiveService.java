package z.school.administration.reactive.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;
import z.school.administration.entities.dto.UserDTO;

@Service
public class UsersReactiveService {
    private String apiUrl = "/z-school-users/api/users";
    private final static Logger LOGGER = LoggerFactory.getLogger(UsersReactiveService.class);

    @Autowired
    @Qualifier("usersWebClient")
    private WebClient usersWebClient;

    public Mono<UserDTO> addUser(UserDTO entity){
        return usersWebClient.post()
        .uri(apiUrl + "/add")
        .body(Mono.just(entity), UserDTO.class)
        .retrieve()
        .onStatus(HttpStatus::is4xxClientError, response -> {
            LOGGER.error("4xx error");
            return Mono.error(new RuntimeException("4xx"));
          })
          .onStatus(HttpStatus::is5xxServerError, response -> {
            LOGGER.error("5xx error");
            return Mono.error(new RuntimeException("5xx"));
          })
        .bodyToMono(UserDTO.class);
    }

    public Mono<UserDTO> findById(Long id){
        return usersWebClient.get()
        .uri(apiUrl + "/" + id)
        .retrieve()
        .onStatus(HttpStatus::is4xxClientError, response -> {
            LOGGER.error("4xx error");
            return Mono.error(new RuntimeException("4xx"));
          })
          .onStatus(HttpStatus::is5xxServerError, response -> {
            LOGGER.error("5xx error");
            return Mono.error(new RuntimeException("5xx"));
          })
        .bodyToMono(UserDTO.class);
    }
}
