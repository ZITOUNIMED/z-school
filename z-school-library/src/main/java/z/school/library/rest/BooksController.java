package z.school.library.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import z.school.library.entities.Book;
import z.school.library.repositories.BooksRepository;

@CrossOrigin
@RestController
@RequestMapping("/z-school-library/api/books")
public class BooksController {

    @Autowired
    private BooksRepository repository;

    @GetMapping({"", "/"})
    public ResponseEntity<List<Book>> findAll(){
        List<Book> persons = Streamable.of(repository.findAll()).toList();
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Book> add(@RequestBody Book entity){
        if(entity!=null){
            entity.setId(null);
        }
        return new ResponseEntity<>(repository.save(entity), HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Book> edit(@PathVariable("id") Long id, @RequestBody Book entity){
        if(repository.findById(id)!=null){
            return new ResponseEntity<>(repository.save(entity), HttpStatus.ACCEPTED);
        }
        throw new RuntimeException("There is no element found with this ID.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        repository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
