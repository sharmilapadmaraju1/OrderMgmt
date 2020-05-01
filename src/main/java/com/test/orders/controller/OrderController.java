package com.test.orders.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.orders.domain.Orders;
import com.test.orders.schemaobjects.OrderSO;
import com.test.orders.service.OrderService;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@CrossOrigin
@RestController
@EnableSwagger2
public class OrderController {

	@Autowired
	OrderService orderService;

	@CrossOrigin
	@ApiOperation(value = "Get All Orders")
	@RequestMapping(value = "all/orders", method = RequestMethod.GET)
	public ResponseEntity<List<Orders>> allOrders(HttpServletRequest request, HttpServletResponse response) {
		return orderService.allOrders();

	}

	@CrossOrigin
	@ApiOperation(value = "Single and bulk orderig")
	@RequestMapping(value = "get/ordering", method = RequestMethod.POST)
	public ResponseEntity<String> ordering(@RequestBody List<OrderSO> orderSO, HttpServletRequest request,
			HttpServletResponse response) {
		return orderService.ordering(orderSO);

	}

}