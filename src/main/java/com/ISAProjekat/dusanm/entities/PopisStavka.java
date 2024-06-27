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

    @Column(name = "barkod")
    private String barkod;

    @Column(name = "id_artikal")
    private Integer artikalID = 0;

    @Column(name = "naziv_artikla")
    private String nazivArtikla;

    @Column(name = "id_user")
    private Integer userID;

    @Column(name = "kolicina")
    private Integer kolicina;

    @Column(name = "vreme_popisivanja")
    private Date vremePopisivanja;

    @ManyToOne
    @JoinColumn(name = "id_popis")
    private Popis popis;
}