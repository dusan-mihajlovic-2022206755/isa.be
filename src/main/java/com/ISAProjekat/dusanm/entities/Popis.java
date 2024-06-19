package com.ISAProjekat.dusanm.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "popis")
@Data
public class Popis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "datum")
    private Date datum;
    @Column(name = "napomena")
    private String napomena;
    @Column(name = "active")
    private Boolean aktivan;
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "product_categories",
//            joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"))
}