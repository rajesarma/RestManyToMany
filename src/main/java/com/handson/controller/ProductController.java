package com.handson.controller;

import com.handson.entity.ProductEntity;
import com.handson.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

//    1.) Obtain a list of products belongs to category “Books” with price > 100
//    http://localhost:8040/handson7/products/Books?price=250

    @GetMapping("/{category}")
    public ResponseEntity<List<ProductEntity>> getByCategoryAndPrice(
            @PathVariable("category") String category,
            @RequestParam(required=false) Double price
    ) {
        if(Objects.isNull(category) || "".equals(category)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(Objects.isNull(price) || price <= 0) {
            return ResponseEntity.ok(productService.getProductsByCategory(category));
        }

        return ResponseEntity.ok(productService.getProductsByCategoryAndPrice(category,price));
    }

//    3.) Obtain a list of product with category = “Toys” and then apply 10% discount
//    http://localhost:8040/handson7/products/Books/10

    @GetMapping("/{category}/{discount}")
    public ResponseEntity<List<ProductEntity>> getByCategoryAndDiscount(
            @PathVariable("category") String category,
            @PathVariable("discount") Double discount
    ) {
        if(Objects.isNull(category) || "".equals(category) || Objects.isNull(discount) || discount <= 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(productService.getProductsByCategoryApplyDiscount(category, discount));
    }

//    4.) Get the cheapest products of “Books” category
//    http://localhost:8040/handson7/products/cheapest/Books

    @GetMapping("/cheapest/{category}")
    public ResponseEntity<ProductEntity> getCheapestProducts(
            @PathVariable("category") String category
    ) {
        if(Objects.isNull(category) || "".equals(category)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Optional<ProductEntity> productOptional = productService.getCheapestProducts(category);

        if(productOptional.isPresent()) {
            return ResponseEntity.ok(productOptional.get());
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
