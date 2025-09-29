package com.ecom.app.controller;


import com.ecom.app.dto.ProductDto;
import com.ecom.app.entity.Product;
import com.ecom.app.service.ProductServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private ProductServiceImpl productService;

    public ProductController(ProductServiceImpl productService){
        this.productService = productService;
    }

    @GetMapping("/check")
    public String checkProduct(){
        return "Product checking complete successfully!";
    }

    @GetMapping("/")
    public ResponseEntity<List<Product>> getAllProducts(){
        log.info("ProductController class : getAllProducts() : ");
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        log.info("ProductController class : getProductById() : "+id);
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable Long id){
        log.info("ProductController class : deleteProductById() : "+id);
        return new ResponseEntity<>(productService.deleteProductById(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto product){
        log.info("ProductController class : createProduct() : ");
        return new ResponseEntity<>(productService.createProduct(product), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProductById(@PathVariable Long id, @RequestBody Product product){
        log.info("ProductController class : updateProductById() : "+id);
        return new ResponseEntity<>(productService.updateProductById(id, product), HttpStatus.OK);
    }
}
