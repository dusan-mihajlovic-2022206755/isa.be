package com.ISAProjekat.dusanm.models;

import com.ISAProjekat.dusanm.entities.Popis;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PopisPageModel {
    private List<PopisModel> ListPopis;
    private int totalPages;
    private Long totalElements;
}
