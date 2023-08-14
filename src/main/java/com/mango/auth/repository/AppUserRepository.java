package com.mango.auth.repository;

import com.mango.auth.model.AppUser;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AppUserRepository extends MongoRepository<AppUser, String> {
    AppUser findByUsername(String username);
}
