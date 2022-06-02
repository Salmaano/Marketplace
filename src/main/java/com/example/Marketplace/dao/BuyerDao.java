package com.example.Marketplace.dao;

import com.example.Marketplace.config.DuplicateFoundException;
import com.example.Marketplace.entity.Buyer;
import com.example.Marketplace.repository.BuyerRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

//potentially add @Autowired later
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

        //Buyer buyer1 = buyerRepository.findByNumber(buyer.getNumber());
        //System.out.println("This is where it all begins");
        //System.out.println(buyer1.getFirstName());
        //System.out.println(buyers.get(0).getFirstName());

        if (buyerRepository.findByNumber(buyer.getNumber()) == null) {
            buyerRepository.save(buyer);
        }
        else{
            System.out.println("This number already exists.");
            throw new DuplicateFoundException("The number '"+buyer.getNumber()+"' is already registered with an account");
        }
        //buyerRepository.save(buyer);
    }

    //test this method to make sure its working as intended
    @Override
    public void update(Buyer buyer, String[] params) {
        //add an exception for this later, potentially
        if (buyerRepository.findById(buyer.getID()).get() != null) {

            if (buyerRepository.findByNumber(buyer.getNumber()) == null) {
                buyer.setFirstName(params[0]);
                buyer.setLastName(params[1]);
                buyer.setNumber(params[2]);
                buyerRepository.save(buyer);
            }

            else {
                System.out.println("This number already exists.");
                throw new DuplicateFoundException("The number '"+buyer.getNumber()+"' is already registered with an account");
            }

        }
        else{
            System.out.println("The buyer specified does not exist");
        }
    }

    @Override
    public void delete(long id){
        buyerRepository.deleteById((int)id);
    }



}
