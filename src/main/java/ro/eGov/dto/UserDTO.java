package ro.eGov.dto;

import ro.eGov.entities.User;

public class UserDTO {
    String nume;
    String prenume;
    String email;

    public UserDTO(String nume, String prenume, String email) {
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public UserDTO(User user) {
        this.email=user.getEmail();
        this.nume=user.getNume();
        this.prenume=user.getPrenume();
    }
}
