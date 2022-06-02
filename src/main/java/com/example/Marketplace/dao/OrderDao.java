package com.example.Marketplace.dao;

import com.example.Marketplace.entity.Order;
import com.example.Marketplace.repository.OrderRepository;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component("OrderDao")
public class OrderDao implements Dao<Order>{

    private OrderRepository orderRepository;
    private ListingDao listingDao;
    private BuyerDao buyerDao;
    private SellerDao sellerDao;

    public OrderDao(OrderRepository orderRepository, BuyerDao buyerDao, ListingDao listingDao, SellerDao sellerDao){
        this.orderRepository = orderRepository;
        this.listingDao = listingDao;
        this.buyerDao = buyerDao;
        this.sellerDao = sellerDao;
    }

    @Override
    public Optional<Order> get(long id){
        return Optional.ofNullable(orderRepository.getById((int)id));
    }

    @Override
    public List<Order> getAll(){
        return orderRepository.findAll();
    }

    @Override
    public void save(Order order){
        if (buyerDao.get(order.getBuyerID()).get()!=null & listingDao.get(order.getListingID()).get()!=null){
            orderRepository.save(order);
        }

        else{
            System.out.println("either the listing or the buyer does not exist. Make sure you have entered the correct details");
        }
    }

    @Override
    public void update(Order order, String[] params){
        if (orderRepository.findById(order.getOrderID()).get()!= null){
            order.setAmount(Double.parseDouble(params[0]));

            Date date = null;
            try{
                date = new SimpleDateFormat("dd/MM/yyyy").parse(params[1]);
            }
            catch (ParseException p){
                System.out.println(p);
            }
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            order.setDate(sqlDate);
        }

        else {
            System.out.println("this order does not exist");
        }
    }

    @Override
    public void delete(long id){
        if(orderRepository.getById((int)id)!=null) {
            orderRepository.deleteById((int) id);
        }
        else{
            System.out.println("this order does not exist");
        }
    }

}
