package com.test.orders.domain;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "USER")
@Data
@NoArgsConstructor

public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "USER_ID")
	private String userId;

	@Column(name = "EMAIL_ID")
	private String emailId;

	@OneToMany(mappedBy = "userId")
	private List<Address> address;

}