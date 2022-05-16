package com.example.Marketplace;

import javax.persistence.*;
import java.sql.Date;

@Entity(name="Listing")
@Table(name="listings")
public class Listing {
    
    private String productName;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="listing_id")
    private int listingID;
    @Column(name="seller_id")
    private int sellerID;
    private double price;
    private Date date;

    public Listing(){

    }

    public Listing(String productName, int sellerID, double price, Date date){

        this.productName = productName;
        this.sellerID = sellerID;
        this.price = price;
        this.date = date;
    }

    /**
     * @return String return the productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName the productName to set
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * @return int return the listingID
     */
    public int getListingID() {
        return listingID;
    }

    /**
     * @param listingID the listingID to set
     */
    public void setListingID(int listingID) {
        this.listingID = listingID;
    }

    /**
     * @return int return the sellerID
     */
    public int getSellerID() {
        return sellerID;
    }

    /**
     * @param sellerID the sellerID to set
     */
    public void setSellerID(int sellerID) {
        this.sellerID = sellerID;
    }

    /**
     * @return double return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return Date return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

}
