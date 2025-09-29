package com.ecom.app.dto;

import com.ecom.app.entity.Address;
import com.ecom.app.entity.Customer;
import com.ecom.app.entity.Product;
import com.ecom.app.entity.ProductCategory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MappingConfig {

    public static Product productMapper(ProductDto product, ProductCategory category){

        Product product1 = new Product();
        product1.setCategory(category);
        product1.setActive(product.active());
        product1.setSku(product.sku());
        product1.setName(product.name());
        product1.setDescription(product.description());
        product1.setUnitPrice(product.unitPrice());
        product1.setImageUrl(product.imageUrl());
        product1.setUnitsInStock(product.unitsInStock());

        return product1;

    }

    public static ProductDto productDtoMapper(Product product){
        return new ProductDto(
                product.getSku(), product.getName(), product.getDescription(), product.getUnitPrice(), product.getImageUrl(),
                product.getActive(), product.getUnitsInStock(), product.getCategory().getId());

    }

    public static Address address(AddressDto addressDto, String typeOfAddress) {

        Address address = new Address();
        address.setStreet(addressDto.street());
        address.setCity(addressDto.city());
        address.setState(addressDto.state());
        address.setPincode(addressDto.pincode());
        address.setTypeOfAddress(typeOfAddress.equals("Billing_Address")? "Billing_Address" : "Shipping_Address");
        return address;
    }

    public static Customer cusotmerMapper(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setFirstName(customerDto.firstName());
        customer.setLastName(customerDto.lastName());
        customer.setEmail(customerDto.email());
        return customer;
    }
}
