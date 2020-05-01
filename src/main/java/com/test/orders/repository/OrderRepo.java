package com.test.orders.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.test.orders.domain.Orders;

/**
 * @author Administrator
 *
 */
public interface OrderRepo extends JpaRepository<Orders, Long> {

	@Query(value = "select ORDER_SEQ.nextval from dual", nativeQuery = true)
	public long getOrderSeq();

	

}
