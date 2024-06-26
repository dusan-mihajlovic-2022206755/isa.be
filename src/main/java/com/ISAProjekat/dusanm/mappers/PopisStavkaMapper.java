package com.ISAProjekat.dusanm.mappers;

import com.ISAProjekat.dusanm.entities.Popis;
import com.ISAProjekat.dusanm.entities.PopisStavka;
import com.ISAProjekat.dusanm.models.PopisStavkaModel;
import com.ISAProjekat.dusanm.models.PopisStavkaPageModel;
import com.ISAProjekat.dusanm.repositories.IPopisRepository;
import com.ISAProjekat.dusanm.repositories.ITokenRepository;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public class PopisStavkaMapper {
    public static PopisStavka toEntity(PopisStavkaModel model) {
        PopisStavka popisStavka = new PopisStavka();
        popisStavka.setId(model.getId());
        popisStavka.setArtikalID(model.getArtikalID());
        popisStavka.setUserID(model.getUserID());
        popisStavka.setKolicina(model.getKolicina());
        popisStavka.setVremePopisivanja(model.getVremePopisivanja());
//        Popis popis = fetchPopisById(model.getPopisID()); // Replace with your actual method to fetch Popis
//        popisStavka.setPopis(popis);
        return popisStavka;
    }

    public static PopisStavkaModel toModel(PopisStavka entity) {
        return PopisStavkaModel.builder()
                .id(entity.getId())
                .artikalID(entity.getArtikalID())
                .userID(entity.getUserID())
                .kolicina(entity.getKolicina())
                .vremePopisivanja(entity.getVremePopisivanja())
                .build();
    }

    public static List<PopisStavkaModel> toModelList(List<PopisStavka> entities) {
        var list = new ArrayList<PopisStavkaModel>();
        for (var entity : entities) {
            list.add(toModel(entity));
        }
        return list;
    }

    public static PopisStavkaPageModel toModelPagedList(Page<PopisStavka> pageEntity) {
        return PopisStavkaPageModel.builder()
                .ListPopisStavka(toModelList(pageEntity.getContent()))
                .totalPages(pageEntity.getTotalPages())
                .totalElements(pageEntity.getTotalElements())
                .build();
    }


}