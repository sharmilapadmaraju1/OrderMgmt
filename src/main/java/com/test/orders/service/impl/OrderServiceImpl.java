package com.test.orders.service.impl;

import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.test.orders.domain.Items;
import com.test.orders.domain.Orders;
import com.test.orders.domain.User;
import com.test.orders.repository.ItemRepo;
import com.test.orders.repository.OrderRepo;
import com.test.orders.repository.UserRepo;
import com.test.orders.schemaobjects.ItemListSO;
import com.test.orders.schemaobjects.OrderSO;
import com.test.orders.service.OrderService;

@Component
public class OrderServiceImpl implements OrderService {

	public static final Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);

	@Autowired
	OrderRepo orderRepo;

	@Autowired
	UserRepo userRepo;

	@Autowired
	ItemRepo itemRepo;

	@Override
	public ResponseEntity<List<Orders>> allOrders() {
		ResponseEntity<List<Orders>> response = null;
		try {
			List<Orders> list = orderRepo.findAll();
			if (list != null)
				response = new ResponseEntity<List<Orders>>(list, HttpStatus.OK);
			else
				response = new ResponseEntity<List<Orders>>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			log.info("Exception {}", e.getMessage());
			response = new ResponseEntity<List<Orders>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	@Override
	public ResponseEntity<String> ordering(List<OrderSO> orderSO) {
		boolean flag = true;
		String msg = null;
		ResponseEntity<String> response = null;
		try {

			for (OrderSO orderSo : orderSO) {

				List<ItemListSO> orderList = orderSo.getItemsList();

				User user = new User();
				Items item = new Items();
				for (ItemListSO list : orderList) {
					Orders order = new Orders();
					item = itemRepo.findItem(list.getItemName());

					if (list.getQuantity() <= item.getItemStock()) {

						user = userRepo.getUserDetails(orderSo.getEmailId());
						long orderId = orderRepo.getOrderSeq();
						order.setOrderId(orderId);
						order.setNoOfItems(list.getQuantity());
						order.setOrderCost(item.getItemCost() * list.getQuantity());
						order.setOrderedDate(new Date());
						order.setUserId(user.getUserId());
						order.setAddress(user.getAddress().get(0));
						orderRepo.save(order);
						itemRepo.stockUpdation(item.getItemStock() - list.getQuantity(), list.getItemName());

					}

					else {
						flag = false;
						msg = item.getItemStock() + item.getItemName() + " only available ";
						break;
					}

				}
				break;
			}

			if (flag)
				response = new ResponseEntity<String>(HttpStatus.OK);
			else
				response = new ResponseEntity<String>("***OUT_OF_STOCK*** " + msg, HttpStatus.OK);

		} catch (Exception e) {
			log.info("Exception {}", e.getMessage());
			response = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

}
