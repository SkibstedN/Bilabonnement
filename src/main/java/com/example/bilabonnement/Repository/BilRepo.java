package com.example.bilabonnement.Repository;

import com.example.bilabonnement.Model.Bil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BilRepo {

    @Autowired
    JdbcTemplate dbConnection;

    public void opretBil(Bil bil){
    String sqlOpret ="INSERT INTO biler (stelnummer, vognnummer, mærke, model, brændstoftype, " +
            "udstyrsniveau, odometer, hestekræfter, stålpris, co2udledning, kmprliter, registreringsafgift)" +
            "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
    dbConnection.update(sqlOpret,bil.getStelnummer(),bil.getVognnummer(),bil.getMærke(),bil.getModel(),
            bil.getBrændstoftype(),bil.getUdstyrsniveau(),bil.getOdometer(),bil.getHestekræfter(),bil.getStålpris(),
            bil.getCo2udledning(),bil.getKmprliter(),bil.getRegistreringsafgift());
    }


}
