package model;

import java.util.Objects;

public class Supplier {
    private String name;
    private String address;
    private double amountOwed;
    private double creditLimit;

    public Supplier(String name, String address, double amountOwed, double creditLimit){
        this.name = name;
        this.address = address;
        this.amountOwed = amountOwed;
        this.creditLimit= creditLimit;
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
