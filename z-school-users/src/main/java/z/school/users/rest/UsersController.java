package z.school.users.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import z.school.users.entities.User;
import z.school.users.repositories.UsersRepository;

@RestController
@RequestMapping("/z-school-users/api/users")
public class UsersController {

    @Autowired
    private UsersRepository repository;

    @GetMapping({"", "/"})
    public ResponseEntity<List<User>> findAll(){
        List<User> persons = Streamable.of(repository.findAll()).toList();
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<User> add(@RequestBody User entity){
        if(entity!=null){
            entity.setId(null);
        }
        return new ResponseEntity<>(repository.save(entity), HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<User> edit(@PathVariable("id") Long id, @RequestBody User p){
        if(repository.findById(id)!=null){
            return new ResponseEntity<>(repository.save(p), HttpStatus.ACCEPTED);
        }
        throw new RuntimeException("There is no element found with this ID.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        repository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") Long id){
        return new ResponseEntity<>(repository.findById(id).orElse(null), HttpStatus.OK);
    }
}
