package com.example.Marketplace.repository;
import com.example.Marketplace.entity.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
//consult later if implementing your repository this way and then type casting it in the controller is
// bad practice or not
public interface BuyerRepository extends JpaRepository<Buyer,Integer> {

    //List<Buyer> findByNumber(String number);

}