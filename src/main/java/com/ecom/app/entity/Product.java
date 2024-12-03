package com.ecom.app.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sku;
    private String name;
    private String description;
    private String unitPrice;
    private String imageUrl;
    private boolean active;
    private Integer unitsInStock;
    private Date dateCreated;
    private Date lastUpdated;

    @ManyToOne
    private ProductCategory category;
}
