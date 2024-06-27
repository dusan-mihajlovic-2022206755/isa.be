package com.ISAProjekat.dusanm.controllers;

import com.ISAProjekat.dusanm.entities.Popis;
import com.ISAProjekat.dusanm.entities.PopisStavka;
import com.ISAProjekat.dusanm.mappers.PopisMapper;
import com.ISAProjekat.dusanm.mappers.PopisStavkaMapper;
import com.ISAProjekat.dusanm.models.PopisModel;
import com.ISAProjekat.dusanm.models.PopisStavkaModel;
import com.ISAProjekat.dusanm.models.PopisStavkaPageModel;
import com.ISAProjekat.dusanm.repositories.IPopisStavkaRepository;
import com.ISAProjekat.dusanm.services.IPopisService;
import com.ISAProjekat.dusanm.services.PopisStavkaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("popis-stavka")
@RequiredArgsConstructor
@CrossOrigin("*")
public class PopisStavkaController {
    private final IPopisStavkaRepository popisStavkaRepository;
    private final PopisStavkaService popisStavkaService;

//    @GetMapping("get-list")
//    public List<PopisStavka> getList() {
//        return popisStavkaRepository.findAll();
//    }

    @GetMapping("get-list-by-popis-id")
    public List<PopisStavka> getListByPopisID(int popisID) {
        return popisStavkaRepository.findByPopisID(popisID);
    }

    @GetMapping("get-page-list")
    public PopisStavkaPageModel getListByPopisID(Integer popisID, Integer pageNumber, Integer pageSize) {
        Page<PopisStavka> stavke = popisStavkaRepository.findByPopisID(popisID, PageRequest.of(pageNumber, pageSize));
        return PopisStavkaMapper.toModelPagedList(stavke);
    }

    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody @Valid PopisStavkaModel popisStavkaModel, BindingResult result) {
        return ResponseEntity.ok(popisStavkaService.create(popisStavkaModel));
    }

    @PostMapping("update")
    public ResponseEntity<?> update(@RequestBody @Valid PopisStavkaModel popisStavkaModel, Integer userID, BindingResult result) {
        try {
            if (result.hasErrors()) {
                return new ResponseEntity<>("Not updated!", HttpStatus.INTERNAL_SERVER_ERROR);
            }
            return ResponseEntity.ok(popisStavkaService.update(popisStavkaModel));
        }catch (Exception e){
            throw e;
        }
    }
    @PostMapping("delete")
    public ResponseEntity<?> delete(Integer popisStavkaID) {
        popisStavkaService.delete(popisStavkaID);
        return ResponseEntity.ok("");
    }
}