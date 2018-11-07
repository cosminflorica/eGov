package ro.eGov.entities;

import javax.persistence.*;
import java.util.IdentityHashMap;

@Entity
@Table(name = "user", schema = "public")
public class User {
    @Id
    @Column(name="id")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "nume")
    String nume;

    @Column(name="prenume")
    String prenume;

    @Column(name = "email")
    String email;

    @Column(name="password")
    String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public User(){}
    public User(Long id, String nume, String prenume, String email, String password) {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.password = password;
    }
}
