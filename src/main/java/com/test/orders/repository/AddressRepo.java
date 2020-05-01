package com.test.orders.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.test.orders.domain.Address;

public interface AddressRepo extends JpaRepository<Address, Long> {

	
	
}
