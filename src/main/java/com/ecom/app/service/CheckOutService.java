package com.ecom.app.service;

import com.ecom.app.dto.Purchase;
import com.ecom.app.dto.PurchaseResponse;

public interface CheckOutService {

    PurchaseResponse placeOrder(Purchase purchase);
}
