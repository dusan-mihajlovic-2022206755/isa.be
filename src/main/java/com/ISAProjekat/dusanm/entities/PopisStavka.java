package com.ISAProjekat.dusanm.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "popis_stavka")
@Data
public class PopisStavka {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "id_artikal")
    private Integer artikalID;

    @Column(name = "id_popis")
    private Integer popisID;

    @Column(name = "id_user")
    private Integer userID;

    @Column(name = "kolicina")
    private Integer kolicina;

    @Column(name = "vreme_popisivanja")
    private Date vremePopisivanja;
}
