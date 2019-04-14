package br.ufjf.dcc193.trabalho01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * HomeController
 */
@Controller
public class HomeController {

    @RequestMapping({"","index.html"})
    public String home(){
        return "home";
    }

    @RequestMapping("novasede.html")
    public String novasede(){
        return "novasede";
    }

    @RequestMapping("novomembro.html")
    public String novomembro(){
        return "novomembro";
    }
    
    @RequestMapping("novaatividade.html")
    public String novaatividade(){
        return "novaatividade";
    }
    
}