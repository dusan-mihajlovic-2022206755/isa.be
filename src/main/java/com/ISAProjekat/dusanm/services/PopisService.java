package com.ISAProjekat.dusanm.services;

import com.ISAProjekat.dusanm.entities.PopisUser;
import com.ISAProjekat.dusanm.exceptions.user.PopisException;
import com.ISAProjekat.dusanm.exceptions.user.UserAlreadyExistException;
import com.ISAProjekat.dusanm.exceptions.user.UserException;
import com.ISAProjekat.dusanm.mappers.PopisMapper;
import com.ISAProjekat.dusanm.models.PopisModel;
import com.ISAProjekat.dusanm.models.PopisPageModel;
import com.ISAProjekat.dusanm.repositories.IPopisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PopisService implements IPopisService {
    private final IPopisRepository popisRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public List<PopisModel> findAll() {
        var result = popisRepository.findAll();
        return PopisMapper.toModelList(result);
    }
    @Override
    public PopisPageModel findPagedList(int userID, PageRequest pageRequest) {
        var result = popisRepository.findByUser(userID, pageRequest);

        return PopisMapper.toModelPagedList(result);
    }
    @Override
    public PopisModel create(PopisModel model) {
        var popis = PopisMapper.toEntity(model);
        var existingPopis = popisRepository.findByNaziv(model.getNaziv());

        if (existingPopis.isPresent())
            throw new PopisException("Popis sa nazivom " + model.getNaziv() + " već postoji!");

        var savedPopis = popisRepository.save(popis);

        model.setId(savedPopis.getId());
        unosUsersPopisTabelu(savedPopis.getId(), model.getUserID());

        return PopisMapper.toModel(savedPopis);
    }

    private void unosUsersPopisTabelu(int popisID, int userID) {
        try {
            popisRepository.deleteUserPopis(popisID);
            popisRepository.insertUserPopis(userID, popisID);
        } catch (Exception e) {
            throw new PopisException(e.getMessage());
    }
    }

    @Override
    public PopisModel update(PopisModel model) {
        var entity = PopisMapper.toEntity(model);
        try {
            var result = popisRepository.save(entity);
            unosUsersPopisTabelu(result.getId(), model.getUserID());
            return PopisMapper.toModel(result);
        } catch (Exception e) {
            throw new PopisException(e.getMessage());
        }
    }


    public void delete(Integer popisID) {
        var entity = popisRepository.findById(popisID).orElseThrow(() -> new UserException("Popis Not Found"));
        popisRepository.delete(entity);
    }
}