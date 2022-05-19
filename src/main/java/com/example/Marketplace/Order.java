package com.example.Marketplace;

import java.sql.Date;
import javax.persistence.*;
import javax.validation.constraints.Max;

@Entity(name="Order")
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="order_id")
    private int orderID;
    @Column(name="seller_id")
    private int sellerID;
    @Column(name="buyer_id")
    private int buyerID;

    @Column(name="listing_id")
    private int listingID;
    private double amount;
    private Date date;


    public Order(){

    }
    public Order(int sellerID, int buyerID, int listingID, double amount, Date date){

        this.sellerID = sellerID;
        this.buyerID = buyerID;
        this.amount = amount;
        this.date = date;
        this.listingID = listingID;

    }
    

    /**
     * @return int return the orderID
     */
    public int getOrderID() {
        return orderID;
    }

    /**
     * @param orderID the orderID to set
     */
    public void setOrderID(int orderID) {
        this.orderID = orderID;
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
     * @return int return the buyerID
     */
    public int getBuyerID() {
        return buyerID;
    }

    /**
     * @param buyerID the buyerID to set
     */
    public void setBuyerID(int buyerID) {
        this.buyerID = buyerID;
    }

    /**
     * @return double return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
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
