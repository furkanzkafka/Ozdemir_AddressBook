package address.tests;

import address.data.AddressBookEntry;

import static org.junit.Assert.*;

public class AddressBookEntryTest {

    @org.junit.Test
    public void getFirstName() {
        AddressBookEntry instance = createRandomEntry();
        String expected = instance.getFirstName();
        String actual = instance.getFirstName();
        assertEquals(expected, actual);
    }

    @org.junit.Test
    public void getLastName() {
        AddressBookEntry instance = createRandomEntry();
        String expected = instance.getLastName();
        String actual = instance.getLastName();
        assertEquals(expected, actual);
    }

    @org.junit.Test
    public void getStreet() {
        AddressBookEntry instance = createRandomEntry();
        String expected = instance.getStreet();
        String actual = instance.getStreet();
        assertEquals(expected, actual);
    }

    @org.junit.Test
    public void getCity() {
        AddressBookEntry instance = createRandomEntry();
        String expected = instance.getCity();
        String actual = instance.getCity();
        assertEquals(expected, actual);
    }

    @org.junit.Test
    public void getState() {
        AddressBookEntry instance = createRandomEntry();
        String expected = instance.getState();
        String actual = instance.getState();
        assertEquals(expected, actual);
    }

    @org.junit.Test
    public void getZip() {
        AddressBookEntry instance = createRandomEntry();
        int expected = instance.getZip();
        int actual = instance.getZip();
        assertEquals(expected, actual);
    }

    @org.junit.Test
    public void getTelephone() {
        AddressBookEntry instance = createRandomEntry();
        String expected = instance.getTelephone();
        String actual = instance.getTelephone();
        assertEquals(expected, actual);
    }

    @org.junit.Test
    public void getEmail() {
        AddressBookEntry instance = createRandomEntry();
        String expected = instance.getEmail();
        String actual = instance.getEmail();
        assertEquals(expected, actual);
    }

    // Method to create a random AddressBookEntry for testing
    private AddressBookEntry createRandomEntry() {
        return new AddressBookEntry(
                getRandomString(),
                getRandomString(),
                getRandomString(),
                getRandomString(),
                getRandomString(),
                getRandomZip(),
                getRandomString(),
                getRandomEmail()
        );
    }

    // Method to generate a random string
    private String getRandomString() {
        return Long.toHexString(Double.doubleToLongBits(Math.random()));
    }

    // Method to generate a random zip code
    private int getRandomZip() {
        return (int) (Math.random() * 90000) + 10000; // Generating a 5-digit random number
    }

    // Method to generate a random email
    private String getRandomEmail() {
        return getRandomString() + "@example.com";
    }
}
