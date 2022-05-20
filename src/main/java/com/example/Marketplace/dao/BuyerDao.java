package com.example.Marketplace.dao;

import com.example.Marketplace.entity.Buyer;
import com.example.Marketplace.repository.BuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class BuyerDao implements Dao<Buyer>{

    //this may or may not work cus
    private BuyerRepository buyerRepository;

    public BuyerDao(BuyerRepository buyerRepository){
        this.buyerRepository = buyerRepository;
    }

    @Override
    public Optional<Buyer> get(long id){
       return Optional.ofNullable(buyerRepository.getById((int)id));
    }

    @Override
    public List<Buyer> getAll(){

        return buyerRepository.findAll();
    }

    @Override
    public void save(Buyer buyer){
        buyerRepository.save(buyer);
    }

    @Override
    public void update(Buyer buyer, String[] params){
        Buyer b = new Buyer(Objects.requireNonNull(
                params[0], "First name cannot be null"),Objects.requireNonNull(params[1], "Last name cannot be null"),Objects.requireNonNull(
                params[2], "Number cannot be null"));
    }

    @Override
    public void delete(long id){
        buyerRepository.deleteById((int)id);
    }



}
