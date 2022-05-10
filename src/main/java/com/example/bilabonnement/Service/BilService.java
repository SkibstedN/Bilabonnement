package com.example.bilabonnement.Service;


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
    public Bil findBil(String stelnummer){
       return bilRepo.findBil(stelnummer);
    }
    public void opdaterBil(Bil bil){
        bilRepo.opdaterBil(bil);
    }
    public Boolean sletBil (String stelnummer){
       return BilRepo.sletBil(stelnummer);
    }

}

