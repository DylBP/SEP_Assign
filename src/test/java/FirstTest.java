import org.junit.Test;

import static org.junit.Assert.*;


public class FirstTest {
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

    @Test
    public void testEmailValidation() {
        String regexPattern;

        regexPattern = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        assertTrue(EmailValidation.patternMatches(anotherGoodEmailAddress, regexPattern));
        assertTrue(EmailValidation.patternMatches(goodEmailAddress, regexPattern));
        assertFalse(EmailValidation.patternMatches(badEmailAddress, regexPattern));
        assertFalse(EmailValidation.patternMatches(emptyEmailAddress, regexPattern));
        assertFalse(EmailValidation.patternMatches(evilEmailAddress, regexPattern));
    }

    @Test
    public void testAdminAuthentication() {
        assertFalse(UserAccount.validateAdminLogin(failedUsername, failedPassword));
        assertFalse(UserAccount.validateAdminLogin(emptyUsername, emptyPassword));
        assertFalse(UserAccount.validateAdminLogin(closeUsername, closePassword));
        assertTrue(UserAccount.validateAdminLogin(correctUsername, correctPassword));
        assertFalse(UserAccount.validateAdminLogin(correctUsername, closePassword));
        assertFalse(UserAccount.validateAdminLogin(closeUsername, correctPassword));
    }
}
