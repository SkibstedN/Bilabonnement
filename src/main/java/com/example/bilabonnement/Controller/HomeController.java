package com.example.bilabonnement.Controller;

import com.example.bilabonnement.Model.Abonnement;
import com.example.bilabonnement.Model.Bil;
import com.example.bilabonnement.Service.BilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {
@Autowired
BilService bilService;

    @GetMapping("/")  //når root "/" bliver kaldt i browseren, sender denne controller browseren videre til startside.html.
    public String startside(){
        return "/startside";
    }

    @GetMapping("/startsideDataregistrering")  //sender fra startsiden til dataregistrerings forsiden
    public String startsideDataregistrering(){
        return "/dataregistrering";
    }

    @GetMapping("/startsideSkadeogUdbedring") //sender fra startsiden til skade og udbedrings forsiden
    public String startsideSkadeogUdbedring(){
        return "/skadeogudbedring";
    }

    @GetMapping("/startsideForretningsUdviklere") //sender fra startsiden til forretnings udviklernes forside
    public String startsideForretningsUdviklere(){
        return "/forretningsudviklere";
    }

    @GetMapping("/administrerAbonnementer") //sender fra dataregistreringforsiden til abonnementsiden
    public String administrerAbonnementer(){
        return "/abonnementSide";
    }

    @GetMapping("/administrerBiler") //sender fra dataregistreringforsiden til bilsiden
    public String administrerBiler(){
        return "/bilSide";
    }

    @GetMapping("/administrerFejlrapporterData") //sender fra dataregistreringforsiden til fejlrapportsiden
    public String administrerFejlrapporterData(){
        return "/fejlrapportSide";
    }


    @GetMapping("/opretBil") //sender browseren fra bilsiden til opretBil.html
    public String opretBil(){
        return "/opretBil";
    }

    @PostMapping("/opretBil")
    public String opretBil(@ModelAttribute Bil bil){
        bilService.opretBil(bil);
        return "/bekræftOpret";
    }

    @GetMapping("/SeBil") // sender browseren fra bilsiden til seBil.html
    public String SeBil(Model model){
        List<Bil> bilListe = bilService.seBilListe();
        model.addAttribute("billiste", bilListe);
        return "/seBil";
    }
    @GetMapping("/opdaterBil/{vognnummer}")
    public  String opdaterBil(@PathVariable("vognnummer") int vognnummer, Model model){
        //System.out.println(bilService.findBil(vognnummer).getVognnummer());
        model.addAttribute("bil",bilService.findBil(vognnummer));
        return "/opdaterBil";
    }
    @PostMapping("/opdaterBil")
    public String opdaterBil(@ModelAttribute Bil bil){
        bilService.opdaterBil(bil);
      return "redirect:/SeBil";
    }
    @GetMapping("/sletBil/{vognnummer}")
    public String sletBil(@PathVariable("vognnummer")int vognnummer){
        boolean sletbilen = bilService.sletBil(vognnummer);
        if(sletbilen) {
            return "redirect:/SeBil";
        } else {
            return "redirect:/SeBil";
        }
    }

    @GetMapping("/abonnementSide")
    public String abonnementSide(){
        return "/abonnementSide";
    }

    @GetMapping("/opretAbonnement")
    public String opretAbonnement(){
        return "/opretAbonnement";
    }

    @PostMapping("/opretAbonnementKnap")
    public String opretAbonnementKnap(@ModelAttribute Abonnement abonnement){
        bilService.opretAbonnement(abonnement);
        return "/abonnementSide";

    }
    @GetMapping("/SeAbonnement")
    public String SeAbonnement(Model model) {
        List<Abonnement> abonnementListe = bilService.seAbonnementListe();
        model.addAttribute("abonnementliste", abonnementListe);
        return "/seAbonnement";
    }

    @GetMapping("/sletAbonnement/{abonnementnummer}")
    public String sletAbonnement(@PathVariable("abonnementnummer")int abonnementnummer){
        boolean sletabonnementet = bilService.sletAbonnement(abonnementnummer);
        if(sletabonnementet) {
            return "redirect:/SeAbonnement";
        } else {
            return "redirect:/SeAbonnement";
        }
    }

}
