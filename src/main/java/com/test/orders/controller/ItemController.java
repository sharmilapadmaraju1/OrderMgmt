package com.test.orders.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.orders.domain.Items;
import com.test.orders.schemaobjects.ItemSO;
import com.test.orders.service.ItemService;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@CrossOrigin
@RestController
@EnableSwagger2
public class ItemController {

	@Autowired
	ItemService itemService;

	@CrossOrigin
	@ApiOperation(value = "Adding a Item")
	@RequestMapping(value = "add/item", method = RequestMethod.POST)
	public ResponseEntity<String> addItem(@RequestBody List<ItemSO> itemSO, HttpServletRequest request,
			HttpServletResponse response) {
		return itemService.addItem(itemSO);

	}

	@CrossOrigin
   
	@ApiOperation(value = "Item Details based on ItemId")
	@RequestMapping(value = "item/{itemid}", method = RequestMethod.GET)
	public ResponseEntity<Items> itemDetails(@PathVariable("itemid") long itemId, HttpServletRequest request,
			HttpServletResponse response) {
		return itemService.itemDetails(itemId);

	}
	
	@CrossOrigin
	@ApiOperation(value = "Updating Item Details based on ItemId")
	@RequestMapping(value = "update/item/{itemid}", method = RequestMethod.PUT)
	public ResponseEntity<String> updateItemDetails(@PathVariable("itemid") long itemId,@RequestBody ItemSO itemSO, HttpServletRequest request,
			HttpServletResponse response) {
		return itemService.updateItemDetails(itemId,itemSO);

	}
	
	@CrossOrigin
	@ApiOperation(value = "Deleting Item  based on ItemId")
	@RequestMapping(value = "delete/item/{itemid}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteItem(@PathVariable("itemid") long itemId, HttpServletRequest request,
			HttpServletResponse response) {
		return itemService.deleteItem(itemId);

	}
	
	@CrossOrigin
	@ApiOperation(value = "Listing all Items")
	@RequestMapping(value = "all/items", method = RequestMethod.GET)
	public ResponseEntity<List<Items>> allItems( HttpServletRequest request,
			HttpServletResponse response) {
		return itemService.allItems();

	}

}