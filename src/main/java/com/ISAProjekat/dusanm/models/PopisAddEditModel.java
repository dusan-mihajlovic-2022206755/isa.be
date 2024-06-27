package com.ISAProjekat.dusanm.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PopisAddEditModel extends PopisModel{
    private int userID;
}