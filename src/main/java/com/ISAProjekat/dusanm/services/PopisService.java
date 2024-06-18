package com.ISAProjekat.dusanm.services;

import com.ISAProjekat.dusanm.entities.Popis;
import com.ISAProjekat.dusanm.exceptions.user.UserAlreadyExistException;
import com.ISAProjekat.dusanm.exceptions.user.UserException;
import com.ISAProjekat.dusanm.mappers.PopisMapper;
import com.ISAProjekat.dusanm.models.PopisModel;
import com.ISAProjekat.dusanm.repositories.IPopisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

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
    public PopisModel create(PopisModel model) {
        var popis = PopisMapper.toEntity(model);

        var existingPopis = popisRepository.findByDate(model.getDatum());

        if (existingPopis.isPresent())
            throw new UserAlreadyExistException("Popis sa datumom " + model.getDatum() + " already exists");

        var savedUser = popisRepository.save(popis);

        return PopisMapper.toModel(savedUser);
    }

    @Override
    public PopisModel update(PopisModel model) {
        var entity = PopisMapper.toEntity(model);
        try {
            var result = popisRepository.save(entity);
            return PopisMapper.toModel(result);
        } catch (Exception e) {
            throw new UserException(e.getMessage());
        }
    }


    public void delete(Integer popisID) {
        var entity = popisRepository.findById(popisID).orElseThrow(() -> new UserException("Popis Not Found"));
        popisRepository.delete(entity);
    }
}
