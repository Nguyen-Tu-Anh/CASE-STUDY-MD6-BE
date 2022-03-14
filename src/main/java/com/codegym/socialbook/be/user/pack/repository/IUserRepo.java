package com.codegym.socialbook.be.user.pack.repository;

import com.codegym.socialbook.be.user.pack.model.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepo extends JpaRepository<Users, Long> {
    @Query("select u from Users u where u.role.id = 2 and u.status=2 order by u.startDate desc")
    Page<Users> find12lProvidersSortByStartDate(Pageable page);

    @Query("select u from Users u where u.username = :username")
    Users getUserByUserName(@Param("username") String username);
 }
