package com.ecom.app.dto;

import java.math.BigDecimal;

public record OrderItemDto(String imageUrl, Integer quantity, BigDecimal unitPrice, Long productId) {
}
