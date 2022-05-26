package com.example.Marketplace.dao;

import com.example.Marketplace.config.DuplicateFoundException;
import com.example.Marketplace.entity.Seller;
import com.example.Marketplace.repository.SellerRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

//potentially add @Autowired later
@Component("SellerDao")
public class SellerDao implements Dao<Seller> {

    //this may or may not work cus
    private SellerRepository sellerRepository;

    public SellerDao(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    @Override
    public Optional<Seller> get(long id) {
        return Optional.ofNullable(sellerRepository.getById((int) id));
    }

    @Override
    public List<Seller> getAll() {

        return sellerRepository.findAll();
    }

    @Override
    public void save(Seller seller) {

        if (sellerRepository.findByNumber(seller.getNumber()) == null) {
            sellerRepository.save(seller);
        } else {
            System.out.println("This number already exists.");
            throw new DuplicateFoundException("The number '" + seller.getNumber() + "' is already registered with an account");
        }
        sellerRepository.save(seller);
    }

    @Override
    public void update(Seller seller, String[] params) {

        //honestly not entirely sure what this code is supposed to do, look into this later
        if (sellerRepository.findByNumber(params[2]) == null) {
            Seller b = new Seller(Objects.requireNonNull(
                    params[0], "First name cannot be null"), Objects.requireNonNull(params[1], "Last name cannot be null"), Objects.requireNonNull(
                    params[2], "Number cannot be null"));
        } else {
            System.out.println("This nub");
        }
    }

    @Override
    public void delete(long id) {
        sellerRepository.deleteById((int) id);
    }

    public Seller findById(int id)
    {
        return sellerRepository.findById(id).get();
    }

}
