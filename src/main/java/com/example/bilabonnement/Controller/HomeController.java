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


    @GetMapping("/opretBil") //opretBil-knappen på startsiden kalder denne controller, som sender browseren til opretBil.html
    public String opretBil(){
        return "/opretBil";
    }

    @PostMapping("/opretBil")
    public String opretBil(@ModelAttribute Bil bil){
        bilService.opretBil(bil);
        return "/bekræftOpret";
    }

    @GetMapping("/SeBil") //seBil-knappen på startsiden kalder denne controller, som sender browseren til seBil.html
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
    @GetMapping("/opdaterAbonnement/{abonnementnummer}")
    public  String opdaterAbonnement(@PathVariable("abonnementnummer") int abonnementnummer, Model model){
        //System.out.println(bilService.findBil(vognnummer).getVognnummer());
        model.addAttribute("abonnement",bilService.findAbonnement(abonnementnummer));
        return "/opdaterAbonnement";
    }
    @PostMapping("/opdaterAbonnement")
    public String opdaterAbonnement(@ModelAttribute Abonnement abonnement){
        bilService.opdaterAbonnement(abonnement);
        return "redirect:/SeAbonnement";
    }


}
