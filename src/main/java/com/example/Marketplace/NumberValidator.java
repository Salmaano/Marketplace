package com.example.Marketplace;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NumberValidator implements ConstraintValidator<NumberConstraint, String> {

    private BuyerRepository buyerRepository;
    private SellerRepository sellerRepository;

    public NumberValidator(BuyerRepository buyerRepository, SellerRepository sellerRepository){

        this.buyerRepository = buyerRepository;
        this.sellerRepository = sellerRepository;
    }

    @Override
    public void initialize(NumberConstraint number){

    }


    //this annotation should only  be applicable to resource attributes that is mapped  to a database field, specifically number.
    //not sure how to ensure it is a specified field in the database at this point
    @Override
    public boolean isValid(String numberField, ConstraintValidatorContext cxt){

        if (buyerRepository.findByNumber(numberField) == null & sellerRepository.findByNumber(numberField) == null){
            return true;
        }

        else if(buyerRepository.findByNumber(numberField) == null | sellerRepository.findByNumber(numberField) == null)
        {

        }
        return false;
    }


}
