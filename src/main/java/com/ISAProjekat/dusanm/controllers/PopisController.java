package com.ISAProjekat.dusanm.controllers;

import com.ISAProjekat.dusanm.entities.Popis;
import com.ISAProjekat.dusanm.repositories.IPopisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("popis")
@RequiredArgsConstructor
@CrossOrigin("*")
public class PopisController {
    private final IPopisRepository popisRepository;

    @GetMapping("get-list-by-user")
    public List<Popis> getList(int id) {
        return popisRepository.findByUser(id);
    }
}
