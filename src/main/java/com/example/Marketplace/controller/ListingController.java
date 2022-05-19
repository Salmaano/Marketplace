package com.example.Marketplace.controller;

import com.example.Marketplace.entity.Listing;
import com.example.Marketplace.repository.ListingRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ListingController {

    private ListingRepository listingRepository;

    public ListingController(ListingRepository listingRepository){

        this.listingRepository = listingRepository;
    }

    @GetMapping(path="/listings")
    public @ResponseBody List<Listing> getAllListingsWithJavaConfig(){
        return listingRepository.findAll();
    }
}
