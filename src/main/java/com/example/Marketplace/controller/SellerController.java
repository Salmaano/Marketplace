package com.example.Marketplace.controller;

import com.example.Marketplace.entity.Listing;
import com.example.Marketplace.repository.ListingRepository;
import com.example.Marketplace.entity.Seller;
import com.example.Marketplace.repository.SellerRepository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping(path="/seller")
public class SellerController {

    private SellerRepository sellerRepository;
    private ListingRepository listingRepository;

    public SellerController(SellerRepository sellerRepository, ListingRepository listingRepository){
        this.sellerRepository = sellerRepository;
        this.listingRepository = listingRepository;
    }

    /*@PostMapping(path="/create")
    public @ResponseBody String createNewSeller (@RequestParam String firstName, @RequestParam String lastName, @RequestParam String number) {

        Seller s = new Seller(firstName,lastName,number);
        sellerRepository.save(s);
        return "Saved"+s.getID();
    }*/


    @PostMapping(path="/create")
    public @ResponseBody String createNewSeller (@Valid @RequestBody Seller s) {
        sellerRepository.save(s);
        return "Saved, this is your ID for future reference: "+s.getID();
    }

    @PostMapping(path="/{id}/createListing")
    public @ResponseBody
    Listing createListing(@RequestParam String productName, @RequestParam double price, @RequestParam Date date, @PathVariable int id){
        //without is present check, add it later
        Seller s = sellerRepository.findById(id).get();
        Listing l = s.createListing(productName,price,date);
        return listingRepository.save(l);
    }
    @GetMapping(path="/{id}/listings")
    public @ResponseBody List<Listing> showListings(@PathVariable int id){

        return listingRepository.findBySellerID(id);

    }


}
