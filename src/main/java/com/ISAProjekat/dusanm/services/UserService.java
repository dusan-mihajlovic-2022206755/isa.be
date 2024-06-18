package com.ISAProjekat.dusanm.services;

import com.ISAProjekat.dusanm.exceptions.user.UserAlreadyExistException;
import com.ISAProjekat.dusanm.exceptions.user.UserException;
import com.ISAProjekat.dusanm.mappers.UserMapper;
import com.ISAProjekat.dusanm.mappers.UserProductsMapper;
import com.ISAProjekat.dusanm.models.UserModel;
import com.ISAProjekat.dusanm.models.UserPageModel;
import com.ISAProjekat.dusanm.models.UserProductsModel;
import com.ISAProjekat.dusanm.repositories.IUserProductsRepository;
import com.ISAProjekat.dusanm.repositories.IUserRepository;
import jdk.jshell.spi.ExecutionControl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final IUserRepository userRepository;
    private final IUserProductsRepository userProductsRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public List<UserModel> findAll() {
        var result = userRepository.findAll();
        return UserMapper.toModelList(result);
    }

    @Override
    public UserPageModel findPagedList(PageRequest pageRequest) {
        var result = userRepository.findAll(pageRequest);
        return UserMapper.toModelPagedList(result);
    }

    @Override
    public UserModel create(UserModel model) {
        var user = UserMapper.toEntity(model, passwordEncoder);

        var existingUser = userRepository.findByEmail(model.getEmail());

        if (existingUser.isPresent())
            throw new UserAlreadyExistException("User with email " + model.getEmail() + " already exists");

        var savedUser = userRepository.save(user);

        return UserMapper.toModel(savedUser);
    }

    @Override
    public UserModel update(UserModel model) {
        var entity = UserMapper.toEntity(model, passwordEncoder);
        try {
            var result = userRepository.save(entity);
            return UserMapper.toModel(result);
        } catch (Exception e) {
            throw new UserException(e.getMessage());
        }
    }

    @Override
    public void delete(Integer userId) {
        var entity = userRepository.findById(userId).orElseThrow(() -> new UserException("User Not Found"));
        userRepository.delete(entity);
    }

    @Override
    public List<UserProductsModel> findUserProductsAll() {
        var result = userProductsRepository.findAll();
        return UserProductsMapper.toModelList(result);
    }
}
