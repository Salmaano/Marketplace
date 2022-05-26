package com.example.Marketplace.repository;
import com.example.Marketplace.entity.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

public interface BuyerRepository extends JpaRepository<Buyer,Integer> {

    List<Buyer> findByNumber(String number);

}