package com.example.Marketplace;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NumberValidator implements ConstraintValidator<NumberConstraint, String> {

    private BuyerRepository buyerRepository;

    public NumberValidator(BuyerRepository buyerRepository){

        this.buyerRepository = buyerRepository;
    }

    @Override
    public void initialize(NumberConstraint number){

    }


    //this annotation should only  be applicable to resource attributes that is mapped  to a database field, specifically number.
    //not sure how to ensure it is a specified field in the database at this point
    @Override
    public boolean isValid(String numberField, ConstraintValidatorContext cxt){

        if (buyerRepository.findByNumber(numberField) == null){
            return true;
        }
        return false;
    }


}
