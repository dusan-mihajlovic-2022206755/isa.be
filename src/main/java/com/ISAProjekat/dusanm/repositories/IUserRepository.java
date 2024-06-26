package com.ISAProjekat.dusanm.repositories;

import com.ISAProjekat.dusanm.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);

    @Query(nativeQuery = true, value = "SELECT * FROM users WHERE first_name LIKE (%:firstName%)")
    List<User> findAllByFirstName(@Param("firstName") String firstName);
    @Query(nativeQuery = true, value = "SELECT 1 FROM users u INNER JOIN user_roles ur ON u.id = ur.user_id WHERE u.id = (%:userID%) AND ur.role_id = (%:roleID%) LIMIT 1")
    Integer hasRole(@Param("userID") Integer userID, @Param("roleID") Integer roleID);
}