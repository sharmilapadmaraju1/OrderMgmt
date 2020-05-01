package com.test.orders.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.test.orders.domain.Items;

/**
 * @author Administrator
 *
 */
public interface ItemRepo extends JpaRepository<Items, Long> {

	@Query(value = "select ITEM_SEQ.nextval from dual", nativeQuery = true)
	public long getItemSeq();

	@Query(value = "select from ITEMS where  ITEM_NAME=:itemName", nativeQuery = true)
	public Items findItem(@Param("itemName") String itemName);

	@Query(value = "select from ITEMS where  ITEM_ID=:itemId", nativeQuery = true)
	public Items findByItemId(@Param("itemId") long itemId);

	@Modifying
	@Transactional
	@Query(value = "UPDATE ITEMS SET ITEM_STOCK =:itemQuantity where ITEM_NAME=:itemName", nativeQuery = true)
	public int stockUpdation(@Param("itemQuantity") long itemQuantity,@Param("itemName") String itemName);

}
