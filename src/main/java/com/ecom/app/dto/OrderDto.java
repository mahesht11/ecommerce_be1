package com.ecom.app.dto;

import java.math.BigDecimal;

public record OrderDto(BigDecimal totalPrice, Integer totalQuantity) {
}
