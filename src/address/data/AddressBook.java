package address.data;

import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.File;

/**
 * Represents an address book containing a collection of AddressBookEntry objects.
 * Provides methods to manipulate the AddressBook collection.
 */
public class AddressBook {

    // Collection of addresses
    LinkedList<AddressBookEntry>contacts;

    /**
     * Constructor to create an empty address book.
     */
    public AddressBook(){
        contacts = new LinkedList<AddressBookEntry>();
    }

    /**
     * Removes all contacts with a specific last name from the address book.
     *
     * @param last_name the last name of the contacts to be removed
     */
    public void remove(String last_name) {
        // Loop through the contacts to find and remove all matching contacts

        AddressBookEntry entry = null;
        int counter = 0;
        while((entry = findAddress(last_name)) != null) {
            contacts.remove(entry);
            counter++;
        }

        // Print a message based on whether any contacts were removed or not
        if(counter == 0 ) {
            System.out.println("No address found!");
        } else {
            System.out.printf("Address has been removed");
        }
    }

    /**
     * Loads contacts from a file into the address book.
     *
     * @param file_name the name of the file to load contacts from
     */
    public void readFromFile(String file_name) {
        try (Scanner reader = new Scanner(new File(file_name))) {
            int counter = 0;

            while (reader.hasNextLine()) {
                String firstName = reader.nextLine();
                String lastName = reader.nextLine();
                String street = reader.nextLine();
                String city = reader.nextLine();
                String state = reader.nextLine();
                int zip = Integer.parseInt(reader.nextLine());
                String email = reader.nextLine();
                String telephone = reader.nextLine();

                AddressBookEntry entry = new AddressBookEntry(firstName, lastName, street,
                        city, state, zip, email, telephone);

                this.contacts.add(entry);
                counter++;
            }
            System.out.printf("Success! Loaded %d addresses. Total: %d%n", counter, contacts.size());
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + file_name);
        }
    }

    /**
     * Mthod to find a contact by last name.
     *
     * @param last_name the last name of the contact to find
     * @return the contact with the specified last name, or null if not found
     */
    private AddressBookEntry findAddress(String last_name) {
        for(AddressBookEntry entry: contacts) {
            if(entry.getLastName().equalsIgnoreCase(last_name)) {
                return entry;
            }
        }

        return null;
    }

    /**
     * Adds a new contact to the address book.
     *
     * @param entry the contact to add
     */
    public void add(AddressBookEntry entry) {
        contacts.addLast(entry);
    }


    /**
     * Lists all contacts in the address book sorted by last name.
     */
    public void list() {

        // Sort with respect to Last name
        contacts.sort((a, b)-> a.getLastName().compareTo(b.getLastName()));

        Iterator it = contacts.iterator();
        int counter = 1;
        while(it.hasNext()){
            System.out.println(counter + ": " + it.next());
            counter++;
        }
    }


    /**
     * Finds contacts by last name or partial last name.
     *
     * @param find_lastname the last name or partial last name to search for
     * @return a list of contacts matching the search criteria
     */
    public LinkedList<AddressBookEntry> find(String find_lastname) {
        LinkedList<AddressBookEntry> list = new LinkedList<>();

        // Loop through the contacts to find the ones with matching last names
        for(AddressBookEntry address: contacts) {
            if(address.getLastName().startsWith(find_lastname)) {
                list.add(address);
            }
        }

        return list; // Return the list of matching contacts
    }
}