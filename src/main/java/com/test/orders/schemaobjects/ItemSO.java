package com.test.orders.schemaobjects;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ItemSO {
	
	private String itemName;
	private long itemQuantity;
	private long itemCost; 
    

}