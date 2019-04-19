package br.ufjf.dcc193.trabalho01.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.ufjf.dcc193.trabalho01.model.Sede;

/**
 * HomeController
 */
@Controller
public class HomeController {

    List<Sede> sedes = new ArrayList<Sede>();

    @RequestMapping({"","index.html"})
    public ModelAndView home(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home");
        
        Sede sede1 = new Sede("Microsoft", 1L);
        sedes.add(sede1);
        Sede sede2 = new Sede("Apple", 2L);
        sedes.add(sede2);
        mv.addObject("sedes", sedes);
        return mv;
    }

    @RequestMapping("editasede.html")
    public String editaSede(){
        return null;
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