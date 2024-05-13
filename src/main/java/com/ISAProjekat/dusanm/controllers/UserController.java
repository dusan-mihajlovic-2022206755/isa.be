package com.ISAProjekat.dusanm.controllers;

import com.ISAProjekat.dusanm.models.UserModel;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

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
    public boolean createUserBody(@RequestBody UserModel userModel){
        System.out.println(userModel);
        return true;

    }

}