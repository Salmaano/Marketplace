package com.example.Marketplace.repository;

import com.example.Marketplace.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {


}
