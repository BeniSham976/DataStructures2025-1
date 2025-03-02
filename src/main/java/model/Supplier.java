package model;

import java.util.Objects;

public class Supplier {
    private String name;
    private String address;
    private double amountOwed;
    private double creditLimit;

    /**
     * Creates a fully populated Supplier object.
     * @param name The name of the Supplier (cannot be null)
     * @param address The address of the Supplier (cannot be null)
     * @param amountOwed The amount owed by the Supplier (cannot be less than 0)
     * @param creditLimit The credit limit for the Supplier (cannot be less than 0)
     * @throws IllegalArgumentException If name or address are null, or if amountOwed or creditLimit are less than 0
     */
    public Supplier(String name, String address, double amountOwed, double creditLimit){
        // Use setters to avoid repeating validation logic in here
        setName(name);
        setAddress(address);
        setAmountOwed(amountOwed);
        setCreditLimit(creditLimit);
    }

    /**
     * Retrieves the name of the supplier
     * @return The name of the supplier.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of this supplier.
     * @param name the new name to be used (cannot be null)
     * @throws IllegalArgumentException if the supplied value is null
     */
    public void setName(String name) {
        if(name == null){
            throw new IllegalArgumentException("Name cannot be null.");
        }
        this.name = name;
    }

    /**
     * Retrieves the address of the supplier
     * @return The address of the supplier.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set the address of this supplier.
     * @param address the new address to be used (cannot be null)
     * @throws IllegalArgumentException if the supplied value is null
     */
    public void setAddress(String address) {
        if(address == null){
            throw new IllegalArgumentException("Address cannot be null.");
        }
        this.address = address;
    }

    /**
     * Retrieves the amount owed by the supplier
     * @return The amount owed by the supplier.
     */
    public double getAmountOwed() {
        return amountOwed;
    }

    /**
     * Set the amount owed by this supplier.
     * @param amountOwed the new amount owed to be used (must be greater than 0)
     * @throws IllegalArgumentException if the supplied value is less than 0
     */
    public void setAmountOwed(double amountOwed) {
        if(amountOwed < 0){
            throw new IllegalArgumentException("Amount owed cannot be less than 0");
        }
        this.amountOwed = amountOwed;
    }

    /**
     * Retrieves the credit limit of the supplier
     * @return The credit limit of the supplier.
     */
    public double getCreditLimit() {
        return creditLimit;
    }

    /**
     * Set the creditLimit of this supplier.
     * @param creditLimit the new credit limit to be used (must be greater than 0)
     * @throws IllegalArgumentException if the supplied value is less than 0
     */
    public void setCreditLimit(double creditLimit) {
        if(creditLimit < 0){
            throw new IllegalArgumentException("Credit limit cannot be less than 0");
        }
        this.creditLimit = creditLimit;
    }

    /**
     * Checks supplied object against the current supplier for equality. Equality is based on name, address,
     * credit limit and amount owed all being identical.
     * @param o The object being compared against.
     * @return True if all fields match; false if the object supplied is not a Supplier or one or more fields
     * do not match.
     */
    @Override
    public boolean equals(Object o){
        if(o == null){
            return false;
        }
        if(this.getClass() != o.getClass()){
            return false;
        }
        Supplier s = (Supplier) o;
        if(!Objects.equals(this.name, s.name)){
            return false;
        }
        if(!Objects.equals(this.address, s.address)){
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

    /**
     * Generates a hash code representing the data within this supplier. The hashcode is based on the identity of the
     * object, i.e. the same information used in equals() to decide if two objects are identical.
     * @return a hash code value representing this object.
     */
    @Override
    public int hashCode(){
        int hash = 13;
        hash = hash + (11 * Objects.hash(this.name));
        hash = hash + (11 * Objects.hash(this.address));
        hash = hash + (11 * Objects.hash(this.amountOwed));
        hash = hash + (11 * Objects.hash(this.creditLimit));

        return hash;
    }

    /**
     * Returns a String representation of this supplier.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "Supplier{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", amountOwed=" + amountOwed +
                ", creditLimit=" + creditLimit +
                '}';
    }

    /**
     * Returns a simplified String representation of this supplier containing only their name and address.
     * @return a string containing the name and address of the supplier.
     */
    public String simpleFormat(){
        return name + " - " + address;
    }
}
