package com.test.orders.domain;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ITEMS")
@Data
@NoArgsConstructor

public class Items implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ITEM_ID")
	private long itemID;

	@Column(name = "ITEM_NAME")
	private String itemName;

	@Column(name = "ITEM_STOCK")
	private long itemStock;

	@Column(name = "ITEM_COST")
	private long itemCost;

}