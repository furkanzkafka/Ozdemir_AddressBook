package address.tests;

import address.data.Menu;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

/**
 * This test verifies that the output of the displayMenu method matches the expected output.
 */
class MenuTest {

    /**
     * This test method verifies that the displayMenu() method in the Menu class
     * generates the expected menu output when called.
     */
    @Test
    public void testDisplayMenu() {
        // Redirect System.out to capture printed output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Call the displayMenu() method
        Menu.prompt_menu();

        // Restore System.out
        System.setOut(System.out);

        // Define expected lines of output
        List<String> expectedOutputLines = Arrays.asList(
                "*************************",
                "Please enter your menu selection",
                "a) Loading of entries from a file.",
                "b) Addition - prompting user for information to be used to create a new AddressBookEntry",
                "c) Removal - removing of an AddressBookEntry from the AddressBook.",
                "d) Find - prompts users for the beginning of the user's last name.",
                "e) Listing - listing (a 'dump') of the addresses in alphabetic order by the person's last name.",
                "f) Quit",
                "*************************"
        );

        // Get the actual lines of output
        String[] actualOutputLines = outContent.toString().split(System.lineSeparator());

        // Compare actual and expected output lines using assertLinesMatch()
        assertLinesMatch(expectedOutputLines.stream(), Arrays.stream(actualOutputLines));
    }

    /**
     * This test method verifies that the prompt_FirstName() method in the Menu class
     * correctly prompts the user for their first name and returns the input value.
     */
    @Test
    public void testPromptFirstName() {
        String input = "John\n"; //Simulating user input
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String firstName = Menu.prompt_FirstName(); //Method call and storing the return value
        // Assert
        assertEquals("John", firstName);

    }

    /**
     * This test method verifies that the prompt_FirstName() method in the Menu class
     * correctly prompts the user for their first name twice, returning different input values each time.
     */
    @Test
    public void testPromptFirstName2() {
        String input = "John\n"; //Simulating user input
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String firstName = Menu.prompt_FirstName(); //Method call and storing the return value
        // Assert
        assertEquals("John", firstName);

        String input2 = "Alice\n"; //Simulating user input
        InputStream in2 = new ByteArrayInputStream(input2.getBytes());
        System.setIn(in2);

        String firstName2 = Menu.prompt_FirstName(); //Method call and storing the return value
        // Assert
        assertEquals("Alice", firstName2);

    }


    /**
     * This test method verifies that the prompt_LastName() method in the Menu class
     * correctly prompts the user for their last name and returns the input value.
     */
    @Test
    public void testPromptLastName() {
        String input = "Kim\n"; //Simulating user input
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String lastName = Menu.prompt_LastName(); //Method call and storing the return value
        // Assert
        assertEquals("Kim", lastName);
    }

    /**
     * This test method verifies that the prompt_LastName() method in the Menu class
     * correctly prompts the user for their last name twice, returning different input values each time.
     */
    @Test
    public void testPromptLastName2() {
        String input = "Kim\n"; //Simulating user input
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String lastName = Menu.prompt_LastName(); //Method call and storing the return value
        // Assert
        assertEquals("Kim", lastName);

        String input2 = "K\n"; //Simulating user input
        InputStream in2 = new ByteArrayInputStream(input2.getBytes());
        System.setIn(in2);

        String lastName2 = Menu.prompt_LastName(); //Method call and storing the return value
        // Assert
        assertEquals("K", lastName2);
    }


    /**
     * This test method verifies that the prompt_Street() method in the Menu class
     * correctly prompts the user for their street address and returns the input value.
     */
    @Test
    void testpromptStreet() {
        String input = "1231 Fun St.\n"; //Simulating user input
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String street = Menu.prompt_Street(); //Method call and storing the return value
        // Assert
        assertEquals("1231 Fun St.", street);

    }

    /**
     * This test method verifies that the prompt_Street() method in the Menu class
     * correctly prompts the user for their street address twice, returning different input values each time.
     */
    @Test
    void testpromptStreet2() {
        String input = "1231 Fun St.\n"; //Simulating user input
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String street = Menu.prompt_Street(); //Method call and storing the return value
        // Assert
        assertEquals("1231 Fun St.", street);

        String input2 = "1245 St.\n"; //Simulating user input
        InputStream in2 = new ByteArrayInputStream(input2.getBytes());
        System.setIn(in2);

        String street2 = Menu.prompt_Street(); //Method call and storing the return value
        // Assert
        assertEquals("1245 St.", street2);

    }

    /**
     * This test method verifies that the prompt_City() method in the Menu class
     * correctly prompts the user for their city and returns the input value.
     */
    @Test
    void testpromptCity() {
        String input = "Oakland\n"; //Simulating user input
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String city = Menu.prompt_City(); // Method call and storing the return value
        // Assert
        assertEquals("Oakland", city);
    }

