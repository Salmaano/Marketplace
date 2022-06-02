package com.example.Marketplace.controller;

import com.example.Marketplace.dao.ListingDao;
import com.example.Marketplace.entity.Listing;
import com.example.Marketplace.repository.ListingRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ListingController {

    private ListingDao listingDao;

    public ListingController(ListingDao listingDao){

        this.listingDao = listingDao;
    }

    @GetMapping(path="/listings")
    public @ResponseBody List<Listing> getAllListingsWithJavaConfig(){
        return listingDao.getAll();
    }
}
