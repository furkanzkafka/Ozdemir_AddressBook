package address.data;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.File;

/**
 *
 * Class to represent an AddressBook that is a collection of addressEntry objects.
 *
 * Provides methods to manipulate the AddressBook Collection.
 */
public class AddressBook {

    // Collection of addresses
    LinkedList<AddressBookEntry>contacts;

    /**
     * Constructor to setup empty AddressBook.
     */
    public AddressBook(){
        contacts = new LinkedList<AddressBookEntry>();
    }

    /**
     * Remove all the reocrds for a given Last Name.
     *
     * @param lastName
     */
    public void remove(String lastName) {

        AddressBookEntry entry = null;
        int counter = 0;
        while((entry = findAddress(lastName)) != null) {
            contacts.remove(entry);
            counter++;
        }

        if(counter == 0 ) {
            System.out.println("No Address has been removed from AddressBook");
        } else {
            System.out.printf("%n%d addressed has been removed from AddressBook%n", counter);
        }
    }

    /**
     * Function to load AddressBook from a given File.
     *
     * @param fileName
     */
    public void readFromFile(String fileName) {
        try {

            File file = new File(fileName);
            Scanner reader = new Scanner(file);
            int counter = 0;

            while(reader.hasNextLine()) {

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

            // close file
            reader.close();

            System.out.printf("%nRead in %d new Addresses, successfully loaded, currently %d addressed%n",
                    counter, contacts.size());

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Helper method to find Address Entry for a given last name.
     *
     * @param lastName
     * @return address entry
     */
    private AddressBookEntry findAddress(String lastName) {
        for(AddressBookEntry entry: contacts) {
            if(entry.getLastName().equalsIgnoreCase(lastName)) {
                return entry;
            }
        }

        return null;
    }

    /**
     * Function to add new AddressEntry
     *
     * @param entry
     */
    public void add(AddressBookEntry entry) {
        contacts.addLast(entry);
    }

    /**
     * List all the Addressed in the AddressBook.
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
     * Function to Get the list of all the addresses that has last name starts with
     * given prefix.
     *
     * @param startOf_lastName
     * @return list of addresses
     */
    public LinkedList<AddressBookEntry> find(String startOf_lastName) {
        LinkedList<AddressBookEntry> list = new LinkedList<>();

        for(AddressBookEntry address: contacts) {
            if(address.getLastName().startsWith(startOf_lastName)) {
                list.add(address);
            }
        }

        return list;
    }
}