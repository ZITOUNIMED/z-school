package z.school.users.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import z.school.users.entities.User;

@Repository
public interface UsersRepository extends CrudRepository<User, Long>{
    
}
