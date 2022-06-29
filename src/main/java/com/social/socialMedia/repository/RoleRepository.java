package com.social.socialMedia.repository;

import com.social.socialMedia.model.ERole;
import com.social.socialMedia.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(ERole name);
}
