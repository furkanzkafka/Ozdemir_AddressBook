import address.data.*;

import java.util.List;
import java.util.Scanner;

public class AddressBookApplication {
    /**
     * Starting the program.
     *
     * @param args command line arguments
     */
    public static void main(String [] args) {
        AddressBook book = new AddressBook();
        Scanner scanner = new Scanner(System.in);

        do {
            String choice = Menu.prompt_menu();

            switch (choice.toUpperCase()) {
                case "A":
                    String input = Menu.prompt_file();
                    book.readFromFile(input);
                    System.out.println("File read successfully.");
                    break;
                case "B":
                    AddressBookEntry entry = Menu.prompt_addition();
                    book.add(entry);
                    System.out.println("Address added to the Address Book.");
                    break;
                case "C":
                    input = Menu.prompt_Removal();
                    if (book.remove(input)) {
                        System.out.println("Address removed successfully.");
                    } else {
                        System.out.println("Address not found.");
                    }
                    break;
                case "D":
                    input = Menu.prompt_Find();
                    List<AddressBookEntry> list = book.find(input);
                    if (list.isEmpty()) {
                        System.out.println("No matching entries found.");
                    } else {
                        int counter = 1;
                        for (AddressBookEntry e : list) {
                            System.out.println(counter + ": " + e.toString());
                            counter++;
                        }
                    }
                    break;
                case "E":
                    book.list();
                    break;
                case "F":
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (!choice.equalsIgnoreCase("F"));

        scanner.close(); // Close Scanner to avoid resource leaks

    }
}