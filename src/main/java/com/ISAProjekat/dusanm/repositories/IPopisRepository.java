package com.ISAProjekat.dusanm.repositories;

import com.ISAProjekat.dusanm.entities.Popis;
import com.ISAProjekat.dusanm.entities.Product;
import com.ISAProjekat.dusanm.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IPopisRepository extends JpaRepository<Popis, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM popis WHERE datum LIKE (%:datum%)")
    Optional<Popis> findByDate(@Param("datum") Date date);
    @Query(nativeQuery = true, value = "SELECT * FROM users WHERE id = (%:id%)")
    List<Popis> findByUser(@Param("id") int id);
}
