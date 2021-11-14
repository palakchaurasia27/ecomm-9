package com.webservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.webservice.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	/* @Query("SELECT new com.webservice.controller.OrderResponse(u.userName , p.productName) FROM User u JOIN u.products p")
	    public List<OrderResponse> getJoinInformation();*/

}