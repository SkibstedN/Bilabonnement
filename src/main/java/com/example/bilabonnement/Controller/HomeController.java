package com.example.bilabonnement.Controller;

import com.example.bilabonnement.Model.Bil;
import com.example.bilabonnement.Service.BilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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



}
