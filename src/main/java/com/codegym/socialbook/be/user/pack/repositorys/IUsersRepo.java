package com.codegym.socialbook.be.user.pack.repositorys;

import com.codegym.socialbook.be.user.pack.model.Users;
import org.springframework.data.repository.CrudRepository;

public interface IUsersRepo extends CrudRepository<Users, Long> {
}
