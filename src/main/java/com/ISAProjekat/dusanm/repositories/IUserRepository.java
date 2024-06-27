package com.ISAProjekat.dusanm.repositories;

import com.ISAProjekat.dusanm.entities.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);

    @Query(nativeQuery = true, value = "SELECT * FROM users WHERE first_name LIKE (%:firstName%)")
    List<User> findAllByFirstName(@Param("firstName") String firstName);
    @Query(nativeQuery = true, value = "SELECT IFNULL((SELECT 1 FROM users u INNER JOIN user_roles ur ON u.id = ur.user_id WHERE u.id = (%:userID%) AND ur.role_id = (%:roleID%) LIMIT 1), 0)")
    Integer hasRole(@Param("userID") Integer userID, @Param("roleID") Integer roleID);
    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "DELETE FROM user_roles WHERE user_id = (%:userID%)")
    void deleteRoles(@Param("userID") Integer userID);
    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "INSERT INTO user_roles(user_id, role_id) VALUES((%:userID%), (%:roleID%))")
    Integer insertRole(@Param("userID") Integer userID, @Param("roleID") Integer roleID);
}