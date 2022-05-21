package com.example.bilabonnement.Model;

public class Kunde {
    private int kundenummer;
    private String fornavn;
    private String efternavn;
    private int tlfnummer;
    private String adresse;
    private String email;

    public Kunde(){}
    public Kunde(int kundenummer, String fornavn, String efternavn, int tlfnummer, String adresse, String email) {
        this.kundenummer = kundenummer;
        this.fornavn = fornavn;
        this.efternavn = efternavn;
        this.tlfnummer = tlfnummer;
        this.adresse = adresse;
        this.email = email;
    }

    public int getKundenummer() {
        return kundenummer;
    }

    public void setKundenummer(int kundenummer) {
        this.kundenummer = kundenummer;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEfternavn() {
        return efternavn;
    }

    public void setEfternavn(String efternavn) {
        this.efternavn = efternavn;
    }

    public int getTlfnummer() {
        return tlfnummer;
    }

    public void setTlfnummer(int tlfnummer) {
        this.tlfnummer = tlfnummer;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
