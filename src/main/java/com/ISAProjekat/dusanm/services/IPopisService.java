package com.ISAProjekat.dusanm.services;
import com.ISAProjekat.dusanm.models.PopisModel;
import com.ISAProjekat.dusanm.models.PopisPageModel;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface IPopisService {
    List<PopisModel> findAll();
    PopisModel create(PopisModel model);
    PopisModel update(PopisModel model);
    void delete(Integer popisStavkaID);
    PopisPageModel findPagedList(int userID, PageRequest pageRequest);
}