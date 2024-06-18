package com.ISAProjekat.dusanm.models;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PopisStavkaPageModel {
    private List<PopisStavkaModel> ListPopisStavka;
    private int totalPages;
    private Long totalElements;
}
