package utils;

import java.util.Scanner;

public class CommandLineUtils {
    private static Scanner input = new Scanner(System.in);

    /**
     * Take in an integer value from the user. All other values will be rejected and the method will continue to loop
     * until an int is entered.
     * @param prompt the information text to be displayed to the user before the value is read in
     * @return the first int entered by the user
     */
    public static int getInt(String prompt){
        boolean valid = false;
        int value = -1;

        while(!valid){
            System.out.println(prompt);
            if(input.hasNextInt()){
                valid = true;
                value = input.nextInt();
            }else{
                System.out.println("Please enter an integer value.");
            }
            // Clear buffer to remove bad data/remaining newline character from number entry
            input.nextLine();
        }

        return value;
    }

    /**
     * Take in a decimal (double) value from the user. All other values will be rejected and the method will continue
     * to loop
     * until a double is entered.
     * @param prompt the information text to be displayed to the user before the value is read in
     * @return the first double entered by the user
     */
    public static double getDouble(String prompt){
        boolean valid = false;
        double value = -1;

        while(!valid){
            System.out.println(prompt);
            if(input.hasNextDouble()){
                valid = true;
                value = input.nextDouble();
            }else{
                System.out.println("Please enter a decimal value.");
            }
            // Clear buffer to remove bad data/remaining newline character from number entry
            input.nextLine();
        }

        return value;
    }
}
