package com.ecom.app.dto;

import com.ecom.app.entity.Address;
import com.ecom.app.entity.Customer;
import com.ecom.app.entity.Order;
import com.ecom.app.entity.OrderItem;

import java.util.Set;

public record Purchase(CustomerDto customer, AddressDto shippingAddress, AddressDto billingAddress, OrderDto order, Set<OrderItemDto> orderItems) {
}
