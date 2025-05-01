package com.sheryians.major.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sheryians.major.model.Order;

public interface OrderRepo extends JpaRepository<Order, Integer>{

}
