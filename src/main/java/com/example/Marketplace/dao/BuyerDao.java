package com.example.Marketplace.dao;

import com.example.Marketplace.config.DuplicateFoundException;
import com.example.Marketplace.entity.Buyer;
import com.example.Marketplace.repository.BuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
@Component("BuyerDao")
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

        if (buyerRepository.findByNumber(buyer.getNumber()) == null) {
            buyerRepository.save(buyer);
        }
        else{
            System.out.println("This number already exists.");
            throw new DuplicateFoundException("The number '"+buyer.getNumber()+"' is already registered with an account");
        }
        buyerRepository.save(buyer);
    }

    @Override
    public void update(Buyer buyer, String[] params) {

        //honestly not entirely sure what this code is supposed to do, look into this later
        if (buyerRepository.findByNumber(params[2]) == null) {
                Buyer b = new Buyer(Objects.requireNonNull(
                        params[0], "First name cannot be null"),Objects.requireNonNull(params[1], "Last name cannot be null"),Objects.requireNonNull(
                        params[2], "Number cannot be null"));
        }
        else{
            System.out.println("This nub");
        }
    }

    @Override
    public void delete(long id){
        buyerRepository.deleteById((int)id);
    }



}
