package z.school.library.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import z.school.library.entities.Book;

@Repository
public interface BooksRepository extends CrudRepository<Book, Long>{
    
}
