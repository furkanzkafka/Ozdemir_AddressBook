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
     * @param last_name
     */
    public void remove(String last_name) {

        AddressBookEntry entry = null;
        int counter = 0;
        while((entry = findAddress(last_name)) != null) {
            contacts.remove(entry);
            counter++;
        }

        if(counter == 0 ) {
            System.out.println("No address found!");
        } else {
            System.out.printf("Address has been removed");
        }
    }

    /**
     * Function to load AddressBook from a given File.
     *
     * @param file_name
     */
    public void readFromFile(String file_name) {
        try {
            File file = new File(file_name);
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
     * @param last_name
     * @return address entry
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
     * add new address
     *
     * @param entry
     */
    public void add(AddressBookEntry entry) {
        contacts.addLast(entry);
    }

    /**
     * List
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
     * finding
     *
     *
     * @param find_lastname
     * @return list
     */
    public LinkedList<AddressBookEntry> find(String find_lastname) {
        LinkedList<AddressBookEntry> list = new LinkedList<>();

        for(AddressBookEntry address: contacts) {
            if(address.getLastName().startsWith(find_lastname)) {
                list.add(address);
            }
        }

        return list;
    }
}