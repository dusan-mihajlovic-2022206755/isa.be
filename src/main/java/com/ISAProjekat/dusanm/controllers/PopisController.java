package com.ISAProjekat.dusanm.controllers;

import com.ISAProjekat.dusanm.entities.Popis;
import com.ISAProjekat.dusanm.entities.User;
import com.ISAProjekat.dusanm.enums.RoleEnum;
import com.ISAProjekat.dusanm.mappers.PopisMapper;
import com.ISAProjekat.dusanm.models.PopisModel;
import com.ISAProjekat.dusanm.models.PopisPageModel;
import com.ISAProjekat.dusanm.repositories.IPopisRepository;
import com.ISAProjekat.dusanm.repositories.IUserRepository;
import com.ISAProjekat.dusanm.services.PopisService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("popis")
@RequiredArgsConstructor
public class PopisController {
    private final IPopisRepository popisRepository;
    private final IUserRepository userRepository;
    private final PopisService popisService;

    @GetMapping("get-page-list")
    public PopisPageModel getList(Integer userID, Integer pageNumber, Integer pageSize) {
        try {
        boolean jeAdministrator = userRepository.hasRole(userID, RoleEnum.ADMINISTRATOR.getValue()) == 1;
        Page<Popis> popisi;
        if (jeAdministrator)
            popisi = popisRepository.findAll(PageRequest.of(pageNumber, pageSize));
        else
            popisi = popisRepository.findByUser(userID, PageRequest.of(pageNumber, pageSize));
        return PopisMapper.toModelPagedList(popisi);
        }catch (Exception e) {
            throw e;
        }
    }
    @GetMapping("get-list")
    public List<Popis> getAllList() {
        return popisRepository.findAll();
    }

    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody @Valid PopisModel popisModel, BindingResult result) {
        return ResponseEntity.ok(popisService.create(popisModel));
    }

    @PostMapping("update")
    public ResponseEntity<?> update(@RequestBody @Valid PopisModel popisModel, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>("Not updated!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok(popisService.update(popisModel));
    }
    @PostMapping("delete")
    public ResponseEntity<?> delete(Integer popisID) {
        popisService.delete(popisID);
        return ResponseEntity.ok("");
    }
}