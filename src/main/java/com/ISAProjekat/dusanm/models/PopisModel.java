package com.ISAProjekat.dusanm.models;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class PopisModel {
    private int id;
    private String naziv;
    private String napomena;
    private Boolean active;
    private int userID;
}