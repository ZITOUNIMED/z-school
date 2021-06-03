package z.school.administration.entities.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private Long id;
    private String firstname;
    private String lastname;
    private String role;

    public UserDTO(){

    }

    public UserDTO(String firstname, String lastname, String role){
        this.firstname = firstname;
        this.lastname = lastname;
        this.role = role;
    }
}
