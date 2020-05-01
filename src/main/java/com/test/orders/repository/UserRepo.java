package com.test.orders.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.test.orders.domain.User;

/**
 * @author Administrator
 *
 */
public interface UserRepo extends JpaRepository<User, Long> {

	@Query(value = "select * from USER where EMAIL_ID=:emailId ", nativeQuery = true)
	public User getUserDetails(@Param("emailId") String emailId);


}
