
public class UserAccount {
    private String username = "";
    private String password = "";
    private String email = "";

    public UserAccount(String username, String password, String email) {
        if(username != null) this.username = username;
        if(password != null) this.password = password;
        if(email != null) this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
