package com.ISAProjekat.dusanm.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "popis")
@Data
public class Popis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "naziv")
    private String naziv;
    @Column(name = "napomena")
    private String napomena;
    @Column(name = "active")
    private Boolean aktivan;

    @ManyToMany
    @JoinTable(
            name = "users_popis",
            joinColumns = @JoinColumn(name = "id_popis"),
            inverseJoinColumns = @JoinColumn(name = "id_users")
    )
    private List<User> users;

    @OneToMany(mappedBy = "popis")
    private List<PopisStavka> popisStavke;
}