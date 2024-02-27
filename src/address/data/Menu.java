package address.data;

import java.util.Scanner;

/**
 * Class to interadct with the user thorugh Standard Keyboard.
 */

public class Menu {

    private static Scanner keyboard = new Scanner(System.in);

    /**
     * Function to display the Menu to the user and read the menu selection
     *
     * @return selected menu
     */
    public static String prompt_menu() {

        System.out.println("******************************");
        System.out.println("Please enter in your menu selection");
        System.out.println("a) Loading From File");
        System.out.println("b) Addition");
        System.out.println("c) Removal");
        System.out.println("d) Find");
        System.out.println("e) Listing");
        System.out.println("");
        System.out.println("f) Quit");
        System.out.println("******************************");
        System.out.print("\n> ");

        String input = keyboard.next();

        return input.toLowerCase();
    }

    /**
     * Function to prompt the user for the new AddressEntry and return newly
     * created Address Entry
     *
     * @return new address entry to add
     */
    public static AddressBookEntry prompt_addition() {
        AddressBookEntry entry = null;
        keyboard.nextLine(); // first line character

        String firstName = prompt_FirstName();
        String lastName = prompt_LastName();
        String street = prompt_Street();
        String city = prompt_City();
        String state = prompt_State();
        int zip = prompt_Zip();
        keyboard.nextLine(); // first line character
        String telephone = prompt_Phone();
        String email = prompt_Email();

        // Create address entry and return it
        entry = new AddressBookEntry(firstName, lastName, street, city, state,
                zip, telephone, email);

        return entry;
    }

    /**
     * Function to Prompt and read start_of_last_name to search for the Addresses.
     *
     * @return start of last name
     */
    public static String prompt_Find() {
        System.out.print("\nEnter in all or the beginning of the Last Name of the\n" +
                "contact you wish to find:\n> ");
        String input = keyboard.next();
        return input;
    }

    /**
     * Function to prompt and read the file name.
     *
     * @return file name
     */
    public static String prompt_file() {
        System.out.print("\nEnter the file name to load the Address Book:\n> ");
        String input = keyboard.next();
        return input;
    }

    /**
     * Function to prompt for the last name to remove the address.
     *
     * @return last name
     */
    public static String prompt_Removal() {
        System.out.print("\nEnter the last name to remove AddressEntry:\n> ");
        String input = keyboard.next();
        return input;
    }

    /**
     * Function to Prompt for the First name of the user and
     * return it.
     *
     * @return firstName
     */
    public static String prompt_FirstName() {
        System.out.print("\nFirst Name: \n> ");
        String input = keyboard.nextLine();
        return input;
    }

    /**
     * Function to prompt for the Last Name, and return it.
     *
     * @return last name
     */
    public static String prompt_LastName() {
        System.out.print("\nLast Name: \n> ");
        String input = keyboard.nextLine();
        return input;
    }

    /**
     * Prompt and Read the Street from the user.
     *
     * @return street
     */
    public static String prompt_Street() {
        System.out.print("\nStreet: \n> ");
        String input = keyboard.nextLine();
        return input;
    }

    /**
     * Function to prompt and read the City from the user.
     *
     * @return city
     */
    public static String prompt_City() {
        System.out.print("\nCity: \n> ");
        String input = keyboard.nextLine();
        return input;
    }

    /**
     * Function to prompt and read the State from the user.
     *
     * @return state
     */
    public static String prompt_State() {
        System.out.print("\nState: \n> ");
        String input = keyboard.nextLine();
        return input;
    }

    /**
     * Function to read the Telephone from the user.
     *
     * @return telephone
     */
    public static String prompt_Phone() {
        System.out.print("\nTelephone: \n> ");
        String input = keyboard.nextLine();
        return input;
    }

    /**
     * Function to read the Email from the user.
     *
     * @return Email
     */
    public static String prompt_Email() {
        System.out.print("\nEmail: \n> ");
        String input = keyboard.nextLine();
        return input;
    }

    /**
     * Function to read the Zip code from the user.
     *
     * @return zip code
     */
    public static int prompt_Zip() {
        System.out.print("\nZipCode: \n> ");
        int input = keyboard.nextInt();
        return input;
    }

}