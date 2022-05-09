package com.example.bilabonnement.Model;

public class Bil {

    private String stelnummer;
    private int vognnummer;
    private String maerke;
    private String model;
    private String braendstoftype;
    private String udstyrsniveau;
    private int odometer;
    private int hestekraefter;
    private double staalpris;
    private double co2udledning;
    private double kmprliter;
    private double registreringsafgift;

    //Her er en tom constructor som bliver brugt til oprette forbindelsen mellem klasserne
    public Bil(){}

    public Bil(String stelnummer, int vognnummer, String maerke, String model, String braendstoftype,
               String udstyrsniveau, int odometer, int hestekraefter, double staalpris, double co2udledning,
               double kmprliter, double registreringsafgift){
        this.stelnummer = stelnummer;
        this.vognnummer = vognnummer;
        this.maerke = maerke;
        this.model = model;
        this.braendstoftype = braendstoftype;
        this.udstyrsniveau = udstyrsniveau;
        this.odometer = odometer;
        this.hestekraefter = hestekraefter;
        this.staalpris = staalpris;
        this.co2udledning = co2udledning;
        this.kmprliter = kmprliter;
        this.registreringsafgift = registreringsafgift;
    }
    public String getStelnummer() {
        return stelnummer;
    }

    public void setStelnummer(String stelnummer) {
        this.stelnummer = stelnummer;
    }

    public int getVognnummer() {
        return vognnummer;
    }

    public void setVognnummer(int vognnummer) {
        this.vognnummer = vognnummer;
    }

    public String getMaerke() {
        return maerke;
    }

    public void setMaerke(String maerke) {
        this.maerke = maerke;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBraendstoftype() {
        return braendstoftype;
    }

    public void setBraendstoftype(String braendstoftype) {
        this.braendstoftype = braendstoftype;
    }

    public String getUdstyrsniveau() {
        return udstyrsniveau;
    }

    public void setUdstyrsniveau(String udstyrsniveau) {
        this.udstyrsniveau = udstyrsniveau;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    public int getHestekraefter() {
        return hestekraefter;
    }

    public void setHestekraefter(int hestekraefter) {
        this.hestekraefter = hestekraefter;
    }

    public double getStaalpris() {
        return staalpris;
    }

    public void setStaalpris(double staalpris) {
        this.staalpris = staalpris;
    }

    public double getCo2udledning() {
        return co2udledning;
    }

    public void setCo2udledning(double co2udledning) {
        this.co2udledning = co2udledning;
    }

    public double getKmprliter() {
        return kmprliter;
    }

    public void setKmprliter(double kmprliter) {
        this.kmprliter = kmprliter;
    }

    public double getRegistreringsafgift() {
        return registreringsafgift;
    }

    public void setRegistreringsafgift(double registreringsafgift) {
        this.registreringsafgift = registreringsafgift;
    }
}

