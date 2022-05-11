package com.example.bilabonnement.Model;

public class Abonnement {
    private int abonnementID;
    private Bil bil;
    private String startDato;
    private String slutDato;
    private double prisPrMaaned;
    private int maxKm;
    private int kundeID;

    public Abonnement(){}

    public Abonnement(int abonnementID, Bil bil, String startDato, String slutDato, double prisPrMaaned,
                      int maxKm, int kundeID){
        this.abonnementID = abonnementID;
        this.bil = bil;
        this.startDato = startDato;
        this.slutDato = slutDato;
        this.prisPrMaaned = prisPrMaaned;
        this.maxKm = maxKm;
        this.kundeID = kundeID;
    }

    public int getAbonnementID() {
        return abonnementID;
    }

    public void setAbonnementID(int abonnementID) {
        this.abonnementID = abonnementID;
    }

    public Bil getBil() {
        return bil;
    }

    public void setBil(Bil bil) {
        this.bil = bil;
    }

    public String getStartDato() {
        return startDato;
    }

    public void setStartDato(String startDato) {
        this.startDato = startDato;
    }

    public String getSlutDato() {
        return slutDato;
    }

    public void setSlutDato(String slutDato) {
        this.slutDato = slutDato;
    }

    public double getPrisPrMaaned() {
        return prisPrMaaned;
    }

    public void setPrisPrMaaned(double prisPrMaaned) {
        this.prisPrMaaned = prisPrMaaned;
    }

    public int getMaxKm() {
        return maxKm;
    }

    public void setMaxKm(int maxKm) {
        this.maxKm = maxKm;
    }

    public int getKundeID() {
        return kundeID;
    }

    public void setKundeID(int kundeID) {
        this.kundeID = kundeID;
    }
}
