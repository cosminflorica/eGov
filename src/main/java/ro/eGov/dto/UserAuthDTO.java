package ro.eGov.dto;

public class UserAuthDTO {
    String email;
    String password;

    public UserAuthDTO() {
    }
    public UserAuthDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
