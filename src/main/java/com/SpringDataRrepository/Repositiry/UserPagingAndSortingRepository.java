package com.SpringDataRrepository.Repositiry;

import com.SpringDataRrepository.demo.Entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserPagingAndSortingRepository extends PagingAndSortingRepository<User, Long> {
    User findByName(String name);
}