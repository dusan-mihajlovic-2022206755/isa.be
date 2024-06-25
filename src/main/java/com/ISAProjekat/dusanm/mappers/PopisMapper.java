package com.ISAProjekat.dusanm.mappers;

import com.ISAProjekat.dusanm.entities.Popis;
import com.ISAProjekat.dusanm.models.PopisModel;
import com.ISAProjekat.dusanm.models.PopisPageModel;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public class PopisMapper {
    public static Popis toEntity(PopisModel model) {
        Popis Popis = new Popis();
        Popis.setId(model.getId());
        Popis.setNaziv(model.getNaziv());
        Popis.setNapomena(model.getNapomena());
        Popis.setAktivan(model.getActive());
        return Popis;
    }

    public static PopisModel toModel(Popis entity) {
        return PopisModel.builder()
                .id(entity.getId())
                .naziv(entity.getNaziv())
                .napomena(entity.getNapomena())
                .active(entity.getAktivan())
                .build();
    }

    public static List<PopisModel> toModelList(List<Popis> entities) {
        var list = new ArrayList<PopisModel>();
        for (var entity : entities) {
            list.add(toModel(entity));
        }
        return list;
    }

    public static PopisPageModel toModelPagedList(Page<Popis> pageEntity) {
        return PopisPageModel.builder()
                .ListPopis(toModelList(pageEntity.getContent()))
                .totalPages(pageEntity.getTotalPages())
                .totalElements(pageEntity.getTotalElements())
                .build();
    }


}