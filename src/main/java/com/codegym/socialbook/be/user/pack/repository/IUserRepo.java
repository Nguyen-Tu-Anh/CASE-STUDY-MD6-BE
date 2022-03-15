package com.codegym.socialbook.be.user.pack.repository;

import com.codegym.socialbook.be.user.pack.model.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepo extends JpaRepository<Users, Long> {
    @Query(nativeQuery = true, value = "select u.* from users u join user_role ur on u.id = ur.user_id where ur.role_id=2 and u.status=1 order by u.start_date desc")
//    @Query(value = "select u from Users u where ")
    Page<Users> find12lProvidersSortByStartDate(Pageable page);

    @Query(nativeQuery = true, value = "select u.* from users u join user_role ur on u.id = ur.user_id where ur.role_id=2 and u.status=1 order by u.count_of_date desc")
    Page<Users> find12MostDatedProvider(Pageable page);


    List<Users> findAllByNameContaining(String name);

    List<Users> findAllByAgeContaining(int age);

    List<Users> findAllByCityContaining(String city);

    List<Users> findAllByGenderContaining(String gender);
}
