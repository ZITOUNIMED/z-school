package z.school.administration.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import z.school.administration.entities.data.ClasseAffectation;

@Repository
public interface ClasseAffectationsRepository extends CrudRepository<ClasseAffectation, Long>{
    
}