    /**
     * This test method verifies that the prompt_City() method in the Menu class
     * correctly prompts the user for their city twice, returning different input values each time.
     */
    @Test
    void testpromptCity2() {
        String input = "Oakland\n"; //Simulating user input
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String city = Menu.prompt_City(); // Method call and storing the return value
        // Assert
        assertEquals("Oakland", city);

        String input2 = "Hayward\n"; //Simulating user input
        InputStream in2 = new ByteArrayInputStream(input2.getBytes());
        System.setIn(in2);

        String city2 = Menu.prompt_City(); // Method call and storing the return value
        // Assert
        assertEquals("Hayward", city2);
    }


    /**
     * This test method verifies that the prompt_State() method in the Menu class
     * correctly prompts the user for their state abbreviation and returns the input value.
     */
    @Test
    void testPromptState() {
        String input = "CA\n"; //Simulating user input
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String state = Menu.prompt_State(); //Method call and storing the return value
        // Assert
        assertEquals("CA", state);
    }


    /**
     * This test method verifies that the prompt_State() method in the Menu class
     * correctly prompts the user for their state abbreviation twice, returning different input values each time.
     */
    @Test
    void testPromptState2() {
        String input = "CA\n"; //Simulating user input
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String state = Menu.prompt_State(); //Method call and storing the return value
        // Assert
        assertEquals("CA", state);

        String input2 = "NY\n"; //Simulating user input
        InputStream in2 = new ByteArrayInputStream(input2.getBytes());
        System.setIn(in2);

        String state2 = Menu.prompt_State(); //Method call and storing the return value
        // Assert
        assertEquals("NY", state2);
    }


    /**
     * This test method verifies that the prompt_Zip() method in the Menu class
     * correctly prompts the user for their zip code and returns the input value.
     */
    @Test
    void testpromptZip() {
        String input = "12345\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Integer zip = Menu.prompt_Zip();
        // Assert
        assertEquals(12345, zip.intValue());
    }


    /**
     * This test method verifies the behavior of the prompt_Zip() method in the Menu class
     * when the user provides invalid input (non-numeric).
     */
    @Test
    public void testpromptZip2() {
        // Arrange
        String input = "abcde";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Act
        try {
            Menu.prompt_Zip();
            fail("Expected a NoSuchElementException to be thrown");
        } catch (NoSuchElementException e) {
            // Assert
            assertEquals("No line found", e.getMessage());
        }
    }

    /**
     * This test method verifies that the prompt_Phone() method in the Menu class
     * correctly prompts the user for their phone number and returns the input value.
     */
    @Test
    void testPromptPhone() {
        String input = "323-234-5623\n"; // Simulating user input
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String phone = Menu.prompt_Phone(); // Method call and storing the return value
        // Assert
        assertEquals("323-234-5623", phone);
    }

    /**
     * This test method verifies that the prompt_Phone() method in the Menu class
     * correctly prompts the user for their phone number twice, returning different input values each time.
     */
    @Test
    void testPromptPhone2() {
        String input = "323-234-5623\n"; // Simulating user input
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String phone = Menu.prompt_Phone(); // Method call and storing the return value
        // Assert
        assertEquals("323-234-5623", phone);

        String input2 = "3232345623\n"; // Simulating user input
        InputStream in2 = new ByteArrayInputStream(input2.getBytes());
        System.setIn(in2);

        String phone2 = Menu.prompt_Phone(); // Method call and storing the return value
        // Assert
        assertEquals("3232345623", phone2);
    }


    /**
     * This test method verifies that the prompt_Phone() method in the Menu class
     * correctly prompts the user for their phone number and returns the input value.
     */
    @Test
    void testPromptEmail() {
        String input = "fun@gmail.com\n"; // Simulating user input
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String email = Menu.prompt_Email(); // Method invocation and storing the return value
        // Assert
        assertEquals("fun@gmail.com", email);
    }


    /**
     * This test method verifies that the prompt_Phone() method in the Menu class
     * correctly prompts the user for their phone number twice, returning different input values each time.
     */
    @Test
    void testPromptEmail2() {
        String input = "foo@gmail.com\n"; // Simulating user input
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String email = Menu.prompt_Email(); // Method invocation and storing the return value
        // Assert
        assertEquals("foo@gmail.com", email);

        String input2 = "f_i@gmail.com\n"; // Simulating user input
        InputStream in2 = new ByteArrayInputStream(input2.getBytes());
        System.setIn(in2);

        String email2 = Menu.prompt_Email(); // Method invocation and storing the return value
        // Assert
        assertEquals("f_i@gmail.com", email2);

    }
}