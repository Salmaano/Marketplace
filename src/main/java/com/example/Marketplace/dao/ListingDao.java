package com.example.Marketplace.dao;

import com.example.Marketplace.entity.Listing;
import com.example.Marketplace.repository.ListingRepository;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component("ListingDao")
public class ListingDao implements Dao<Listing>{

    private ListingRepository listingRepository;

    public ListingDao(ListingRepository listingRepository){
        this.listingRepository = listingRepository;
    }

    @Override
    public Optional<Listing> get(long id){
        return Optional.ofNullable(listingRepository.getById((int)id));
    }

    @Override
    public List<Listing> getAll(){
        return listingRepository.findAll();
    }

    @Override
    public void save(Listing listing){
        listingRepository.save(listing);
    }

    //can add exception later potentially
    @Override
    public void update(Listing listing, String[] params){

        if(listingRepository.findById(listing.getListingID()) != null){
            listing.setProductName(Objects.requireNonNull(params[0],"Product name cannot be null"));
            listing.setPrice(Objects.requireNonNull(Integer.parseInt(params[1]),"Price cannot be null"));

                Date date = null;
            try{
                date = new SimpleDateFormat("dd/MM/yyyy").parse(params[2]);
            }
            catch (ParseException p){
                System.out.println(p);
            }
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            listing.setDate(Objects.requireNonNull(sqlDate,"Date cannot be null"));
        }

        else {
            System.out.println("this listing does not exist");
        }

    }

    @Override
    public void delete(long id){
        listingRepository.deleteById((int) id);
    }


    public List<Listing> findBySellerID(int id){
        return listingRepository.findBySellerID(id);
    }






}
