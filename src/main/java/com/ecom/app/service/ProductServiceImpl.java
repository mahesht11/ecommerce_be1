package com.ecom.app.service;

import com.ecom.app.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProductServiceImpl {

    private ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository){
     repository = this.repository;
    }
}
