package com.ecom.app.controller;


import com.ecom.app.dto.Purchase;
import com.ecom.app.dto.PurchaseResponse;
import com.ecom.app.service.CheckOutService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/api/v1")
public class CheckOutController {

    private CheckOutService checkOutService;

    public CheckOutController(CheckOutService checkOutService){
        this.checkOutService = checkOutService;
    }

    @PostMapping("/purchase")
    public ResponseEntity<PurchaseResponse> placeOrder(@RequestBody Purchase purchase){
        log.info("CheckOutController class : placeOrder() : ");
        return new ResponseEntity<>(checkOutService.placeOrder(purchase), HttpStatus.CREATED);
    }
}
