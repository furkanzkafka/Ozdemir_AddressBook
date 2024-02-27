package address.tests;

import address.data.AddressBook;
import address.data.AddressBookEntry;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AddressBookTest {

    @Test
    public void remove() {
        AddressBook instance = new AddressBook();

        AddressBookEntry one = createRandomEntry();
        AddressBookEntry two = createRandomEntry();

        instance.add(one);
        instance.add(two);

        List<AddressBookEntry> entries = instance.find("P");

        assertEquals(2, entries.size());
        assertTrue(entries.contains(one));
        assertTrue(entries.contains(two));

        instance.remove(one.getLastName());

        entries = instance.find("P");

        assertEquals(1, entries.size());
        assertTrue(entries.contains(two));
    }

    @Test
    public void add() {
        AddressBook instance = new AddressBook();

        List<AddressBookEntry> entries = instance.find("P");
        assertEquals(0, entries.size());

        AddressBookEntry one = createRandomEntry();
        AddressBookEntry two = createRandomEntry();

        instance.add(one);
        instance.add(two);

        entries = instance.find("P");

        assertEquals(2, entries.size());
        assertTrue(entries.contains(one));
        assertTrue(entries.contains(two));
    }

    @Test
    public void find() {
        AddressBook instance = new AddressBook();

        List<AddressBookEntry> entries = instance.find("P");
        assertEquals(0, entries.size());

        AddressBookEntry one = createRandomEntry();
        AddressBookEntry two = createRandomEntry();

        instance.add(one);
        instance.add(two);

        entries = instance.find("P");

        assertEquals(2, entries.size());
        assertTrue(entries.contains(one));
        assertTrue(entries.contains(two));

        entries = instance.find("Nothing");
        assertEquals(0, entries.size());
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
