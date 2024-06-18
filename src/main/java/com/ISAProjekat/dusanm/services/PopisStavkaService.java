package com.ISAProjekat.dusanm.services;

import com.ISAProjekat.dusanm.entities.PopisStavka;
import com.ISAProjekat.dusanm.exceptions.user.UserAlreadyExistException;
import com.ISAProjekat.dusanm.exceptions.user.UserException;
import com.ISAProjekat.dusanm.mappers.PopisStavkaMapper;
import com.ISAProjekat.dusanm.models.PopisStavkaModel;
import com.ISAProjekat.dusanm.repositories.IPopisStavkaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PopisStavkaService implements IPopisStavkaService {
    private final IPopisStavkaRepository popisStavkaRepository;

    @Override
    public List<PopisStavkaModel> findAll() {
        var result = popisStavkaRepository.findAll();
        return PopisStavkaMapper.toModelList(result);
    }
    @Override
    public PopisStavkaModel create(PopisStavkaModel model) {
        var popisStavka = PopisStavkaMapper.toEntity(model);

        var stavkaPostojiNaPopisu = popisStavkaRepository.checkIfExists(model.getArtikalID(), model.getPopisID());
        if (!stavkaPostojiNaPopisu) {
            popisStavka.setVremePopisivanja(new Date());
            //staviti ulogovanog user-a

        }
        else{
            throw new UserAlreadyExistException("PopisStavka već postoji");
        }
        var savedStavka = popisStavkaRepository.save(popisStavka);
        return PopisStavkaMapper.toModel(savedStavka);
    }

    @Override
    public PopisStavkaModel update(PopisStavkaModel model) {
        var entity = PopisStavkaMapper.toEntity(model);
        try {
            var result = popisStavkaRepository.save(entity);
            return PopisStavkaMapper.toModel(result);
        } catch (Exception e) {
            throw new UserException(e.getMessage());
        }
    }


    public void delete(Integer PopisStavkaID) {
        var entity = popisStavkaRepository.findById(PopisStavkaID).orElseThrow(() -> new UserException("PopisStavka Not Found"));
        popisStavkaRepository.delete(entity);
    }

    @Override
    public List<PopisStavkaModel> findByUserAndPopis(int userID, int popisID) {
        return PopisStavkaMapper.toModelList(popisStavkaRepository.findByUserAndPopisID(userID, popisID));
    }
}