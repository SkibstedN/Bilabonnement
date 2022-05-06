package com.example.bilabonnement.Model;

public class Bil {

    private String stelnummer;
    private int vognnummer;
    private String mærke;
    private String model;
    private String brændstoftype;
    private String udstyrsniveau;
    private int odometer;
    private int hestekræfter;
    private double stålpris;
    private double co2udledning;
    private double kmprliter;
    private double registreringsafgift;

    //Her er en tom constructor som bliver brugt til oprette forbindelsen mellem klasserne
    public Bil(){}

    public Bil(String stelnummer, int vognnummer, String mærke, String model, String brændstoftype,
               String udstyrsniveau, int odometer, int hestekræfter, double stålpris, double co2udledning,
               double kmprliter, double registreringsafgift){
        this.stelnummer = stelnummer;
        this.vognnummer = vognnummer;
        this.mærke = mærke;
        this.model = model;
        this.brændstoftype = brændstoftype;
        this.udstyrsniveau = udstyrsniveau;
        this.odometer = odometer;
        this.hestekræfter = hestekræfter;
        this.stålpris = stålpris;
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

    public String getMærke() {
        return mærke;
    }

    public void setMærke(String mærke) {
        this.mærke = mærke;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrændstoftype() {
        return brændstoftype;
    }

    public void setBrændstoftype(String brændstoftype) {
        this.brændstoftype = brændstoftype;
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

    public int getHestekræfter() {
        return hestekræfter;
    }

    public void setHestekræfter(int hestekræfter) {
        this.hestekræfter = hestekræfter;
    }

    public double getStålpris() {
        return stålpris;
    }

    public void setStålpris(double stålpris) {
        this.stålpris = stålpris;
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

