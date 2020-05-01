package com.test.orders.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.test.orders.domain.Orders;
import com.test.orders.schemaobjects.OrderSO;

public interface OrderService {

	ResponseEntity<List<Orders>> allOrders();

	ResponseEntity<String> ordering(List<OrderSO> orderSO);

}
