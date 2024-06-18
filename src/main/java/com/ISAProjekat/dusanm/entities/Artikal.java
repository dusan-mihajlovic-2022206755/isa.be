package com.ISAProjekat.dusanm.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "artikal")
@Data
public class Artikal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "naziv")
    private String naziv;
    @Column(name = "barkod")
    private String barkod;
    @Column(name = "sifra")
    private String sifra;
}
