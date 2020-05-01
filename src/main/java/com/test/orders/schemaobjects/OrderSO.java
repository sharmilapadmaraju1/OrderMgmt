package com.test.orders.schemaobjects;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderSO {

	private List<ItemListSO> itemsList;
	private String emailId;

}