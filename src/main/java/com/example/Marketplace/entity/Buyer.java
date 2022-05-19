package com.example.Marketplace.entity;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name="Buyer")
@Table(name="buyers")
public class Buyer extends User{

    public Buyer(){
        
    }

    public Buyer (String firstName, String lastName, String number){

        super(firstName, lastName, number);

    }
}
