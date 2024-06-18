package com.ISAProjekat.dusanm.models;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ArtikalModel {
    private int id;
    private String naziv;
    private String sifra;
    private String barkod;

}
