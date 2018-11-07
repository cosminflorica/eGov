package ro.eGov.dto;

public class UserLogDTO {
    String nume;
    String prenume;
    String email;
    String judet;
    //Integer capacitate;
    String valoare;

    public UserLogDTO(){

    }
    public UserLogDTO(String nume, String prenume, String email, String judet, String valoare) {
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.judet = judet;
        //this.capacitate= capacitate;
        this.valoare = valoare;
    }

    public String getNume() {
        return nume;
    }
    /*public Integer getCapacitate(){
        return capacitate;
    }*/
    public String getPrenume() {
        return prenume;
    }

    public String getEmail() {
        return email;
    }

    public String getJudet() {
        return judet;
    }

    public String getValoare() {
        return valoare;
    }
}
