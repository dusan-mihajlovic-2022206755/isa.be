package com.ISAProjekat.dusanm.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users_popis")
@Data
public class PopisUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "id_users")
    private int userID;
    @Column(name = "id_popis")
    private int popisID;
}