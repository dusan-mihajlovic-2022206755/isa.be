package com.ISAProjekat.dusanm.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import com.ISAProjekat.dusanm.validators.ContactNumberConstraint;

@Data
public class UserModel {
    private int id;
    @NotBlank
    private String firstName;
    private String lastName;
    @Email
    private String email;
    @ContactNumberConstraint
    private String contactNumber;
}
