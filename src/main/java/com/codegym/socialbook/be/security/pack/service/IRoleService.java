package com.codegym.socialbook.be.security.pack.service;



import com.codegym.socialbook.be.security.pack.model.Role;
import com.codegym.socialbook.be.security.pack.model.RoleName;

import java.util.Optional;

public interface IRoleService {
    Optional<Role> findByName(RoleName name);
}
