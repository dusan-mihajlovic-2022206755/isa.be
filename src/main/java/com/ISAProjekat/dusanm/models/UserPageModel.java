package com.ISAProjekat.dusanm.models;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserPageModel {
    private List<UserModel> Users;
    private int totalPages;
    private Long totalElements;
}
