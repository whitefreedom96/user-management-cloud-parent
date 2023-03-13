package com.unicard.usermanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unicard.usermanagement.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

	Order findByRazorpayOrderId(String orderId);
}
