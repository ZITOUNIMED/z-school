package z.school.administration.rest;

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

import z.school.administration.entities.data.ClasseAffectation;
import z.school.administration.reactive.services.UsersReactiveService;
import z.school.administration.repositories.ClasseAffectationsRepository;
import z.school.administration.utils.ClassesEnum;

@RestController
@RequestMapping("/z-school-administration/api/classe-affectations")
public class ClasseAffectationsController {

    @Autowired
    private ClasseAffectationsRepository repository;

    @Autowired
    private UsersReactiveService usersReactiveService;

    @GetMapping({"", "/"})
    public ResponseEntity<List<ClasseAffectation>> findAll(){
        List<ClasseAffectation> list = Streamable.of(repository.findAll()).toList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<ClasseAffectation> add(@RequestBody ClasseAffectation entity){
        if(entity!=null){
            entity.setId(null);
        }

        if(Enum.valueOf(ClassesEnum.class, entity.getClasseKey()) == null){
            throw new RuntimeException("Classe not found.");
        }

        if(usersReactiveService.findById(entity.getUserId()) == null){
            throw new RuntimeException("User not found.");
        }

        return new ResponseEntity<>(repository.save(entity), HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<ClasseAffectation> edit(@PathVariable("id") Long id, @RequestBody ClasseAffectation p){
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
}
