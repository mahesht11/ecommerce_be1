package com.ecom.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Data
@Entity
@Table(name = "product")
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="sku")
    private String sku;
    @Column(name="name")
    private String name;
    @Column(name="description")
    private String description;
    @Column(name="unit_price")
    private String unitPrice;
    @Column(name="image_url")
    private String imageUrl;
    @Column(name="active")
    private Boolean active;
    @Column(name="units_in_stock")
    private Integer unitsInStock;
    @Column(name="date_created")
    @CreationTimestamp
    private Date dateCreated;
    @Column(name="last_updated")
    @UpdateTimestamp
    private Date lastUpdated;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private ProductCategory category;
}
