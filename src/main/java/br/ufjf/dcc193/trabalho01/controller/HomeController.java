package br.ufjf.dcc193.trabalho01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.ufjf.dcc193.trabalho01.model.Sede;
import br.ufjf.dcc193.trabalho01.persistence.SedeRepository;

/**
 * HomeController
 */
@Controller
public class HomeController {

    @Autowired
    SedeRepository repSedes;
    //List<Sede> sedes = new ArrayList<Sede>();

    @RequestMapping({"","index.html"})
    public ModelAndView home(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home");
        List<Sede> sedes = repSedes.findAll();

        mv.addObject("sedes", sedes);

        return mv;
    }

    @RequestMapping("editasede.html")
    public String editaSede(){
        return "editasede";
    }

    @RequestMapping("novasede.html")
    public String novasede(){
        return "novasede";
    }

    /*@RequestMapping("novomembro.html")
    public String novomembro(){
        return "novomembro";
    }
    
    @RequestMapping("novaatividade.html")
    public String novaatividade(){
        return "novaatividade";
    }*/
    
}