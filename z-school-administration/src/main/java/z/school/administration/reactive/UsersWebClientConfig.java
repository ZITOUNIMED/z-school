package z.school.administration.reactive;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class UsersWebClientConfig {
    @Value("${users-server-url}")
	private String usersServerUrl;

    @Bean("usersWebClient")
    public WebClient createWebClient(){
        WebClient webClient = WebClient.builder()
            .baseUrl(usersServerUrl)
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .build();

        return webClient;
    }
}
