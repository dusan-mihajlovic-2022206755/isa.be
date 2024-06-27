package com.ISAProjekat.dusanm.models;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class PopisStavkaModel {
    private int id;
    private String barkod;
    private String nazivArtikla;
    private Integer userID;
    private Integer kolicina;
    private Integer popisID;
    private Date vremePopisivanja;
}