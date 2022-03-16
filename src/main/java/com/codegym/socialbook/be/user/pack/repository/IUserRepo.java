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

//    @Query(nativeQuery = true, value = "select u.* from users u join user_role ur on u.id = ur.user_id where ur.role_id=2 and u.status=1 and u.name like %:name%")
//    List<Users> findAllByNameContaining(@Param("name") String name);
//
//    @Query(nativeQuery = true, value = "select u.* from users u join user_role ur on u.id = ur.user_id where ur.role_id=2 and u.status=1 and u.age <= :maxAge and u.age >= :minAge")
//    List<Users> findAllByAgeContaining(@Param("maxAge") int maxAge, @Param("minAge") int minAge);
//
//    @Query(nativeQuery = true, value = "select u.* from users u join user_role ur on u.id = ur.user_id where ur.role_id=2 and u.status=1 and u.city like %:city%")
//    List<Users> findAllByCityContaining(@Param("city") String city);
//
//    @Query(nativeQuery = true, value = "select u.* from users u join user_role ur on u.id = ur.user_id where ur.role_id=2 and u.status=1 and u.gender like %:gender%")
//    List<Users> findAllByGenderContaining(@Param("gender") String gender);

    @Query(nativeQuery = true, value = "select u.* from users u join user_role ur on u.id = ur.user_id where ur.role_id=2 and u.status=1 and ( u.age <= :maxAge and u.age >=:minAge or u.name like %:name% or u.city like %:city% or u.gender like %:gender%) ")
    Page<Users> searchProvider(@Param("maxAge") int maxAge, @Param("minAge") int minAge,@Param("name") String name,@Param("city") String city,@Param("gender") String gender,Pageable page);
}
