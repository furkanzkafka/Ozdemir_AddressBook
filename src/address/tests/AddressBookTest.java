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

        AddressBookEntry one = new AddressBookEntry("Dhruvin", "Patel", "2175 Aborn Rd",
                "San Jose", "CA", 95121, "408-456-9987", "dhruvinp94@gmail.com");

        AddressBookEntry two = new AddressBookEntry("Shivam", "Pandya", "3300 Snell Ave",
                "San Jose", "CA", 95123, "408-456-9899", "Shivam@gmail.com");

        instance.add(one);
        instance.add(two);

        List<AddressBookEntry> entries = instance.find("P");

        assertEquals(2, entries.size());
        assertEquals(one, entries.get(0));
        assertEquals(two, entries.get(1));

        instance.remove("Patel");

        entries = instance.find("P");

        assertEquals(1, entries.size());
        assertEquals(two, entries.get(0));

    }

    @Test
    public void add() {
        AddressBook instance = new AddressBook();

        List<AddressBookEntry> entries = instance.find("P");
        assertEquals(0, entries.size());

        AddressBookEntry one = new AddressBookEntry("Dhruvin", "Patel", "2175 Aborn Rd",
                "San Jose", "CA", 95121, "408-456-9987", "dhruvinp94@gmail.com");

        AddressBookEntry two = new AddressBookEntry("Shivam", "Pandya", "3300 Snell Ave",
                "San Jose", "CA", 95123, "408-456-9899", "Shivam@gmail.com");

        instance.add(one);
        instance.add(two);

        entries = instance.find("P");

        assertEquals(2, entries.size());
        assertEquals(one, entries.get(0));
        assertEquals(two, entries.get(1));
    }

    @Test
    public void find() {
        AddressBook instance = new AddressBook();

        List<AddressBookEntry> entries = instance.find("P");
        assertEquals(0, entries.size());

        AddressBookEntry one = new AddressBookEntry("Dhruvin", "Patel", "2175 Aborn Rd",
                "San Jose", "CA", 95121, "408-456-9987", "dhruvinp94@gmail.com");

        AddressBookEntry two = new AddressBookEntry("Shivam", "Pandya", "3300 Snell Ave",
                "San Jose", "CA", 95123, "408-456-9899", "Shivam@gmail.com");

        instance.add(one);
        instance.add(two);

        entries = instance.find("P");

        assertEquals(2, entries.size());
        assertEquals(one, entries.get(0));
        assertEquals(two, entries.get(1));

        entries = instance.find("Nothing");
        assertEquals(0, entries.size());

    }
}