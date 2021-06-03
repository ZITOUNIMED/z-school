package z.school.users.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String firstname;
    private String lastname;
    private String role;

    public User(){

    }

    public User(String firstname, String lastname, String role){
        this.firstname = firstname;
        this.lastname = lastname;
        this.role = role;
    }
}
