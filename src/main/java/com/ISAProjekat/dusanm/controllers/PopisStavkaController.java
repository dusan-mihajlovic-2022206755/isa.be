package com.ISAProjekat.dusanm.controllers;

import com.ISAProjekat.dusanm.entities.PopisStavka;
import com.ISAProjekat.dusanm.repositories.IPopisStavkaRepository;
import com.ISAProjekat.dusanm.services.IPopisService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("popis-stavka")
@RequiredArgsConstructor
@CrossOrigin("*")
public class PopisStavkaController {
    private final IPopisStavkaRepository popisStavkaRepository;

//    @GetMapping("get-list")
//    public List<PopisStavka> getList() {
//        return popisStavkaRepository.findAll();
//    }

    @GetMapping("get-list-by-popis-id")
    public List<PopisStavka> getListByPopisID(int popisID) {
        return popisStavkaRepository.findByPopisID(popisID);
    }
}