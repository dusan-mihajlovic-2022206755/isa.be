package com.ISAProjekat.dusanm.repositories;

import com.ISAProjekat.dusanm.entities.Popis;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.Optional;

public interface IPopisRepository extends JpaRepository<Popis, Integer> {
//    @Query(nativeQuery = true, value = "SELECT * FROM popis WHERE datum LIKE (%:datum%)")
//    Optional<Popis> findByDate(@Param("datum") Date date);
    @Query(nativeQuery = true, value = "SELECT * FROM popis WHERE naziv LIKE (%:naziv%)")
    Optional<Popis> findByNaziv(@Param("naziv") String naziv);
    @Query(nativeQuery = true, value = "SELECT p.* FROM popis p INNER JOIN users_popis up ON p.id = up.id_popis WHERE up.id_users = (%:id_user%)")
    Page<Popis> findByUser(@Param("id_user") int id_user, Pageable pageable);
}