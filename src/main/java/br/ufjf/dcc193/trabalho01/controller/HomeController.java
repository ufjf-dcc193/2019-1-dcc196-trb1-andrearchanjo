package br.ufjf.dcc193.trabalho01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import br.ufjf.dcc193.trabalho01.model.Membro;
import br.ufjf.dcc193.trabalho01.model.Sede;
import br.ufjf.dcc193.trabalho01.persistence.MembroRepository;
import br.ufjf.dcc193.trabalho01.persistence.SedeRepository;

/**
 * HomeController
 */
@Controller
public class HomeController {

    @Autowired
    SedeRepository repSedes;

    @Autowired
    MembroRepository repMembros;
    //List<Sede> sedes = new ArrayList<Sede>();

    @RequestMapping({"","index.html"})
    public ModelAndView home(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home");
        List<Sede> sedes = repSedes.findAll();
        mv.addObject("sedes", sedes);
        return mv;
    }

    ///Início Sede

    @RequestMapping("formeditasede.html")
    public ModelAndView formeditasede(@RequestParam Long id){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("formeditasede");
        mv.addObject("sede", repSedes.getOne(id));
        return mv;
    }

    @RequestMapping("editasede.html")
    public RedirectView editasede(Sede sede){
        Sede updateSede = repSedes.getOne(sede.getId());
        updateSede.setNome(sede.getNome());
        updateSede.setEstado(sede.getEstado());
        updateSede.setCidade(sede.getCidade());
        updateSede.setBairro(sede.getBairro());
        updateSede.setTelefone(sede.getTelefone());
        updateSede.setEnderecoWeb(sede.getEnderecoWeb());
        //System.out.println(sede.getId());
        repSedes.save(updateSede);
        return new RedirectView("visualizasede.html?id=" + sede.getId());
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
        mv.addObject("sede", repSedes.getOne(id));
        return mv;
    }

    ///Termina Sede

    ///Início Membro

    @RequestMapping("formnovomembro.html")
    public ModelAndView formnovomembro(@RequestParam Long idSede){
        ModelAndView mv = new ModelAndView();
        System.err.println(idSede);
        mv.addObject("idSede", idSede);
        return mv;
    }

    @RequestMapping("novomembro.html")
    public RedirectView novomembro(Membro membro, Long idSede){
        repMembros.save(membro);
        Sede sede1 = repSedes.getOne(idSede);
        sede1.addMembro(membro);
        repSedes.save(sede1);
        return new RedirectView("visualizasede.html?id=" + idSede);
    }


    ///Termina Membro
    
    /*@RequestMapping("novaatividade.html")
    public String novaatividade(){
        return "novaatividade";
    }*/
    
}