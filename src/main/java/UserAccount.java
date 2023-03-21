import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Objects;

public class UserAccount {
    public static boolean validateAdminLogin(String username, String password) {
        String adminUsername = "cm9vdHVzZXI=";
        String adminPassword = "cm9vdHBhc3N3b3JkMTIz";

        String encodedUsername = Base64.getEncoder().encodeToString(username.getBytes(StandardCharsets.UTF_8));
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes(StandardCharsets.UTF_8));

        return (Objects.equals(encodedUsername, adminUsername)) && (Objects.equals(encodedPassword, adminPassword));
    }
}
