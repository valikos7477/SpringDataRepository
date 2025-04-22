package com.SpringDataRrepository.Repositiry;

import com.SpringDataRrepository.demo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<User, Long> {
    User findByName(String name);
}
