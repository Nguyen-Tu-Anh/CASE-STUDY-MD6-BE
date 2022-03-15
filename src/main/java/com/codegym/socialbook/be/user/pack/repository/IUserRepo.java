package com.codegym.socialbook.be.user.pack.repository;

import com.codegym.socialbook.be.user.pack.model.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepo extends JpaRepository<Users, Long> {
    @Query(nativeQuery = true, value = "select u.* from users u join user_role ur on u.id = ur.user_id where ur.role_id=2 and u.status=1 order by u.star_date desc")
//    @Query(value = "select u from Users u where ")
    Page<Users> find12lProvidersSortByStartDate(Pageable page);

    @Query(nativeQuery = true, value = "select u.* from users u join user_role ur on u.id = ur.user_id where ur.role_id=2 and u.status=1 order by u.count_of_date desc")
    Page<Users> find12MostDatedProvider(Pageable page);
}
