package com.example.Marketplace;

import java.sql.Date;

import org.yaml.snakeyaml.events.Event.ID;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name="Seller")
@Table(name="sellers")
public class Seller extends User {


    public Seller(String firstName, String lastName, String number){

        super(firstName,lastName,number);


    }
    public Seller(){

    }


    public Listing createListing(String productName, double price, Date date){

        return new Listing(productName, getID(), price, date);


    }
    
}
