package com.ISAProjekat.dusanm.repositories;

import com.ISAProjekat.dusanm.entities.UserProducts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserProductsRepository extends JpaRepository<UserProducts, Integer> {
}
