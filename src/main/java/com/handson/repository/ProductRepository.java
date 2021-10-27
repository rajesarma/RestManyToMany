package com.handson.repository;

import com.handson.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<ProductEntity, Integer> {
    List<ProductEntity> findAllByCategoryAndPriceGreaterThan(
            @Param("category") String category,
            @Param("price") Double price
    );

    List<ProductEntity> findAllByCategory(@Param("category") String category);
}
