package com.example.Marketplace.controller;

import com.example.Marketplace.dao.BuyerDao;
import com.example.Marketplace.dao.ListingDao;
import com.example.Marketplace.dao.OrderDao;
import com.example.Marketplace.entity.Buyer;
import com.example.Marketplace.entity.Listing;
import com.example.Marketplace.entity.Order;
import com.example.Marketplace.repository.BuyerRepository;
import com.example.Marketplace.repository.ListingRepository;
import com.example.Marketplace.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Validated
@RestController
@RequestMapping(path="/buyer")
public class BuyerController {


    private BuyerRepository buyerRepository;
    private BuyerDao buyerDao;
    private ListingDao listingDao;
    private OrderDao orderDao;

    public BuyerController(BuyerDao buyerDao, OrderDao orderDao, ListingDao listingDao) {
        this.buyerDao = buyerDao;
        this.orderDao = orderDao;
        this.listingDao = listingDao;
    }

    /*@PostMapping(path="/create")
    public @ResponseBody String createNewBuyer (@RequestParam String firstName, @RequestParam String lastName, @RequestParam String number) {

        Buyer b = new Buyer(firstName,lastName,number);
        buyerRepository.save(b);
        return "Saved, this is your ID for future reference: "+b.getID();
    }*/


    //@valid is added to enable bean validation on the request body I think??
    @PostMapping(path="/create")
    public @ResponseBody String createNewBuyer (@Valid @RequestBody Buyer b) {
        buyerDao.save(b);
        return "Saved, this is your ID for future reference: "+b.getID();
    }


/*    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> handleValidExceptions(MethodArgumentNotValidException exception){
        Map<String,String> errors = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach((error) -> {

            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName,errorMessage);
        });
        return errors;
    }*/

    @GetMapping(path="/test")
    public String test() {
        return "testing";
    }

    @PostMapping (path="/{id}/makeOrder/{listing_id}")
    public @ResponseBody Order makeOrder(@PathVariable int id, @PathVariable int listing_id ){
        Listing l  = listingDao.get(listing_id).get();
        Order o = new Order(l.getSellerID(),id,l.getListingID(),l.getPrice(),l.getDate());
        orderDao.save(o);
        return orderDao.get(o.getOrderID()).get();

    }
}
