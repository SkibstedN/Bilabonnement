package com.example.bilabonnement.Repository;

import com.example.bilabonnement.Model.Abonnement;
import com.example.bilabonnement.Model.Bil;
import com.example.bilabonnement.Model.Kunde;
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
            "udstyrsniveau, odometer, hestekraefter, staalpris, co2udledning, kmprliter, registreringsafgift, bilstatus) " +
            "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
    dbConnection.update(sqlOpret,bil.getVognnummer(),bil.getStelnummer(),bil.getMaerke(),bil.getModel(),
            bil.getBraendstoftype(),bil.getUdstyrsniveau(),bil.getOdometer(),bil.getHestekraefter(),bil.getStaalpris(),
            bil.getCo2udledning(),bil.getKmprliter(),bil.getRegistreringsafgift(),bil.getBilstatus());
    }

    public List<Bil> seBilListe(){
        String sqlSeBil = "SELECT vognnummer, stelnummer, maerke, model, braendstoftype," +
                "udstyrsniveau, odometer, hestekraefter, staalpris, co2udledning, kmprliter, registreringsafgift, bilstatus " +
                "FROM biler ";
        RowMapper<Bil> bilListe = new BeanPropertyRowMapper<>(Bil.class);
        return dbConnection.query(sqlSeBil, bilListe);
    }
    public Bil findBil(int vognnummer){
        String sqlFindbil="SELECT vognnummer, stelnummer, maerke, model, braendstoftype," +
                " udstyrsniveau, odometer, hestekraefter, staalpris, co2udledning, kmprliter, registreringsafgift, bilstatus " +
                " FROM biler WHERE vognnummer = ?";
        RowMapper <Bil> fundetBil = new BeanPropertyRowMapper<>(Bil.class);
        Bil bil= dbConnection.queryForObject(sqlFindbil,fundetBil,vognnummer);
        return bil;
    }
    public void opdaterBil(Bil bil){
        String sqlOpdaterBil= "UPDATE biler SET stelnummer = ?, maerke = ?, model = ?, " +
                "braendstoftype = ?, udstyrsniveau = ?, odometer = ?, hestekraefter = ?, staalpris = ?, " +
                "co2udledning = ?, kmprliter = ?, registreringsafgift = ? ,bilstatus = ? " +
                "WHERE vognnummer = ? ";
        dbConnection.update(sqlOpdaterBil,bil.getStelnummer(),bil.getMaerke(),bil.getModel(),
                bil.getBraendstoftype(), bil.getUdstyrsniveau(), bil.getOdometer(), bil.getHestekraefter(),
                bil.getStaalpris(), bil.getCo2udledning(), bil.getKmprliter(), bil.getRegistreringsafgift(),
                bil.getBilstatus(), bil.getVognnummer());
    }
    public Boolean sletBil(int vognnummer){
        String sqlSlet ="DELETE FROM biler WHERE vognnummer = ?";
        return dbConnection.update(sqlSlet,vognnummer)>0;

    }

    public void opretAbonnement(Abonnement abonnement){
        String sqlOpretAbonnement ="INSERT INTO abonnement ( abonnementnummer," +
                " FK_vognnummer, startdato," +
                " slutdato, prisprmaaned, maxkm, FK_kundenummer)" +
                "VALUES (?,?,?,?,?,?,?)";
        dbConnection.update(sqlOpretAbonnement,abonnement.getAbonnementnummer(),
                abonnement.getFK_vognnummer(),abonnement.getStartdato(),
                abonnement.getSlutdato(),abonnement.getPrisprmaaned(),abonnement.getMaxkm()
                ,abonnement.getKundenummer());
    }
    public void opdaterOprettelseAbonnement(Abonnement abonnement){
        String sqlVognnummertilføj="UPDATE abonnement SET FK_vognnummer = ? WHERE abonnementnummer = ?";
        dbConnection.update(sqlVognnummertilføj,abonnement.getFK_vognnummer(),abonnement.getAbonnementnummer());
    }
    public List<Abonnement> seAbonnementListe(){
        String sqlSeAbonnement = "SELECT abonnementnummer, FK_vognnummer, startdato," +
                " slutdato, prisprmaaned, maxkm, FK_kundenummer as kundenummer " +
                "FROM abonnement ";
        RowMapper<Abonnement> abonnementListe = new BeanPropertyRowMapper<>(Abonnement.class);
        return dbConnection.query(sqlSeAbonnement, abonnementListe);
    }
    public Abonnement findAbonnement(int abonnementnummer){
        String sqlFindbil="SELECT abonnementnummer, FK_vognnummer, startdato," +
                " slutdato, prisprmaaned, maxkm, FK_kundenummer as kundenummer "+
                " FROM abonnement WHERE abonnementnummer = ?";
        RowMapper <Abonnement> fundetAbonnement = new BeanPropertyRowMapper<>(Abonnement.class);
        Abonnement abonnement= dbConnection.queryForObject(sqlFindbil,fundetAbonnement,abonnementnummer);
        return abonnement;
    }
    public void opdaterAbonnement(Abonnement abonnement){
        String sqlOpdaterAbonnement ="UPDATE abonnement SET FK_vognnummer = ?, startdato = ?, slutdato = ?," +
                "prisprmaaned = ?, maxkm = ?, FK_kundenummer = ? WHERE abonnementnummer = ?";
        dbConnection.update(sqlOpdaterAbonnement,abonnement.getFK_vognnummer(),abonnement.getStartdato(),
                abonnement.getSlutdato(),abonnement.getPrisprmaaned(),abonnement.getMaxkm(),abonnement.getKundenummer(),
                abonnement.getAbonnementnummer());
    }

    public List<Abonnement> sortByAbonnementnummer(){
        String sqlSorter = "SELECT abonnementnummer, FK_vognnummer, startdato," +
                " slutdato, prisprmaaned, maxkm, FK_kundenummer as kundenummer " +
                "FROM abonnement ORDER BY abonnementnummer";
        RowMapper<Abonnement> abonnementListe = new BeanPropertyRowMapper<>(Abonnement.class);
        return dbConnection.query(sqlSorter, abonnementListe);
    }
    public List<Abonnement> sortByFK_Vognnummer(){
        String sqlSorter = "SELECT abonnementnummer, FK_vognnummer, startdato," +
                " slutdato, prisprmaaned, maxkm, FK_kundenummer as kundenummer " +
                "FROM abonnement ORDER BY FK_vognnummer";
        RowMapper<Abonnement> abonnementListe = new BeanPropertyRowMapper<>(Abonnement.class);
        return dbConnection.query(sqlSorter, abonnementListe);
    }
    public List<Abonnement> sortByKundenummer(){
        String sqlSorter = "SELECT abonnementnummer, FK_vognnummer, startdato," +
                " slutdato, prisprmaaned, maxkm, FK_kundenummer as kundenummer " +
                "FROM abonnement ORDER BY FK_kundenummer";
        RowMapper<Abonnement> abonnementListe = new BeanPropertyRowMapper<>(Abonnement.class);
        return dbConnection.query(sqlSorter, abonnementListe);
    }

    public List<Abonnement> sortByMånedspris(){
        String sqlSorter = "SELECT abonnementnummer, FK_vognnummer, startdato," +
                " slutdato, prisprmaaned, maxkm, FK_kundenummer as kundenummer " +
                "FROM abonnement ORDER BY prisprmaaned";
        RowMapper<Abonnement> abonnementListe = new BeanPropertyRowMapper<>(Abonnement.class);
        return dbConnection.query(sqlSorter, abonnementListe);
    }

    public List<Abonnement> sortBySlutdato(){
        String sqlSorter = "SELECT abonnementnummer, FK_vognnummer, startdato, slutdato," +
                "prisprmaaned, maxkm, FK_kundenummer as kundenummer " +
                "FROM abonnement ORDER BY slutdato";
        RowMapper<Abonnement> abonnementListe = new BeanPropertyRowMapper<>(Abonnement.class);
        return dbConnection.query(sqlSorter, abonnementListe);
    }

    public List<Abonnement> sortByStartdato(){
        String sqlSorter = "SELECT abonnementnummer, FK_vognnummer, startdato, slutdato," +
                "prisprmaaned, maxkm, FK_kundenummer as kundenummer " +
                "FROM abonnement ORDER BY startdato";
        RowMapper<Abonnement> abonnementListe = new BeanPropertyRowMapper<>(Abonnement.class);
        return dbConnection.query(sqlSorter, abonnementListe);
    }
    public List<Abonnement> sortByMaxkm(){
        String sqlSorter = "SELECT abonnementnummer, FK_vognnummer, startdato," +
                " slutdato, prisprmaaned, maxkm, FK_kundenummer as kundenummer " +
                "FROM abonnement ORDER BY maxkm";
        RowMapper<Abonnement> abonnementListe = new BeanPropertyRowMapper<>(Abonnement.class);
        return dbConnection.query(sqlSorter, abonnementListe);
    }

    public Boolean sletAbonnement(int abonnementnummer){
        String sqlSletAbonnement ="DELETE FROM abonnement WHERE abonnementnummer = ?";
        return dbConnection.update(sqlSletAbonnement,abonnementnummer)>0;

    }
    public List<Bil> sortByVognnummer(){
        String sqlSorter = "SELECT vognnummer, stelnummer, maerke, model, braendstoftype," +
                " udstyrsniveau, odometer, hestekraefter, staalpris, co2udledning, kmprliter, registreringsafgift, bilstatus " +
                "FROM biler ORDER BY vognnummer";//Denne string er et sql statement der vil sortere bilerne i tabellen efter deres vognnummer
        RowMapper<Bil> bilListe = new BeanPropertyRowMapper<>(Bil.class);// Her bliver lavet en liste af objekter ud fra rækken i tabelen. Det er tomme bil objekter der bliver lavet da den kalder bil klassen.
        return dbConnection.query(sqlSorter, bilListe);//Her bliver jdbcTemplate brugt til at få forbindelse og sende sql statementet for at få dataen tilbage og fylder de tomme objeter i listen og returnere den nu fyldte liste.
    }
    public List<Bil> sortByStelnummer(){
        String sqlSorter = "SELECT vognnummer, stelnummer, maerke, model, braendstoftype," +
                " udstyrsniveau, odometer, hestekraefter, staalpris, co2udledning, kmprliter, registreringsafgift, bilstatus " +
                "FROM biler ORDER BY stelnummer";
        RowMapper<Bil> bilListe = new BeanPropertyRowMapper<>(Bil.class);
        return dbConnection.query(sqlSorter, bilListe);
    }
    public List<Bil> sortByMærke(){
        String sqlSorter = "SELECT vognnummer, stelnummer, maerke, model, braendstoftype," +
                " udstyrsniveau, odometer, hestekraefter, staalpris, co2udledning, kmprliter, registreringsafgift, bilstatus " +
                "FROM biler ORDER BY maerke";
        RowMapper<Bil> bilListe = new BeanPropertyRowMapper<>(Bil.class);
        return dbConnection.query(sqlSorter, bilListe);
    }
    public List<Bil> sortByModel(){
        String sqlSorter = "SELECT vognnummer, stelnummer, maerke, model, braendstoftype," +
                " udstyrsniveau, odometer, hestekraefter, staalpris, co2udledning, kmprliter, registreringsafgift, bilstatus " +
                "FROM biler ORDER BY model";
        RowMapper<Bil> bilListe = new BeanPropertyRowMapper<>(Bil.class);
        return dbConnection.query(sqlSorter, bilListe);
    }

    public List<Bil> sortByBrændstoftype(){
        String sqlSorter = "SELECT vognnummer, stelnummer, maerke, model, braendstoftype," +
                " udstyrsniveau, odometer, hestekraefter, staalpris, co2udledning, kmprliter, registreringsafgift, bilstatus " +
                "FROM biler ORDER BY braendstoftype";
        RowMapper<Bil> bilListe = new BeanPropertyRowMapper<>(Bil.class);
        return dbConnection.query(sqlSorter, bilListe);
    }

    public List<Bil> sortByUdstyrsniveau(){
        String sqlSorter = "SELECT vognnummer, stelnummer, maerke, model, braendstoftype," +
                " udstyrsniveau, odometer, hestekraefter, staalpris, co2udledning, kmprliter, registreringsafgift, bilstatus " +
                "FROM biler ORDER BY udstyrsniveau";
        RowMapper<Bil> bilListe = new BeanPropertyRowMapper<>(Bil.class);
        return dbConnection.query(sqlSorter, bilListe);
    }

    public List<Bil> sortByOdometer(){
        String sqlSorter = "SELECT vognnummer, stelnummer, maerke, model, braendstoftype," +
                " udstyrsniveau, odometer, hestekraefter, staalpris, co2udledning, kmprliter, registreringsafgift, bilstatus " +
                "FROM biler ORDER BY odometer";
        RowMapper<Bil> bilListe = new BeanPropertyRowMapper<>(Bil.class);
        return dbConnection.query(sqlSorter, bilListe);
    }

    public List<Bil> sortByHestekræfter(){
        String sqlSorter = "SELECT vognnummer, stelnummer, maerke, model, braendstoftype," +
                " udstyrsniveau, odometer, hestekraefter, staalpris, co2udledning, kmprliter, registreringsafgift, bilstatus " +
                "FROM biler ORDER BY hestekraefter";
        RowMapper<Bil> bilListe = new BeanPropertyRowMapper<>(Bil.class);
        return dbConnection.query(sqlSorter, bilListe);
    }
    public List<Bil> sortByStålpris(){
        String sqlSorter = "SELECT vognnummer, stelnummer, maerke, model, braendstoftype," +
                " udstyrsniveau, odometer, hestekraefter, staalpris, co2udledning, kmprliter, registreringsafgift, bilstatus " +
                "FROM biler ORDER BY staalpris";
        RowMapper<Bil> bilListe = new BeanPropertyRowMapper<>(Bil.class);
        return dbConnection.query(sqlSorter, bilListe);
    }
    public List<Bil> sortByCo2udledning(){
        String sqlSorter = "SELECT vognnummer, stelnummer, maerke, model, braendstoftype," +
                " udstyrsniveau, odometer, hestekraefter, staalpris, co2udledning, kmprliter, registreringsafgift, bilstatus " +
                "FROM biler ORDER BY co2udledning";
        RowMapper<Bil> bilListe = new BeanPropertyRowMapper<>(Bil.class);
        return dbConnection.query(sqlSorter, bilListe);
    }
    public List<Bil> sortByKMperliter(){
        String sqlSorter = "SELECT vognnummer, stelnummer, maerke, model, braendstoftype," +
                " udstyrsniveau, odometer, hestekraefter, staalpris, co2udledning, kmprliter, registreringsafgift, bilstatus " +
                "FROM biler ORDER BY kmprliter";
        RowMapper<Bil> bilListe = new BeanPropertyRowMapper<>(Bil.class);
        return dbConnection.query(sqlSorter, bilListe);
    }
    public List<Bil> sortByRegistreringsafgift(){
        String sqlSorter = "SELECT vognnummer, stelnummer, maerke, model, braendstoftype," +
                " udstyrsniveau, odometer, hestekraefter, staalpris, co2udledning, kmprliter, registreringsafgift, bilstatus " +
                "FROM biler ORDER BY registreringsafgift";
        RowMapper<Bil> bilListe = new BeanPropertyRowMapper<>(Bil.class);
        return dbConnection.query(sqlSorter, bilListe);
    }

    public List<Bil> visTilgængeligeBiler() {
        String sqlBilstatus = "SELECT vognnummer, stelnummer, maerke, model, braendstoftype," +
                " udstyrsniveau, odometer, hestekraefter, staalpris, co2udledning, kmprliter," +
                " registreringsafgift, bilstatus " +
                "FROM biler WHERE bilstatus = 'tilgængelig'";
        RowMapper<Bil> bilListe = new BeanPropertyRowMapper<>(Bil.class);
        return dbConnection.query(sqlBilstatus, bilListe);
    }

    public List<Kunde> seKundeListe(){
        String sqlSeKunder = "SELECT kundenummer, fornavn, efternavn, tlfnummer, adresse," +
                "email " +
                "FROM kunder ";
        RowMapper<Kunde> kundeListe = new BeanPropertyRowMapper<>(Kunde.class);
        return dbConnection.query(sqlSeKunder, kundeListe);
    }
    public void opretKunde(Kunde kunde){
        String sqlOpretKunde ="INSERT INTO kunder ( kundenummer, fornavn, efternavn," +
                " tlfnummer, adresse, email)" +
                "VALUES (?,?,?,?,?,?)";
        dbConnection.update(sqlOpretKunde,kunde.getKundenummer(),kunde.getFornavn(),
                kunde.getEfternavn(), kunde.getTlfnummer(),kunde.getAdresse(),kunde.getEmail());
    }
    public Kunde findKunde(int kundenummer){
        String sqlFindKunde="SELECT kundenummer, fornavn, efternavn, tlfnummer, adresse," +
                " email " +
                " FROM kunder WHERE kundenummer = ?";
        RowMapper <Kunde> fundetKunde = new BeanPropertyRowMapper<>(Kunde.class);
        Kunde kunde= dbConnection.queryForObject(sqlFindKunde,fundetKunde,kundenummer);
        return kunde;
    }
    public void opdaterKunde(Kunde kunde){
        String sqlOpdaterKunde= "UPDATE kunder SET fornavn = ?, efternavn = ?, " +
                "tlfnummer = ?, adresse = ?, email = ? " +
                "WHERE kundenummer = ? ";
        dbConnection.update(sqlOpdaterKunde,kunde.getFornavn(),kunde.getEfternavn()
        ,kunde.getTlfnummer(),kunde.getAdresse(),kunde.getEmail(),kunde.getKundenummer());
    }
    public Boolean sletKunde(int kundenummer){
        String sqlSletKunde ="DELETE FROM kunder WHERE kundenummer = ?";
        return dbConnection.update(sqlSletKunde,kundenummer)>0;

    }
    public void opdaterStatus(int vognnummer){
        String sqlOpdater ="UPDATE biler SET bilstatus = 'optaget' WHERE vognnummer = ?";
        dbConnection.update(sqlOpdater,vognnummer);
    }

}
