package model;

import java.util.Objects;

public class Supplier {
    private String name;
    private String address;
    private double amountOwed;
    private double creditLimit;

    public Supplier(String name, String address, double amountOwed, double creditLimit){
        // Use setters to avoid repeating validation logic in here
        setName(name);
        setAddress(address);
        setAmountOwed(amountOwed);
        setCreditLimit(creditLimit);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null){
            throw new IllegalArgumentException("Name cannot be null.");
        }
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if(address == null){
            throw new IllegalArgumentException("Address cannot be null.");
        }
        this.address = address;
    }

    public double getAmountOwed() {
        return amountOwed;
    }

    public void setAmountOwed(double amountOwed) {
        if(amountOwed < 0){
            throw new IllegalArgumentException("Amount owed cannot be less than 0");
        }
        this.amountOwed = amountOwed;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        if(creditLimit < 0){
            throw new IllegalArgumentException("Credit limit cannot be less than 0");
        }
        this.creditLimit = creditLimit;
    }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof Supplier)){
            return false;
        }
        Supplier s = (Supplier) o;

        if(!this.name.equals(s.name)){
            return false;
        }
        if(!this.address.equals(s.address)){
            return false;
        }
        if(this.amountOwed != s.amountOwed){
            return false;
        }
        if(this.creditLimit != s.creditLimit){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode(){
        int hash = 13;
        hash = hash + (11 * Objects.hash(this.name));
        hash = hash + (11 * Objects.hash(this.address));
        hash = hash + (11 * Objects.hash(this.amountOwed));
        hash = hash + (11 * Objects.hash(this.creditLimit));

        return hash;
    }
}
