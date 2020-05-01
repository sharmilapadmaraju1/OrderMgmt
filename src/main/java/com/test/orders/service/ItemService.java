package com.test.orders.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.test.orders.domain.Items;
import com.test.orders.schemaobjects.ItemSO;

public interface ItemService {

	ResponseEntity<String> addItem(List<ItemSO> itemSO);

	ResponseEntity<Items> itemDetails(long itemId);

	ResponseEntity<String> updateItemDetails(long itemId, ItemSO itemSO);

	ResponseEntity<String> deleteItem(long itemId);

	ResponseEntity<List<Items>> allItems();
}
