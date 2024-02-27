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
        AddressBook address = new AddressBook();
        AddressBookEntry entry = new AddressBookEntry();

        Scanner scanner = new Scanner(System.in);
        String selection;

        while(true){

            Menu.prompt_menu();
            selection = scanner.nextLine();

            // Perform actions based on user input
            if("a".equals(selection)){
                String file = scanner.nextLine();
                address.readFromFile(file);

            }else if("b".equals(selection)){
                entry = Menu.prompt_addition();
                address.add(entry);
                System.out.println("Success! Address added...");
            }else if("c".equals(selection)){
                // Remove an address entry
                System.out.print("Remove data in progress... Please type last name for remove: ");
                String last_name = scanner.nextLine();
                address.remove(last_name);

            }else if("d".equals(selection)){
                // Find address entries by last name
                System.out.print("Search in progress... Please type last name to find:");
                String last_name = scanner.nextLine();
                address.find(last_name);
            }else if("e".equals(selection)){
                // List all address entries
                address.list();

            }else if("f".equals(selection)){
                System.out.println("Exiting Application... Thank you for your time!");
                return;
            }
            else{
                System.out.println("Please read the instructions carefully...");
                break;
            }
        }
    }
}