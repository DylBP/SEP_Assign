import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Objects;
import java.util.regex.Pattern;

public class Utilities {

    public static boolean patternMatches(UserAccount userAccount) {
        String regexPattern = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return Pattern.compile(regexPattern)
                .matcher(userAccount.getEmail())
                .matches();
    }

    public static boolean validateAdminLogin(UserAccount userAccount) {
        String adminUsername = "cm9vdHVzZXI=";
        String adminPassword = "cm9vdHBhc3N3b3JkMTIz";

        String encodedUsername = Base64.getEncoder().encodeToString(userAccount.getUsername().getBytes(StandardCharsets.UTF_8));
        String encodedPassword = Base64.getEncoder().encodeToString(userAccount.getPassword().getBytes(StandardCharsets.UTF_8));

        return (Objects.equals(encodedUsername, adminUsername)) && (Objects.equals(encodedPassword, adminPassword));
    }
}
