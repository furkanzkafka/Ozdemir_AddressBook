/**
 * This package defines the `AddressBookEntry` class,
 * which represents an entry in an address book.
 *
 * Each entry holds information about a person, including:
 * - First Name
 * - Last Name
 * - Street Address
 * - City
 * - State
 * - Zip Code
 * - Telephone Number
 * - Email Address
 *
 * This class provides functionalities to:
 * - Create an `AddressBookEntry` object with either default values or specific values provided as arguments.
 * - Access individual fields of the address entry through getter methods.
 * - Obtain a formatted string representation of the entire address entry.
 */
package address.data;
public class AddressBookEntry {

    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String state;
    private Integer zip;
    private String telephone;
    private String email;

    /**
     * Default constructor that creates an `AddressBookEntry` object with empty values for all fields.
     * This is useful when you need to create an entry and then set its values later.
     */

    public AddressBookEntry() {
        this.firstName = "";
        this.lastName = "";
        this.street = "";
        this.city = "";
        this.state = "";
        this.zip = 0;
        this.telephone = "";
        this.email = "";
    }

    /**
     * Parameterized constructor that creates an `AddressBookEntry` object and initializes its fields with the provided values.
     * This constructor is useful when you have all the information about a person readily available and want to create an entry directly.
     *
     * @param firstName of the person (String)
     * @param lastName of the person (String)
     * @param street address of the person (String)
     * @param city where the person resides (String)
     * @param state where the person resides (String)
     * @param zip postal code of the person's location (Integer)
     * @param telephone phone number of the person (String)
     * @param email email address of the person (String)
     */
    public AddressBookEntry(String firstName, String lastName, String street, String city, String state,
                        Integer zip, String telephone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.telephone = telephone;
        this.email = email;
    }

    @Override
    /**
     * Returns a formatted string representation of the entire `AddressBookEntry` object,
     * presenting the information in a human-readable and organized manner.
     *
     * @return a formatted string representation of the address entry
     */
    public String toString() {
        return String.format("%s %s\n  %s\n  %s, %s %d\n  %s\n  %s",
                firstName, lastName, street, city, state, zip, email, telephone);
    }

    /**
     * Returns a formatted string representation of the entire `AddressBookEntry` object,
     * presenting the information in a human-readable and organized manner.
     *
     * @return a formatted string representation of the address entry
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Function to get the Last Name in the AddressEntry Object.
     *
     * @return last name in the AddressBookEntry
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Function to get the Street address in the AddressEntry Object.
     *
     * @return street address in the AddressBookEntry
     */
    public String getStreet() {
        return street;
    }

    /**
     * Function to get the City in the AddressBookEntry Object.
     *
     * @return city in the AddressBookEntry
     */
    public String getCity() {
        return city;
    }

    /**
     * Function to get the State in the AddressBookEntry Object.
     *
     * @return state in the AddressBookEntry
     */
    public String getState() {
        return state;
    }

    /**
     * Function to get the ZipCode in the AddressBookEntry Object.
     *
     * @return zip code in the AddressBookEntry
     */
    public Integer getZip() {
        return zip;
    }

    /**
     * FUnction to get teh Telephone in the AddressBookEntry Object.
     *
     * @return telephone in the AddressBookEntry
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * Function to get the Email in the AddressBookEntry Object.
     *
     * @return email in the AddressBookEntry
     */
    public String getEmail() {
        return email;
    }
}