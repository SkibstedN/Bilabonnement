package com.example.bilabonnement.Service;


import com.example.bilabonnement.Model.Abonnement;
import com.example.bilabonnement.Model.Bil;
import com.example.bilabonnement.Model.Kunde;
import com.example.bilabonnement.Repository.BilRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BilService {

    @Autowired
    BilRepo bilRepo;

    public void opretBil(Bil bil){
        bilRepo.opretBil(bil);
    }
    public List<Bil> seBilListe(){
        return bilRepo.seBilListe();
    }
    public Bil findBil(int vognnummer){
       return bilRepo.findBil(vognnummer);
    }
    public void opdaterBil(Bil bil){
        bilRepo.opdaterBil(bil);
    }
    public Boolean sletBil (int vognnummer){
        return bilRepo.sletBil(vognnummer);
    }
    public void opretAbonnement(Abonnement abonnement){
        bilRepo.opretAbonnement(abonnement);
    }
    public void opdaterOprettelseAbonnement(Abonnement abonnement){ bilRepo.opdaterOprettelseAbonnement(abonnement);}
    public List<Abonnement> seAbonnementListe(){
        return bilRepo.seAbonnementListe();
    }
    public Boolean sletAbonnement (int abonnementnummer){return bilRepo.sletAbonnement(abonnementnummer);
    }

    public Abonnement findAbonnement( int abonnementnummer){
        return bilRepo.findAbonnement(abonnementnummer);
    }
    public void opdaterAbonnement(Abonnement abonnement){
      bilRepo.opdaterAbonnement(abonnement);
    }
    public List<Abonnement> sortByKundenummer(){
        return bilRepo.sortByKundenummer();
    }
    public List<Abonnement> sortByMaxkm(){return bilRepo.sortByMaxkm();}
    public List<Abonnement> sortByMånedspris(){
        return bilRepo.sortByMånedspris();
    }
    public List<Abonnement> sortBySlutdato() { return bilRepo.sortBySlutdato(); }
    public List<Abonnement> sortByStartdato() { return bilRepo.sortByStartdato(); }
    public List<Abonnement> sortByAbonnementnummer(){
        return bilRepo.sortByAbonnementnummer();
    }
    public List<Abonnement> sortByFK_Vognnummer(){
        return bilRepo.sortByFK_Vognnummer();
    }
    public List<Bil> sortByVognnummer(){
        return bilRepo.sortByVognnummer();
    }
    public List<Bil> sortByStelnummer(){
        return bilRepo.sortByStelnummer();
    }
    public List<Bil> sortByMærke(){
        return bilRepo.sortByMærke();
    }
    public List<Bil> sortByModel(){
        return bilRepo.sortByModel();
    }

    public List<Bil> sortByBrændstoftype(){
        return bilRepo.sortByBrændstoftype();
    }

    public List<Bil> sortByUdstyrsniveau(){
        return bilRepo.sortByUdstyrsniveau();
    }

    public List<Bil> sortByOdometer(){
        return bilRepo.sortByOdometer();
    }

    public List<Bil> sortByHestekræfter(){
        return bilRepo.sortByHestekræfter();
    }

    public List<Bil> sortByStålpris(){
        return bilRepo.sortByStålpris();
    }
    public List<Bil> sortByCo2udledning(){
        return bilRepo.sortByCo2udledning();
    }
    public List<Bil> sortByKMperliter(){
        return bilRepo.sortByKMperliter();
    }
    public List<Bil> sortByRegistreringsafgift(){
        return bilRepo.sortByRegistreringsafgift();
    }

    public List<Bil> visTilgængeligeBiler() { return bilRepo.visTilgængeligeBiler();}

    public List<Kunde> seKundeListe(){
        return bilRepo.seKundeListe();
    }
    public void opretKunde(Kunde kunde){
        bilRepo.opretKunde(kunde);
    }
    public Kunde findKunde(int kundenummer){
        return bilRepo.findKunde(kundenummer);
    }
    public void opdaterKunde(Kunde kunde){
        bilRepo.opdaterKunde(kunde);
    }
    public boolean sletKunde(int kundenummer){
        return bilRepo.sletKunde(kundenummer);
    }

    public void opdaterStatus(int vognnummer){
        bilRepo.opdaterStatus(vognnummer);
    }

}






