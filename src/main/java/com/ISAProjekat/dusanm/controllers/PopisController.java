package com.ISAProjekat.dusanm.controllers;

import com.ISAProjekat.dusanm.entities.Popis;
import com.ISAProjekat.dusanm.models.PopisModel;
import com.ISAProjekat.dusanm.repositories.IPopisRepository;
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

@RestController
@RequestMapping("popis")
@RequiredArgsConstructor
@CrossOrigin("*")
public class PopisController {
    private final IPopisRepository popisRepository;
    private final PopisService popisService;

//    @GetMapping("get-page-list")
//    public PopisPageModel getPageList(int userID, Integer pageNumber, Integer pageSize) {
//        return popisService. findPagedList(PageRequest.of(pageNumber, pageSize));
//    }

    @GetMapping("get-page-list")
    public Page<Popis> getList(Integer userID, Integer pageNumber, Integer pageSize ) {
        return popisRepository.findByUser(userID, PageRequest.of(pageNumber, pageSize));
    }
    @GetMapping("get-list")
    public List<Popis> getAllList() {
        return popisRepository.findAll();
    }
    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody @Valid PopisModel popisModel, BindingResult result) {
        return ResponseEntity.ok(popisService.create(popisModel));
    }

    @PutMapping("update")
    public ResponseEntity<?> update(@RequestBody @Valid PopisModel popisModel, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>("Not updated!", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return ResponseEntity.ok(popisService.update(popisModel));
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> delete(Integer popisID) {
        popisService.delete(popisID);
        return ResponseEntity.ok("");
    }
}