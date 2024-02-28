package com.tlaxcala.repo;

import com.tlaxcala.model.User;

public interface IUserRepo extends org.springframework.data.jpa.repository.JpaRepository<User, Integer> {

    // derived queries
    User findOneByUsername(String username);
    
}
