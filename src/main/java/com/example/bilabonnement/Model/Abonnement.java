package com.example.bilabonnement.Model;

public class Abonnement {
    private int abonnementnummer;
    private int FK_vognnummer;
    private String startdato;
    private String slutdato;
    private double prisprmaaned;
    private int maxkm;
    private int FK_kundenummer;

    public Abonnement(){}

    public Abonnement(int abonnementnummer, int FK_vognnummer, String startdato, String slutdato, double prisprmaaned,
                      int maxkm, int FK_kundenummer){
        this.abonnementnummer = abonnementnummer;
        this.FK_vognnummer = FK_vognnummer;
        this.startdato = startdato;
        this.slutdato = slutdato;
        this.prisprmaaned = prisprmaaned;
        this.maxkm = maxkm;
        this.FK_kundenummer = FK_kundenummer;
    }

    public int getAbonnementnummer() {
        return abonnementnummer;
    }

    public void setAbonnementnummer(int abonnementnummer) {
        this.abonnementnummer = abonnementnummer;
    }

    public int getFK_vognnummer() {
        return FK_vognnummer;
    }

    public void setFK_vognnummer(int vognnummer) {
        this.FK_vognnummer = vognnummer;
    }

    public String getStartdato() {
        return startdato;
    }

    public void setStartdato(String startdato) {
        this.startdato = startdato;
    }

    public String getSlutdato() {
        return slutdato;
    }

    public void setSlutdato(String slutdato) {
        this.slutdato = slutdato;
    }

    public double getPrisprmaaned() {
        return prisprmaaned;
    }

    public void setPrisprmaaned(double prisprmaaned) {
        this.prisprmaaned = prisprmaaned;
    }

    public int getMaxkm() {
        return maxkm;
    }

    public void setMaxkm(int maxkm) {
        this.maxkm = maxkm;
    }

    public int getFK_Kundenummer() {
        return FK_kundenummer;
    }

    public void setKundenummer(int kundenummer) {
        this.FK_kundenummer = kundenummer;
    }



}
