package com.ISAProjekat.dusanm.controllers;

import com.ISAProjekat.dusanm.entities.Product;
import com.ISAProjekat.dusanm.repositories.IProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ProductController {
    private final IProductRepository productRepository;

    @GetMapping("get-list")
    public List<Product> getList() {
        return productRepository.findAll();
    }
}
