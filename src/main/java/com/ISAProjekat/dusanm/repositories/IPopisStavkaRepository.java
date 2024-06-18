package com.ISAProjekat.dusanm.repositories;

import com.ISAProjekat.dusanm.entities.PopisStavka;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPopisStavkaRepository extends JpaRepository<PopisStavka, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM popis_stavka WHERE id_popis = (%:id_popis%)")
    List<PopisStavka> findByPopisID(@Param("id_popis") int popisID);
    @Query(nativeQuery = true, value = "SELECT * FROM popis_stavka WHERE id_artikal = (%:id_artikal%) AND id_popis = (%:id_popis%)")
    Boolean checkIfExists(@Param("id_artikal") int artikalID, @Param("id_popis") int popisID);
    @Query(nativeQuery = true, value = "SELECT * FROM popis_stavka WHERE id_user = (%:id_user%) AND id_popis = (%:id_popis%)")
    List<PopisStavka> findByUserAndPopisID(@Param("id_user") int userID, @Param("id_popis") int popisID);
}