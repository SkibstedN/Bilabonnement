package com.example.bilabonnement.Controller;

import com.example.bilabonnement.Service.BilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
@Autowired
BilService bilService;

    @GetMapping("/")
    public String startside(){
        return "/startside";
    }

    @GetMapping("/opretBil")
    public String opretBil(){
        return "/opretBil";
    }


}
