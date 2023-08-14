package com.mango.auth.repository;

import com.mango.auth.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<Role, String> {

    boolean existsByRole(Role.ERole name);

    Role findByRole(Role.ERole name);
}
