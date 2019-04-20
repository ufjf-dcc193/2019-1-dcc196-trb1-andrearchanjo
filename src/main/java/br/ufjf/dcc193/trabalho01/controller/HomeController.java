package br.ufjf.dcc193.trabalho01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

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

    @RequestMapping("formeditasede.html")
    public String formeditasede(){
        return "formeditasede";
    }

    @RequestMapping("formnovasede.html")
    public String formnovasede(){
        return "formnovasede";
    }

    @RequestMapping("novasede.html")
    public RedirectView novasede(Sede sede){
        repSedes.save(sede);
        return new RedirectView("index.html");
    }

    @RequestMapping("deletasede.html")
    public String deletasede(@RequestParam Long id){
        repSedes.deleteById(id);
        return "deletasede";
    }

    @RequestMapping("visualizasede.html")
    public ModelAndView visualizasede(@RequestParam Long id){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("visualizasede");
        //Sede s1 = repSedes.getOne(id);
        mv.addObject("sede", repSedes.getOne(id));
        return mv;
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