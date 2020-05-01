package com.test.orders.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.test.orders.domain.Items;
import com.test.orders.repository.ItemRepo;
import com.test.orders.schemaobjects.ItemSO;
import com.test.orders.service.ItemService;

@Component
public class ItemServiceImpl implements ItemService {

	public static final Logger log = LoggerFactory.getLogger(ItemServiceImpl.class);

	@Autowired
	ItemRepo itemRepo;

	@Override
	public ResponseEntity<String> addItem(List<ItemSO> itemSO) {
		ResponseEntity<String> response = null;
		try {
			itemSO.forEach(n -> {
				Items items = new Items();
				items = itemRepo.findItem(n.getItemName());
				if (items != null) {
					long quantity = items.getItemStock();
					items.setItemStock(quantity + n.getItemQuantity());
					itemRepo.save(items);

				}

				else {
					Items item = new Items();
					long itemId = itemRepo.getItemSeq();
					item.setItemCost(n.getItemCost());
					item.setItemID(itemId);
					item.setItemName(n.getItemName());
					item.setItemStock(n.getItemQuantity());
					itemRepo.save(item);

				}

			});
			response = new ResponseEntity<>("Item Details added successfully", HttpStatus.CREATED);
		} catch (Exception e)

		{
			log.info("Exception {}", e.getMessage());
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		;

		return response;

	}

	@Override
	public ResponseEntity<Items> itemDetails(long itemId) {
		ResponseEntity<Items> response = null;
		Items item = new Items();
		try {

			item = itemRepo.findByItemId(itemId);
			if (item != null)
				response = new ResponseEntity<Items>(item, HttpStatus.OK);
			else
				response = new ResponseEntity<Items>(HttpStatus.NOT_FOUND);

		}

		catch (Exception e)

		{
			log.info("Excpetion {}", e.getMessage());
			response = new ResponseEntity<Items>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

	@Override
	public ResponseEntity<String> updateItemDetails(long itemId, ItemSO itemSO) {
		Items existing = new Items();
		ResponseEntity<String> response = null;
		try {
			Items item = itemRepo.findByItemId(itemId);
			if (item != null) {

				if (itemSO.getItemCost() > 0)
					existing.setItemCost(itemSO.getItemCost());
				if (itemSO.getItemName() != null)
					existing.setItemName(itemSO.getItemName());

				if (itemSO.getItemQuantity() > 0)
					existing.setItemStock(itemSO.getItemQuantity());

				itemRepo.saveAndFlush(existing);
				response = new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
			} else {
				response = new ResponseEntity<>("Failed to Update as resource not available", HttpStatus.NOT_FOUND);
			}
		}

		catch (Exception e) {
			log.info("Excpetion {}", e.getMessage());
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

	@Override
	public ResponseEntity<String> deleteItem(long itemId) {
		ResponseEntity<String> response = null;
		try {
			itemRepo.deleteById(itemId);
			response = new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
		} catch (Exception e) {
			log.info("Exception {}", e.getMessage());
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	@Override
	public ResponseEntity<List<Items>> allItems() {
		ResponseEntity<List<Items>> response = null;
		List<Items> list = new ArrayList<Items>();
		try {

			list = itemRepo.findAll();
			if (list != null)
				response = new ResponseEntity<List<Items>>(list, HttpStatus.OK);
			else
				response = new ResponseEntity<List<Items>>(HttpStatus.NOT_FOUND);

		} catch (Exception e) {
			log.info("Exception {}", e.getMessage());
			response = new ResponseEntity<List<Items>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

}
