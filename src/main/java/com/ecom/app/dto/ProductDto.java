package com.ecom.app.dto;

public record ProductDto(String sku, String name, String description, String unitPrice, String imageUrl, boolean active, Integer unitsInStock , Long categoryId) {
}
