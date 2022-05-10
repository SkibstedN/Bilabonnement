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
    public Bil findBil(String stelnummer){
        String sqlFindbil="SELECT stelnummer, vognnummer, maerke, model, braendstoftype," +
                " udstyrsniveau, odometer, hestekraefter, staalpris, co2udledning, kmprliter, registreringsafgift " +
                " FROM biler WHERE stelnummer = ?";
        RowMapper <Bil> fundetBil = new BeanPropertyRowMapper<>(Bil.class);
        Bil bil= dbConnection.queryForObject(sqlFindbil,fundetBil,stelnummer);
        return bil;
    }
    public void opdaterBil(Bil bil){
        String sqlOpdaterBil= "UPDATE biler SET vognnummer = ?, maerke = ?, model = ?, " +
                "braendstoftype = ?, udstyrsniveau = ?, odometer = ?, hestekraefter = ?, staalpris = ?, " +
                "co2udledning = ?, kmprliter = ?, registreringsafgift = ? " +
                "WHERE stelnummer = ? ";
        dbConnection.update(sqlOpdaterBil,bil.getVognnummer(),bil.getMaerke(),bil.getModel(),
                bil.getBraendstoftype(), bil.getUdstyrsniveau(), bil.getOdometer(), bil.getHestekraefter(),
                bil.getStaalpris(), bil.getCo2udledning(), bil.getKmprliter(), bil.getRegistreringsafgift()
                , bil.getStelnummer());
    }
    public Boolean sletBil(String stelnummer){
        String sqlSlet ="DELETE FROM biler WHERE stelnummer = ?";
        return dbConnection.update(sqlSlet,stelnummer)>0;

    }
}
