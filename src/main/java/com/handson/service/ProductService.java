package com.handson.service;

import com.handson.entity.ProductEntity;
import com.handson.repository.ProductRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductEntity> getProductsByCategoryAndPrice(String category, Double price) {
        return productRepository.findAllByCategoryAndPriceGreaterThan(category, price);
    }

    public List<ProductEntity> getProductsByCategory(String category) {
        return productRepository.findAllByCategory(category);
    }

    public List<ProductEntity> getProductsByCategoryApplyDiscount(String category, Double discount) {
        List<ProductEntity> products = getProductsByCategory(category);
        return products.stream()
                .map(p -> {
                    p.setPrice(p.getPrice() + (p.getPrice() * discount) / 100);
                return p;
        })
        .collect(Collectors.toList());
    }

    public Optional<ProductEntity> getCheapestProducts(String category) {
        Sort sortOrder = Sort.by("price");
        Iterable<ProductEntity> productsList = productRepository.findAll(sortOrder);
        Optional<ProductEntity> product = StreamSupport.stream(productsList.spliterator(), false)
                .findFirst();

        return product;
    }


}
