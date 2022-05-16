package com.example.Marketplace;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
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
