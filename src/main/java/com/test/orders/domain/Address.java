package com.test.orders.domain;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ADDRESS")
@Data
@NoArgsConstructor

public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ADDRESS_ID")
	private long addressId;

	@Column(name = "ADDRESS_LINE1")
	private String addressLine1;

	@Column(name = "ADDRESS_LINE2")
	private String addressLine2;

	@Column(name = "PINCODE")
	private String pincode;

	@Column(name = "MOBILE_NUMBER")
	private String mobileNumber;

	@Column(name = "USER_ID")
	private String userId;
}