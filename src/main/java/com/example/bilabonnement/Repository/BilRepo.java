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
    String sqlOpret ="INSERT INTO biler (vognnummer,stelnummer, maerke, model, braendstoftype, " +
            "udstyrsniveau, odometer, hestekraefter, staalpris, co2udledning, kmprliter, registreringsafgift)" +
            "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
    dbConnection.update(sqlOpret,bil.getVognnummer(),bil.getStelnummer(),bil.getMaerke(),bil.getModel(),
            bil.getBraendstoftype(),bil.getUdstyrsniveau(),bil.getOdometer(),bil.getHestekraefter(),bil.getStaalpris(),
            bil.getCo2udledning(),bil.getKmprliter(),bil.getRegistreringsafgift());
    }

    public List<Bil> seBilListe(){
        String sqlSeBil = "SELECT vognnummer, stelnummer, maerke, model, braendstoftype," +
                "udstyrsniveau, odometer, hestekraefter, staalpris, co2udledning, kmprliter, registreringsafgift " +
                "FROM biler ";
        RowMapper<Bil> bilListe = new BeanPropertyRowMapper<>(Bil.class);
        return dbConnection.query(sqlSeBil, bilListe);
    }
    public Bil findBil(int vognnummer){
        String sqlFindbil="SELECT vognnummer, stelnummer, maerke, model, braendstoftype," +
                " udstyrsniveau, odometer, hestekraefter, staalpris, co2udledning, kmprliter, registreringsafgift " +
                " FROM biler WHERE vognnummer = ?";
        RowMapper <Bil> fundetBil = new BeanPropertyRowMapper<>(Bil.class);
        Bil bil= dbConnection.queryForObject(sqlFindbil,fundetBil,vognnummer);
        return bil;
    }
    public void opdaterBil(Bil bil){
        String sqlOpdaterBil= "UPDATE biler SET stelnummer = ?, maerke = ?, model = ?, " +
                "braendstoftype = ?, udstyrsniveau = ?, odometer = ?, hestekraefter = ?, staalpris = ?, " +
                "co2udledning = ?, kmprliter = ?, registreringsafgift = ? " +
                "WHERE vognnummer = ? ";
        dbConnection.update(sqlOpdaterBil,bil.getStelnummer(),bil.getMaerke(),bil.getModel(),
                bil.getBraendstoftype(), bil.getUdstyrsniveau(), bil.getOdometer(), bil.getHestekraefter(),
                bil.getStaalpris(), bil.getCo2udledning(), bil.getKmprliter(), bil.getRegistreringsafgift()
                , bil.getVognnummer());
    }
    public Boolean sletBil(int vognnummer){
        String sqlSlet ="DELETE FROM biler WHERE vognnummer = ?";
        return dbConnection.update(sqlSlet,vognnummer)>0;

    }
}
