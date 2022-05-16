package com.example.Marketplace;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Validated
@RestController
@RequestMapping(path="/buyer")
public class BuyerController {


    private BuyerRepository buyerRepository;
    private ListingRepository listingRepository;
    private OrderRepository orderRepository;

    public BuyerController(BuyerRepository buyerRepository, ListingRepository listingRepository, OrderRepository orderRepository) {

        this.buyerRepository = buyerRepository;
        this.listingRepository = listingRepository;
        this.orderRepository = orderRepository;
    }

    /*@PostMapping(path="/create")
    public @ResponseBody String createNewBuyer (@RequestParam String firstName, @RequestParam String lastName, @RequestParam String number) {

        Buyer b = new Buyer(firstName,lastName,number);
        buyerRepository.save(b);
        return "Saved, this is your ID for future reference: "+b.getID();
    }*/


    @PostMapping(path="/create")
    public @ResponseBody String createNewBuyer (@Valid @RequestBody Buyer b) {
        buyerRepository.save(b);
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

    @GetMapping(path="/{id}/makeOrder/{listing_id}")
    public @ResponseBody Order makeOrder(@PathVariable int id, @PathVariable int listing_id ){
        Listing l  = listingRepository.findById(listing_id).get();
        Order o = new Order(l.getSellerID(),id,l.getListingID(),l.getPrice(),l.getDate());
        return orderRepository.save(o);

    }
}