package com.ISAProjekat.dusanm.mappers;

import com.ISAProjekat.dusanm.entities.Artikal;
import com.ISAProjekat.dusanm.models.ArtikalModel;

import java.util.ArrayList;
import java.util.List;

public class ArtikalMapper {
    public static Artikal toEntity(ArtikalModel model) {
        Artikal Artikal = new Artikal();
        Artikal.setId(model.getId());
        Artikal.setNaziv(model.getNaziv());
        Artikal.setSifra(model.getSifra());
        Artikal.setBarkod(model.getBarkod());
        return Artikal;
    }

    public static ArtikalModel toModel(Artikal entity) {
        return ArtikalModel.builder()
                .id(entity.getId())
                .naziv(entity.getNaziv())
                .sifra(entity.getSifra())
                .barkod(entity.getBarkod())
                .build();
    }

    public static List<ArtikalModel> toModelList(List<Artikal> entities) {
        var list = new ArrayList<ArtikalModel>();
        for (var entity : entities) {
            list.add(toModel(entity));
        }
        return list;
    }

}
