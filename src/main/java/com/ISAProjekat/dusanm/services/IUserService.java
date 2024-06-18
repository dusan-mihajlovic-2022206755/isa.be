package com.ISAProjekat.dusanm.services;

import com.ISAProjekat.dusanm.models.UserModel;
import com.ISAProjekat.dusanm.models.UserPageModel;
import com.ISAProjekat.dusanm.models.UserProductsModel;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface IUserService {
    List<UserModel> findAll();
    UserPageModel findPagedList(PageRequest pageRequest);
    UserModel create(UserModel model);
    UserModel update(UserModel model);
    void delete(Integer userId);
    List<UserProductsModel> findUserProductsAll();
}