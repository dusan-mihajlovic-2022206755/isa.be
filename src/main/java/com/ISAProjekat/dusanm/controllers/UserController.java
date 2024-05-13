package com.ISAProjekat.dusanm.controllers;

import com.ISAProjekat.dusanm.models.UserModel;
import jakarta.validation.Valid;
import org.springframework.boot.SpringApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @CrossOrigin("*")

    @GetMapping("get-first-name")
    public String getFirstName(){
        return "Dule";
    }
    @GetMapping("get-first-name-list")
    public List<String> getFirstNameList(){
        return List.of("Dule", "Dule2", "Dule3", "Dule4", "Dule5");
    }

    @PostMapping("create-user")
    public boolean createUser(String firstName, String lastName){
        return true;

    }

    @PostMapping("create-user-body")
    public ResponseEntity<?> createUserBody(@RequestBody @Valid UserModel userModel, BindingResult bindingResult){
        System.out.println(userModel);
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>("Neuspešno registrovan!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<UserModel>(userModel, HttpStatus.CREATED);
    }

}