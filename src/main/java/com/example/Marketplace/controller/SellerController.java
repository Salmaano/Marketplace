package com.example.Marketplace.controller;

import com.example.Marketplace.dao.ListingDao;
import com.example.Marketplace.dao.SellerDao;
import com.example.Marketplace.entity.Listing;
import com.example.Marketplace.repository.ListingRepository;
import com.example.Marketplace.entity.Seller;
import com.example.Marketplace.repository.SellerRepository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/seller")
public class SellerController {

    private SellerDao sellerDao;
    private ListingDao listingDao;

    public SellerController(SellerDao sellerDao, ListingDao listingDao){
        this.sellerDao = sellerDao;
        this.listingDao = listingDao;
    }

    /*@PostMapping(path="/create")
    public @ResponseBody String createNewSeller (@RequestParam String firstName, @RequestParam String lastName, @RequestParam String number) {

        Seller s = new Seller(firstName,lastName,number);
        sellerRepository.save(s);
        return "Saved"+s.getID();
    }*/


    @PostMapping(path="/create")
    public @ResponseBody String createNewSeller (@Valid @RequestBody Seller s) {
        sellerDao.save(s);
        return "Saved, this is your ID for future reference: "+s.getID();
    }

    @PostMapping(path="/{id}/createListing")
    public @ResponseBody Optional<Listing> createListing(@RequestParam String productName, @RequestParam double price, @RequestParam Date date, @PathVariable int id){
        //without is present check, add it later
        System.out.println("does it even get to this point?");
        Seller s = sellerDao.findById(id);
        Listing l = s.createListing(productName,price,date);
        listingDao.save(l);
        return listingDao.get(l.getListingID());
    }

  /*  @PostMapping(path="/{id}/createListing")
    public @ResponseBody String createListing(@RequestBody Listing l, @PathVariable int id){
        //without is present check, add it later
        System.out.println("does it even get to this point?");
        Seller s = sellerDao.get(id).get();
        Listing l1 = s.createListing(l.getProductName(),l.getPrice(),l.getDate());
        listingDao.save(l1);
        return "Listing has been created";
    }*/


    @GetMapping(path="/{id}/listings")
    public @ResponseBody List<Listing> showListings(@PathVariable int id){

        return listingDao.findBySellerID(id);

    }


}
