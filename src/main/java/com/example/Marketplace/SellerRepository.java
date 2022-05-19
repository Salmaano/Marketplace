package com.example.Marketplace;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//consult later if implementing your repository this way and then type casting it in the controller is
// bad practice or not
public interface SellerRepository extends UserRepository {

    List<Buyer> findByNumber(String number);
}
