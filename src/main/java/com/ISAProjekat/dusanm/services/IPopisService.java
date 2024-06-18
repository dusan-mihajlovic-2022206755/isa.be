package com.ISAProjekat.dusanm.services;
import com.ISAProjekat.dusanm.models.PopisModel;
import java.util.List;

public interface IPopisService {
    List<PopisModel> findAll();
    PopisModel create(PopisModel model);
    PopisModel update(PopisModel model);
    void delete(Integer popisStavkaID);
}