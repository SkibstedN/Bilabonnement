package com.example.bilabonnement.Repository;

import com.example.bilabonnement.Model.Bil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BilRepo {

    @Autowired
    JdbcTemplate dbConnection;

    public void opretBil(Bil bil){
    String sqlOpret ="INSERT INTO biler (stelnummer, vognnummer, maerke, model, braendstoftype, " +
            "udstyrsniveau, odometer, hestekraefter, staalpris, co2udledning, kmprliter, registreringsafgift)" +
            "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
    dbConnection.update(sqlOpret,bil.getStelnummer(),bil.getVognnummer(),bil.getMaerke(),bil.getModel(),
            bil.getBraendstoftype(),bil.getUdstyrsniveau(),bil.getOdometer(),bil.getHestekraefter(),bil.getStaalpris(),
            bil.getCo2udledning(),bil.getKmprliter(),bil.getRegistreringsafgift());
    }

    public List<Bil> seBilListe(){
        String sqlSeBil = "SELECT stelnummer, vognnummer, maerke, model, braendstoftype," +
                "udstyrsniveau, odometer, hestekraefter, staalpris, co2udledning, kmprliter, registreringsafgift " +
                "FROM biler ";
        RowMapper<Bil> bilListe = new BeanPropertyRowMapper<>(Bil.class);
        return dbConnection.query(sqlSeBil, bilListe);
    }
}
