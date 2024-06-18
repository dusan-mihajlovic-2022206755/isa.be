package com.ISAProjekat.dusanm.models;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class PopisStavkaModel {

    private int id;
    private Integer artikalID;
    private Integer popisID;
    private Integer userID;
    private Integer kolicina;
    private Date vremePopisivanja;

}
