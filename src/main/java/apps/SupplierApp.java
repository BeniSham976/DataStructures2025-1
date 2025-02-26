package apps;

import model.Supplier;
import utils.CommandLineUtils;
import utils.SupplierLinkList;

import java.util.Scanner;

public class SupplierApp {
    // Create scanner to use when taking in data from user
    // Private static variable so it can be used by all methods in this class
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        // Create an instance of SupplierLinkList
        SupplierLinkList suppliers = new SupplierLinkList();

        // Create 3 hard-coded Supplier objects
        Supplier supplierA = new Supplier("Fishing Tackle Ltd", "42 Wallaby Way, Sydney", 0, 2003);
        Supplier supplierB = new Supplier("Dental Equipment Inc", "EAC, Tasman Sea", 38.50, 2003);
        Supplier supplierC = new Supplier("Marine Life Institute", "Morro Bay, California", 1800, 2016);

        // Add suppliers to list using add()
        suppliers.add(supplierA);
        suppliers.add(supplierB);
        suppliers.add(supplierC);

        // Display suppliers
        displaySuppliers(suppliers);

        // Create user-defined supplier and add using addFirst()
        Supplier userDefinedA = createSupplier();
        suppliers.addFirst(userDefinedA);
        displaySuppliers(suppliers);

        // Create user-defined supplier and add using add(value, pos)
        Supplier userDefinedB = createSupplier();
        // Prompt for position at which to add
        int index = CommandLineUtils.getIntInRange("At which list position should " + userDefinedB.getName() + " be " +
                "added? (0 - " + suppliers.size() + " inclusive)", 0, suppliers.size());
        suppliers.add(userDefinedB, index);
        displaySuppliers(suppliers);

        System.out.println("Program terminating...");
    }

    public static Supplier createSupplier(){
        System.out.println("######## Creating supplier ########");
        System.out.println("Please enter supplier name:");
        String name = input.nextLine();
        System.out.println("Please enter supplier address:");
        String address = input.nextLine();

        double amountOwed = CommandLineUtils.getDoubleAboveValue("Please enter amount" +
                " owed:", 0);
        double creditLimit = CommandLineUtils.getDoubleAboveValue("Please enter credit limit:", 0);

        System.out.println("################################ ");

        return new Supplier(name, address, amountOwed, creditLimit);
    }

    public static void displaySuppliers(SupplierLinkList suppliers){
        System.out.println("------------ Supplier List ------------");
        // Loop through and display each supplier (and position) in list
        for (int i = 0; i < suppliers.size(); i++) {
            Supplier supplier = suppliers.get(i);
            System.out.println(i + ") " + supplier.simpleFormat());
        }
        System.out.println("------------------------------------");
    }
}
