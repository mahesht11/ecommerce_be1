package com.ecom.app.service;

import com.ecom.app.dto.*;
import com.ecom.app.entity.Address;
import com.ecom.app.entity.Customer;
import com.ecom.app.entity.Order;
import com.ecom.app.entity.OrderItem;
import com.ecom.app.repository.CustomerRepo;
import com.ecom.app.repository.OrderRepo;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CheckOutServiceImpl implements CheckOutService{

private CustomerRepo customerRepo;
private OrderRepo orderRepo;


public CheckOutServiceImpl(CustomerRepo customerRepo, OrderRepo orderRepo){
    this.customerRepo = customerRepo;
    this.orderRepo = orderRepo;

}
    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        log.info("CheckOutServiceImpl class : placeOrder() : ");
        Order order = new Order();

        //order data
        order.setTotalPrice(purchase.order().totalPrice());
        order.setTotalQuantity(purchase.order().totalQuantity());
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);
        order.setStatus("True");

        //order items
        Set<OrderItemDto> orderItemDtos = purchase.orderItems();
        Set<OrderItem> orderItemSet = orderItemsSet(orderItemDtos);
        orderItemSet.forEach(item -> order.add(item));

        //address
        AddressDto billingAddressDto = purchase.billingAddress();
        Address billing = MappingConfig.address(billingAddressDto, "Billing_Address");
        AddressDto shippingAddressDto = purchase.shippingAddress();
        Address shipping = MappingConfig.address(shippingAddressDto, "Shipping_Address");
        order.setBillingAddress(billing);
        order.setShippingAddress(shipping);
        //customer
        CustomerDto customerDto = purchase.customer();
        Customer customer = MappingConfig.cusotmerMapper(customerDto);
        customer.add(order);



        //order.setCustomer(customer);

        //order.setOrderItems(orderItemSet);

        //Order order1 =  orderRepo.save(order);
        customerRepo.save(customer);
        return new PurchaseResponse(orderTrackingNumber);
    }

    private Set<OrderItem> orderItemsSet(Set<OrderItemDto> orderItemDtos) {
        Set<OrderItemDto> dtos = new HashSet<>(orderItemDtos);
        Set<OrderItem> set = new HashSet<>();
        for(OrderItemDto dto : dtos){
            OrderItem oi = new OrderItem();
            oi.setQuantity(dto.quantity());
            oi.setImageUrl(dto.imageUrl());
            oi.setUnitPrice(dto.unitPrice());
            oi.setProductId(dto.productId());
            set.add(oi);
        }
        return set;

    }

    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }
}
