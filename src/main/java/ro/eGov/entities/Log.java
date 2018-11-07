package ro.eGov.entities;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="logs", schema = "public")
public class Log {
    @Id
    @Column(name="id")
    Long id;

    @Column(name="nume")
    String nume;

    @Column(name="prenume")
    String prenume;

    @Column(name="email")
    String email;

    @Column(name="judet")
    String judet;

    @Column(name="valoare")
    Long valoare;

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

    public String getJudet() {
        return judet;
    }

    public void setJudet(String judet) {
        this.judet = judet;
    }

    public Long getValoare() {
        return valoare;
    }

    public void setValoare(Long valoare) {
        this.valoare = valoare;
    }
    public Log(){}
    public Log(Long id, String nume, String prenume, String email, String judet, Long valoare) {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.judet = judet;
        this.valoare = valoare;
    }
}
