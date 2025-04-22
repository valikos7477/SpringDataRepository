package com.SpringDataRrepository.Repositiry;

import com.SpringDataRrepository.demo.Entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserCrudRepository extends CrudRepository<User, Long> {
    User findByName(String name);
}