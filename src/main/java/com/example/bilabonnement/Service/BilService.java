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

}

