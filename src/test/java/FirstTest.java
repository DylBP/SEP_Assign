import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FirstTest {
    private UserAccount userAccountEmpty, userAccountFail, userAccountNull, userAccountAdmin, userAccountEvil, userAccountNearBoundary;

    String anotherGoodEmailAddress = "test-email+junit@hotmail.com";
    String goodEmailAddress = "username@domain.com";
    String badEmailAddress = "__email__address__@hot_mail.com";
    String emptyEmailAddress = "";
    String evilEmailAddress = "' OR 1=1;--";

    String failedUsername = "JoeBloggs";
    String correctUsername = "rootuser";
    String emptyUsername = "";
    String closeUsername = "Rootuser";

    String failedPassword = "biglongpassword";
    String correctPassword = "rootpassword123";
    String emptyPassword = "";
    String closePassword = "Rootpassword123";

    @BeforeEach
    void setUp() {
        userAccountFail = new UserAccount(failedUsername, failedPassword, badEmailAddress);
        userAccountAdmin = new UserAccount(correctUsername, correctPassword, goodEmailAddress);
        userAccountNull = new UserAccount(null, null, null);
        userAccountEvil = new UserAccount(correctUsername, failedPassword, evilEmailAddress);
        userAccountEmpty = new UserAccount(emptyUsername, emptyPassword, emptyEmailAddress);
        userAccountNearBoundary = new UserAccount(closeUsername, closePassword, anotherGoodEmailAddress);
    }

    @AfterEach
    void tearDown() {
        userAccountFail = userAccountAdmin = userAccountNull = userAccountEvil = userAccountEmpty = null;
    }

    @Nested
    class GettersAndSetters {

        @Test
        void getUsername() {
            assertTrue(userAccountAdmin.getUsername() == correctUsername);
        }

        @Test
        void getPassword() {
            assertTrue(userAccountAdmin.getPassword() == correctPassword);
        }

        @Test
        void getEmail() {
            assertTrue(userAccountAdmin.getEmail() == goodEmailAddress);
        }

        @Test
        void setUsername() {
            assertTrue(userAccountAdmin.getUsername() == correctUsername);
            userAccountAdmin.setUsername("NewUser");
            assertTrue(userAccountAdmin.getUsername() == "NewUser");
        }

        @Test
        void setPassword() {
            assertTrue(userAccountAdmin.getPassword() == correctPassword);
            userAccountAdmin.setPassword("NewPass");
            assertTrue(userAccountAdmin.getPassword() == "NewPass");
        }

        @Test
        void setEmail() {
            assertTrue(userAccountAdmin.getEmail() == goodEmailAddress);
            userAccountAdmin.setEmail("email@email.com");
            assertTrue(userAccountAdmin.getEmail() == "email@email.com");
        }
    }

    @Test
    public void testEmailValidation() {
        assertTrue(Utilities.patternMatches(userAccountAdmin));
        assertFalse(Utilities.patternMatches(userAccountEmpty));
        assertFalse(Utilities.patternMatches(userAccountEvil));
        assertFalse(Utilities.patternMatches(userAccountFail));
        assertFalse(Utilities.patternMatches(userAccountNull));
        assertTrue(Utilities.patternMatches(userAccountNearBoundary));
    }

    @Test
    public void testAdminAuthentication() {
        assertFalse(Utilities.validateAdminLogin(userAccountFail));
        assertFalse(Utilities.validateAdminLogin(userAccountEvil));
        assertFalse(Utilities.validateAdminLogin(userAccountEmpty));
        assertTrue(Utilities.validateAdminLogin(userAccountAdmin));
        assertFalse(Utilities.validateAdminLogin(userAccountNull));
        assertFalse(Utilities.validateAdminLogin(userAccountNearBoundary));
    }
}
