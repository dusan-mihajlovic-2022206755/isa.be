package com.ISAProjekat.dusanm.models;

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