package com.example.bilabonnement.Service;


import com.example.bilabonnement.Model.Abonnement;
import com.example.bilabonnement.Model.Bil;
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

    public List<Abonnement> sortByDate(){
        return bilRepo.sortByDate();
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
}


