package com.test.orders.domain;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "ORDERS")
@Data
@NoArgsConstructor

public class Orders implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ORDER_ID")
	private long orderId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ORDERED_DATE")
	private Date orderedDate;

	@Column(name = "USER_ID")
	private String userId;

	@Column(name = "ORDER_COST")
	private long orderCost;

	@Column(name = "NO_OF_ITEMS")
	private long noOfItems;

	@Column(name = "DELIVERY_ADDRESS")
	private Address address;

}