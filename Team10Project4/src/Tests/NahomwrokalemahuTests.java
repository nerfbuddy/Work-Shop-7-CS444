package Project4.Tests;

import org.junit.jupiter.api.*;
import Project4.MemberDatabase;
import Project4.ProviderTerminal;
import Project4.aTerminal;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Integration tests for the Project4 system, ensuring critical functionalities.
 * 
 * @author Nahom Workalemahu
 */
class NahomwrokalemahuTests {

    // Stream to hold system output for validation.
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    // Original System.out to restore after tests.
    private final PrintStream originalOut = System.out;

    // Setting up the custom system output stream before each test.
    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    // Resetting System.out after each test to maintain console output integrity.
    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }

    // Verifying the display output of the provider directory against expected content.
    @Test
    void testProviderTerminalDisplay() {
        // Triggering the display function to capture its output.
        ProviderTerminal.displayProviderDirectory();
        // Defining the expected provider directory format and content.
        String expectedOutput = "<Provider Directory:\n"+
                                "Service Name:                           Service Code:                     Fee:\n" +
        	                  	"Wellness services                       8470                             $60\n" +
        		                "Massage Services                        6745                             $100\n"+
                                "Therapy Services                        3642                             $90\n";
                                
      
        	
        // Asserting that the actual output matches what I anticipate.
        assertEquals(expectedOutput, outContent.toString(), "The displayed provider directory should be formatted correctly and include all services.");
    }

    
    // Confirming that MemberDatabase initialization doesn't throw any unexpected errors.
    @Test
    void testMemberDatabaseInitialization_Success() {
        // Asserting the construction of a new MemberDatabase object is error-free.
        assertDoesNotThrow(() -> new MemberDatabase(), "Initializing MemberDatabase should be seamless and throw no exceptions.");
    }

    // Testing the input validation logic of aTerminal by supplying an invalid input.
    @Test
    void testaTerminalInputHandling_Failure() {
        // Preparing an invalid input to simulate user entry.
        String invalidInput = "5"; // This input is outside the valid range, so I expect the system to handle it accordingly.
        ByteArrayInputStream inContent = new ByteArrayInputStream(invalidInput.getBytes());
        System.setIn(inContent); // Injecting the simulated invalid input into the system.

        // Anticipating a NumberFormatException to be thrown due to the invalid input.
        assertThrows(NumberFormatException.class, () -> aTerminal.main(null), "An invalid input should trigger a NumberFormatException.");
    }
}
