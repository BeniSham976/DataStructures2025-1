package utils;

import java.util.Scanner;

public class CommandLineUtils {
    private final static Scanner INPUT = new Scanner(System.in);

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
            if(INPUT.hasNextInt()){
                valid = true;
                value = INPUT.nextInt();
            }else{
                System.out.println("Please enter an integer value.");
            }
            // Clear buffer to remove bad data/remaining newline character from number entry
            INPUT.nextLine();
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
            if(INPUT.hasNextDouble()){
                valid = true;
                value = INPUT.nextDouble();
            }else{
                System.out.println("Please enter a decimal value.");
            }
            // Clear buffer to remove bad data/remaining newline character from number entry
            INPUT.nextLine();
        }

        return value;
    }

    /**
     * Take in a decimal (double) value from the user within the specified range (inclusive).
     * <p>
     * All values outside the range low to high will be rejected and the method will continue to loop until a double
     * in that range (inclusive) is
     * entered.
     * </p>
     * @param prompt the information text to be displayed to the user before the value is read in
     * @param low the bottom end of the range (inclusive)
     * @param high the top end of the range (inclusive)
     * @return the first double entered by the user falling between low and high (inclusive)
     * @throws IllegalArgumentException if low > high
     */
    public static double getDoubleInRange(String prompt, double low, double high){
        // Validate values to confirm low is less than or equal to high
        if(low > high){
            throw new IllegalArgumentException("Low end of range must be less than or equal to high end of range (" + low + " > " + high+ ")");
        }
        boolean valid = false;
        double value = -1;

        while (!valid){
            // Get a valid double
            value = getDouble(prompt);
            // Check it's within the desired range
            if(value < low || value > high){
                System.out.println("Value must be a double within " + low + " and " + high + " (inclusive). Please " +
                        "try again.");
            }else{
                valid = true;
            }
        }

        return value;
    }

    /**
     * Take in a decimal (double) value from the user above the specified minimum value (inclusive).
     * <p>
     * All values below the supplied minimum will be rejected and the method will continue to loop until a double equal to or above the specified minimum is entered.
     * </p>
     * <p>
     *     This method wraps the logic of getDoubleInRange, specifying the upper bound as the maximum allowable Double.
     * </p>
     * @param prompt the information text to be displayed to the user before the value is read in
     * @param low the minimum allowable value (inclusive)
     * @return the first double entered by the user greater than or equal to the specified minimum value
     */
    public static double getDoubleAboveValue(String prompt, double low){
        return getDoubleInRange(prompt, low, Double.MAX_VALUE);
    }
}
