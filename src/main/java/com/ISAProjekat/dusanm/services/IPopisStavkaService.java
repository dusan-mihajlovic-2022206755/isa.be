package com.ISAProjekat.dusanm.services;

import com.ISAProjekat.dusanm.models.PopisStavkaModel;

import java.util.List;

public interface IPopisStavkaService {
    List<PopisStavkaModel> findAll();
    PopisStavkaModel create(PopisStavkaModel model);
    PopisStavkaModel update(PopisStavkaModel model);
    void delete(Integer popisStavkaID);
    List<PopisStavkaModel> findByUserAndPopis(int userID, int popisID);
}