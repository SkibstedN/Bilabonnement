package com.example.bilabonnement.Model;

public class Abonnement {
    private int abonnementnummer;
    private int FK_vognnummer;
    private String startdato;
    private String slutdato;
    private double prisprmaaned;
    private int maxkm;
    private int kundenummer;

    public Abonnement(){}

    public Abonnement(int abonnementnummer, int FK_vognnummer, String startdato, String slutdato, double prisprmaaned,
                      int maxkm, int kundenummer){
        this.abonnementnummer = abonnementnummer;
        this.FK_vognnummer = FK_vognnummer;
        this.startdato = startdato;
        this.slutdato = slutdato;
        this.prisprmaaned = prisprmaaned;
        this.maxkm = maxkm;
        this.kundenummer = kundenummer;
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

    public void setFK_vognnummer(int FK_vognnummer) {
        this.FK_vognnummer = FK_vognnummer;
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

    public int getKundenummer() {
        return kundenummer;
    }

    public void setKundenummer(int kundenummer) {
        this.kundenummer = kundenummer;
    }



}
