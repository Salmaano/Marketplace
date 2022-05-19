package com.example.Marketplace.repository;

import com.example.Marketplace.entity.Buyer;
import com.example.Marketplace.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//consult later if implementing your repository this way and then type casting it in the controller is
// bad practice or not
public interface SellerRepository extends JpaRepository<Seller,Integer> {

    //List<Seller> findByNumber(String number);
}
