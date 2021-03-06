package com.example.bilabonnement.Controller;

import com.example.bilabonnement.Model.Abonnement;
import com.example.bilabonnement.Model.Bil;
import com.example.bilabonnement.Model.Kunde;
import com.example.bilabonnement.Service.BilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLOutput;
import java.util.List;

@Controller
public class HomeController {
@Autowired
BilService bilService;

    @GetMapping("/")  //når root "/" bliver kaldt i browseren, sender denne controller browseren videre til startside.html.
    public String startside(){
        return "/startside";
    }



    @GetMapping("/startsideDataregistrering")  //sender fra startsiden til dataregistrerings forsiden. og indlæser abonnementerne til dashbordet
    public String startsideDataregistrering(Model model){
        List<Abonnement> abonnementListe = bilService.sortBySlutdato();
        model.addAttribute("abonnementliste", abonnementListe);
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

    @GetMapping("/administrerAbonnementer") //sender brugeren fra dataregistreringforsiden til abonnementsiden, og indlæser listen af oprettede abonnementer
    public String administrerAbonnementer(Model model){
        List<Abonnement> abonnementListe = bilService.seAbonnementListe();
        model.addAttribute("abonnementliste", abonnementListe);
        return "/abonnementSide";
    }

    @GetMapping("/administrerBiler") //sender brugeren fra dataregistreringforsiden til bilsiden, og indlæser listen af biler i systemet
    public String administrerBiler(Model model){
        List<Bil> bilListe = bilService.seBilListe();
        model.addAttribute("billiste",bilListe);
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

    @PostMapping("/opretBil") //gemmer informationerne fra opretBil html, til databasen, og sender videre til administrerBiler, så billisten genindlæses.
    public String opretBil(@ModelAttribute Bil bil){
        bilService.opretBil(bil);
        return "redirect:/administrerBiler";
    }

    @GetMapping("/opdaterBil/{vognnummer}")//finder bilen i databasen, ud fra vognnumeret brugeren giver, så næste html side kan display de korrekte informationer, så de evt, kan opdateres
    public  String opdaterBil(@PathVariable("vognnummer") int vognnummer, Model model){
        model.addAttribute("bil",bilService.findBil(vognnummer));
        return "/opdaterBil";
    }
    @PostMapping("/opdaterBil")//gemmer det rettede bilobject i databasen, sender videre til administrerBiler, så listen af biler genindlæses
    public String opdaterBil(@ModelAttribute Bil bil){
        bilService.opdaterBil(bil);
      return "redirect:/administrerBiler";
    }
    @GetMapping("/sletBil/{vognnummer}")//finder den ønskede bil ud fra vognnumeret, og sender så videre til en verifikationsside om slettelse
    public String sletBil(@PathVariable("vognnummer")int vognnummer, Model model){
        Bil bilDerSkalSlettes = bilService.findBil(vognnummer);
        model.addAttribute("bilDerSkalSlettes",bilDerSkalSlettes);
        return "/bekræftSletBil";
    }
    @GetMapping("/bekræftSletBilKnapNej")// hvis brugeren fortryder sletningen af bilen, sender vi dem tilbage til administrerBiler html siden.
    public String bekræftSletBilNej(){
        return "redirect:/administrerBiler";
    }

    @GetMapping("/bekræftSletBilKnap/{vognnummer}") //hvis brugeren bekræfter slettelsen af bilen, så slettes den fra databasen, og sender browseren tilbage til administrerBiler, så listen genindlæses
    public String bekræfSletBil(@PathVariable("vognnummer") int vognnummer){
        boolean sletbilen = bilService.sletBil(vognnummer);
        if(sletbilen) {
            return "redirect:/administrerBiler";
        } else {
            return "redirect:/administrerBiler"; //skal sende en fejlmeddelelse hvis noget gik galt
        }
    }

    @GetMapping("/abonnementSide")//sender fra dataregisterings siden til abonnementSide.html
    public String abonnementSide(){
        return "/abonnementSide";
    }

    @GetMapping("/opretAbonnement") //sender fra abonnemenSide.html til opretAbonnement.html når man trykker på  knappen der hedder opret abonnement
    public String opretAbonnement(){
        return "/opretAbonnement";
    }

    @PostMapping("/opretAbonnementKnap") /*tager imod info til at oprette abonnement,
    via annotationen @ModelAttribute, tilføjer liste med tilgængelige biler til Model som attribut,
    så tilgængeligeBiler.html kan vise alle informationerne*/
    public String opretAbonnementKnap(@ModelAttribute Abonnement abonnement, Model model){
        model.addAttribute("abonnement",abonnement);
        List<Bil> bilListe = bilService.visTilgængeligeBiler();
        model.addAttribute("billiste", bilListe);
        bilService.opretAbonnement(abonnement);
        return "/tilgængeligeBiler";
    }

    @GetMapping("/finalOpretAbonnementKnap/{vognnummer}/{abonnementnummer}")
    /*Tager imod vognnummer og abonnementnummer som strings fra forrige html formular,
    caster dem til int datatype refereret med @Pathvariable annotationen -
    indlæser det referedede abonnement, sætter vognnummer til  den værdi vi har med som parameter
    opdaterer abonnementet i databasen, med det nye vognnummer
    opdatarer Status på den valgte bil til 'Optaget'
    Redirecter til administereAbonnementer controlleren som indlæser den opdaterede liste */
    public String finalOpretAbonnement(@PathVariable("vognnummer") int vognnummer,
                                       @PathVariable("abonnementnummer") int abonnementnummer){

        Abonnement nytAbonnement =bilService.findAbonnement(abonnementnummer);
        nytAbonnement.setFK_vognnummer(vognnummer);
        bilService.opdaterOprettelseAbonnement(nytAbonnement);
        bilService.opdaterStatus(vognnummer);
        return "redirect:/administrerAbonnementer";
    }

    @GetMapping("/opdaterAbonnement/{abonnementnummer}")/*Tager imod et abonnementnummer via @PathVariable for at finde det ønskede
    abonnement og tilføjer det som attribut til model
    via addAttribut metoden så næste html side har adgang abonnementet*/
    public  String opdaterAbonnement(@PathVariable("abonnementnummer") int abonnementnummer, Model model){
        model.addAttribute("abonnement",bilService.findAbonnement(abonnementnummer));
        return "/opdaterAbonnement";
    }
    @PostMapping("/opdaterAbonnement")/*Den tager imod det data fra forrige html side og bruger @ModelAttribute
    så vi kan opdatere databasen med de nye informationer. Til sidst redirecter til administrerAbonnement Controlleren,
    så listen med det opdateret abonnement kan genindlæses*/
    public String opdaterAbonnement(@ModelAttribute Abonnement abonnement){
        bilService.opdaterAbonnement(abonnement);
        return "redirect:/administrerAbonnementer";
    }

    @GetMapping("/sletAbonnement/{abonnementnummer}")/*Tager imod et abonnementnummer og finder det ønsket
    abonnement. Derefter tilføjes den med addAttribute metoden til model så den er tilgængelig til næste html formular*/
    public String sletAbonnement(@PathVariable("abonnementnummer")int abonnementnummer, Model model){
        Abonnement abonnementDerSkalSlettes = bilService.findAbonnement(abonnementnummer);
        model.addAttribute("abonnementDerSkalSlettes",abonnementDerSkalSlettes);
        return "/bekræftSletAbonnement";
        }

    @GetMapping("/bekræftSletAbonnementKnapNej")/*redirecter til administrerAbonnementer controller*/
    public String bekræftSletAbonnementNej(){
        return "redirect:/administrerAbonnementer";
    }
    @GetMapping("/bekræftSletAbonnementKnap/{abonnementnummer}")/*Tager imod abonnementnummer og
    finder det ønskede abonnement i databasen der så via et statement sletter abonnement. Derefter checker
    den på en boolean om der er slettet via et if else statement. Derefter redirecter den til
    administrerAbonnementer controlleren*/
    public String bekræftSletAbonnement(@PathVariable("abonnementnummer") int abonnementnummer){
        boolean sletabonnementet = bilService.sletAbonnement(abonnementnummer);
        if(sletabonnementet) {
            return "redirect:/administrerAbonnementer";
        } else {
            return "redirect:/administrerAbonnementer"; //skal sende en fejlmeddelelse hvis noget gik galt
        }
    }

    @GetMapping("/sorterEfterAbonnementnummer")/*den laver en abonnement liste der bliver
    tilføjet med addAttribute og gør den tilgængelig i næste html formular*/
    public String sortByAbonnementnummer(Model model){
        List<Abonnement> abonnementListe = bilService.sortByAbonnementnummer();
        model.addAttribute("abonnementliste", abonnementListe);
        return "/sorterAbonnement";
    }
    @GetMapping("/sorterEfterFK_Vognnummer")
    public String sortByFKVognnummer(Model model){
        List<Abonnement> abonnementListe = bilService.sortByFK_Vognnummer();
        model.addAttribute("abonnementliste", abonnementListe);
        return "/sorterAbonnement";
    }

    @GetMapping("/sorterEfterKundenummer")
    public String sortByKundenummer(Model model){
        List<Abonnement> abonnementListe = bilService.sortByKundenummer();
        model.addAttribute("abonnementliste", abonnementListe);
        return "/sorterAbonnement";
    }

    @GetMapping("/sorterEfterMaxkm")
    public String sortByMaxkm(Model model){
        List<Abonnement> abonnementListe = bilService.sortByMaxkm();
        model.addAttribute("abonnementliste", abonnementListe);
        return "/sorterAbonnement";
    }

    @GetMapping("/sorterEfterMånedspris")
    public String sortByMånedspris(Model model){
        List<Abonnement> abonnementListe = bilService.sortByMånedspris();
        model.addAttribute("abonnementliste", abonnementListe);
        return "/sorterAbonnement";
    }

    @GetMapping("/sorterEfterSlutdato")
    public String sortBySlutdato(Model model){
        List<Abonnement> abonnementListe = bilService.sortBySlutdato();
        model.addAttribute("abonnementliste", abonnementListe);
        return "/sorterAbonnement";
    }

    @GetMapping("/sorterEfterStartdato")
    public String sortByStartdato(Model model){
        List<Abonnement> abonnementListe = bilService.sortByStartdato();
        model.addAttribute("abonnementliste", abonnementListe);
        return "/sorterAbonnement";
    }
    @GetMapping("/sorterEfterVognnummer") // Dette er et browser kald, når denne string bliver kaldt i browseren initialisere den methoden under.
    public String sortByVognnummer(Model model){//Methoden indeholder en Model model der er et tomt og abstrakt objekt der kan morphe ind til at blive en liste med biler og derefter sendes videre til html filen sorter bil.
            List<Bil> bilListe = bilService.sortByVognnummer();//her bliver en liste med bil objekter fyldt ved et methode kald til BilService som kalder BilRepo.
            model.addAttribute("billiste",bilListe);//Model transformeres til at være listen med biler og får navnet billiste til at kunne identificeres med thymeleaf i html filen.
        return "/sorterBil";//Html filen /sorterBil bliver kaldt.
    }
    @GetMapping("/sorterEfterStelnummer")
    public String sortByStelnummer(Model model){
        List<Bil> bilListe = bilService.sortByStelnummer();
        model.addAttribute("billiste",bilListe);
        return "/sorterBil";
    }
    @GetMapping("/sorterEfterMærke")
    public String sortByMærke(Model model){
        List<Bil> bilListe = bilService.sortByMærke();
        model.addAttribute("billiste",bilListe);
        return "/sorterBil";
    }
    @GetMapping("/sorterEfterModel")
    public String sortByModel(Model model){
        List<Bil> bilListe = bilService.sortByModel();
        model.addAttribute("billiste",bilListe);
        return "/sorterBil";
    }

    @GetMapping("/sorterEfterBrændstoftype")
    public String sortByBrændstoftype(Model model){
        List<Bil> bilListe = bilService.sortByBrændstoftype();
        model.addAttribute("billiste",bilListe);
        return "/sorterBil";
    }

    @GetMapping("/sorterEfterUdstyrsniveau")
    public String sortByUdstyrsniveau(Model model){
        List<Bil> bilListe = bilService.sortByUdstyrsniveau();
        model.addAttribute("billiste",bilListe);
        return "/sorterBil";
    }

    @GetMapping("/sorterEfterOdometer")
    public String sortByOdometer(Model model){
        List<Bil> bilListe = bilService.sortByOdometer();
        model.addAttribute("billiste",bilListe);
        return "/sorterBil";
    }

    @GetMapping("/sorterEfterHestekræfter")
    public String sortByHestekræfter(Model model){
        List<Bil> bilListe = bilService.sortByHestekræfter();
        model.addAttribute("billiste",bilListe);
        return "/sorterBil";
    }
    @GetMapping("/sorterEfterStålpris")
    public String sortByStålpris(Model model){
        List<Bil> bilListe = bilService.sortByStålpris();
        model.addAttribute("billiste",bilListe);
        return "/sorterBil";
    }
    @GetMapping("/sorterEfterCo2udledning")
    public String sortByCo2udledning(Model model){
        List<Bil> bilListe = bilService.sortByCo2udledning();
        model.addAttribute("billiste",bilListe);
        return "/sorterBil";
    }
    @GetMapping("/sorterEfterKMperliter")
    public String sortByKMperliter(Model model){
        List<Bil> bilListe = bilService.sortByKMperliter();
        model.addAttribute("billiste",bilListe);
        return "/sorterBil";
    }
    @GetMapping("/sorterEfterRegistreringsafgift")   //Seder brugeren fra
    public String sortByRegistreringsafgift(Model model){
        List<Bil> bilListe = bilService.sortByRegistreringsafgift();
        model.addAttribute("billiste",bilListe);
        return "/sorterBil";
    }

    @GetMapping("/administrerKunder")
    public String administrerKunder(Model model){
        List<Kunde> kundeListe = bilService.seKundeListe();
        model.addAttribute("kundeliste", kundeListe);
        return "/kundeSide";
    }
    @GetMapping("/opretKunde")
    public String opretKunde(){
        return "/opretKunde";
    }

    @PostMapping("/opretKundeKnap")
    public String opretKundeKnap(@ModelAttribute Kunde kunde){
        bilService.opretKunde(kunde);
        return "redirect:/administrerKunder";
    }

    @GetMapping("/opdaterKunde/{kundenummer}")
    public  String opdaterKunde(@PathVariable("kundenummer") int kundenummer, Model model){
        model.addAttribute("kunde",bilService.findKunde(kundenummer));
        return "/opdaterKunde";
    }
    @PostMapping("/opdaterKundeKnap")
    public String opdaterKundeKnap(@ModelAttribute Kunde kunde){
        bilService.opdaterKunde(kunde);
        return "redirect:/administrerKunder";
    }
    @GetMapping("/sletKunde/{kundenummer}")
    public String sletKunde(@PathVariable("kundenummer")int kundenummer, Model model){
        Kunde kundeDerSkalSlettes = bilService.findKunde(kundenummer);
        model.addAttribute("kundeDerSkalSlettes",kundeDerSkalSlettes);
        return "/bekræftSletKunde";
    }
    @GetMapping("/bekræftSletKundeKnapNej")
    public String bekræftSletKundeNej(){
        return "redirect:/administrerKunder";
    }

    @GetMapping("/bekræftSletKundeKnap/{kundenummer}")
    public String bekræfKundeBil(@PathVariable("kundenummer") int kundenummer){
        boolean sletkunden = bilService.sletKunde(kundenummer);
        if(sletkunden) {
            return "redirect:/administrerKunder";
        } else {
            return "redirect:/administrerKunder"; //skal sende en fejlmeddelelse hvis noget gik galt
        }
    }


}
