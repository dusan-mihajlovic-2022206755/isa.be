package com.ISAProjekat.dusanm.mappers;

import com.ISAProjekat.dusanm.entities.Product;
import com.ISAProjekat.dusanm.entities.User;
import com.ISAProjekat.dusanm.models.ProductModel;
import com.ISAProjekat.dusanm.models.UserModel;
import com.ISAProjekat.dusanm.models.UserPageModel;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public class ProductMapper {
    public static ProductModel toModel(Product entity) {
        return ProductModel.builder()
                .name(entity.getName()).build();
    }

    public static List<ProductModel> toModelList(List<Product> entities) {
        var list = new ArrayList<ProductModel>();

        for (var entity : entities) {
            list.add(toModel(entity));
        }

        return list;
    }
}
