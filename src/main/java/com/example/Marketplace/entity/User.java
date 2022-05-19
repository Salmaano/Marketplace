package com.example.Marketplace.entity;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;

@MappedSuperclass
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;

    @Column(name="first_name")
    @Size(min=2, max=30, message = "Name must be between 2 and 30 characters long")
    private String firstName;

    @Column(name="last_name")
    @Size(min=2, max=30, message = "Name must be between 2 and 30 characters long")
    private String lastName;

    @Column(unique=true)
    @Pattern(regexp="((\\+|00)([1-9][0-9]{0,2}-)([0-9]{4,12}))|(03[0-9]{9})",message = "The number provided does not adhere to the format specified")
    private String number;

    
    public User(String firstName, String lastName, String number){

        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;

    }

    public User(){

    }
    /**
     * @return int return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * @return String return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return String return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return int return the number
     */
    public String getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(String number) {
        this.number = number;
    }

}
