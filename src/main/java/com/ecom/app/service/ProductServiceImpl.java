package com.ecom.app.service;

import com.ecom.app.dto.MappingConfig;
import com.ecom.app.dto.ProductDto;
import com.ecom.app.entity.Product;
import com.ecom.app.entity.ProductCategory;
import com.ecom.app.exception.ProductIdException;
import com.ecom.app.repository.ProductCategoryRepo;
import com.ecom.app.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProductServiceImpl {

    private ProductRepository repository;

    private ProductCategoryRepo productCategoryRepo;

    private ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository repository, ProductCategoryRepo productCategoryRepo, ModelMapper modelMapper){
     this.repository = repository;
     this.productCategoryRepo = productCategoryRepo;
     this.modelMapper = modelMapper;
    }

    public List<Product> getAllProducts() {
        log.info("ProductServiceImpl class : getAllProducts() :");
        return repository.findAll();
    }

    public Product getProductById(Long id) {
        log.info("ProductServiceImpl class : getProductById(): "+id);
        return repository.findById(id).orElseThrow(() -> new ProductIdException("Mismatch productId : " +id+", Please try again"));
    }

    public String deleteProductById(Long id) {
        log.info("ProductServiceImpl class : deleteProductById(): "+id);
       Product product = repository.findById(id).orElseThrow(() -> new ProductIdException("Mismatch productId : " +id+", Please try again"));
       if(product.getId()==id) {
           repository.deleteById(id);
       }
       return "product deleted successfully!";
    }

    public ProductDto createProduct(ProductDto product) {
        log.info("ProductServiceImpl class : createProduct() :");
        ProductCategory productCategory = productCategoryRepo.findById(product.categoryId()).get();
        Product product1 = MappingConfig.productMapper(product, productCategory);
        Product product2 =  repository.save(product1);
        return MappingConfig.productDtoMapper(product2);
    }

    public Product updateProductById(Long id, Product product) {
        log.info("ProductServiceImpl class : updateProductById() :"+id);
      Product product1 =  repository.findById(id).orElseThrow(() -> new ProductIdException("Mismatch productId : " +id+", Please try again"));
      if(product.getId()==id) {
          return repository.saveAndFlush(product);
      }
      return null;
    }
}
