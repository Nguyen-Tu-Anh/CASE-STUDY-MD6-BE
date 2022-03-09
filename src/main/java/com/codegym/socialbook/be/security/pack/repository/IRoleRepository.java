package com.codegym.socialbook.be.security.pack.repository;

import com.codegym.socialbook.be.security.pack.model.Role;
import com.codegym.socialbook.be.security.pack.model.RoleName;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName name);
}
