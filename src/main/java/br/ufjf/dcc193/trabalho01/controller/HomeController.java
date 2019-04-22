package br.ufjf.dcc193.trabalho01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import br.ufjf.dcc193.trabalho01.model.Atividade;
import br.ufjf.dcc193.trabalho01.model.Membro;
import br.ufjf.dcc193.trabalho01.model.Sede;
import br.ufjf.dcc193.trabalho01.model.Atividade.Categoria;
import br.ufjf.dcc193.trabalho01.persistence.AtividadeRepository;
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

    @Autowired
    AtividadeRepository repAtividades;
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
        //System.err.println(repSedes.selectDuracaoTotal());
        return mv;
    }

    ///Termina Sede

    ///Início Membro

    @RequestMapping("formeditamembro.html")
    public ModelAndView formeditamembro(@RequestParam Long id, @RequestParam Long idSede){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("formeditamembro");
        mv.addObject("membro", repMembros.getOne(id));
        mv.addObject("idSede", idSede);
        return mv;
    }

    @RequestMapping("editamembro.html")
    public RedirectView editamembro(Membro membro, @RequestParam Long id, @RequestParam Long idSede){
        //System.err.println("Membro ID:" + id);
        //System.err.println("Sede ID:" + idSede);
        Membro updateMembro = repMembros.getOne(id);
        updateMembro.setNome(membro.getNome());
        updateMembro.setFuncao(membro.getFuncao());
        updateMembro.setEmail(membro.getEmail());
        updateMembro.setDataEntrada(membro.getDataEntrada());
        updateMembro.setDataEntrada(membro.getDataSaida());
        repMembros.save(updateMembro);
        return new RedirectView("visualizasede.html?id="+idSede);
    }

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

    @RequestMapping("deletamembro.html")
    public ModelAndView deletamembro(@RequestParam Long id, @RequestParam Long idSede){
        ModelAndView mv = new ModelAndView();
        System.err.println("Membro: " + id);
        System.err.println("Sede: " + idSede);
        mv.addObject("idSede", idSede);
        mv.setViewName("deletamembro");
        Membro membro = repMembros.getOne(id);
        Sede sede1 = repSedes.getOne(idSede);
        sede1.removeMembro(membro);
        repMembros.deleteById(id);
        return mv;
    }

    ///Termina Membro

    ///Início Atividade

    @RequestMapping("formnovaatividade.html")
    public ModelAndView formnovaatividade(@RequestParam Long idSede){
        ModelAndView mv = new ModelAndView();
        System.err.println(idSede);
        mv.addObject("idSede", idSede);
        return mv;
    }

    @RequestMapping("novaatividade.html")
    public RedirectView novaatividade(Atividade atividade, Long idSede){
        System.err.println(idSede);
        System.err.println(atividade.getCategoria().toString());
        repAtividades.save(atividade);
        Sede sede1 = repSedes.getOne(idSede);
        sede1.addAtividade(atividade);
        repSedes.save(sede1);
        return new RedirectView("visualizasede.html?id=" + idSede);
    }

    @RequestMapping("deletaatividade.html")
    public ModelAndView deletaatividade(@RequestParam Long id, @RequestParam Long idSede){
        ModelAndView mv = new ModelAndView();
        System.err.println("Atividade: " + id);
        System.err.println("Sede: " + idSede);
        mv.addObject("idSede", idSede);
        mv.setViewName("deletaatividade");
        Atividade atividade = repAtividades.getOne(id);
        Sede sede1 = repSedes.getOne(idSede);
        sede1.removeAtividade(atividade);
        repAtividades.deleteById(id);
        return mv;
    }

    @RequestMapping("formeditaatividade.html")
    public ModelAndView formeditaatividade(@RequestParam Long id, @RequestParam Long idSede){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("formeditaatividade");
        mv.addObject("atividade", repAtividades.getOne(id));
        mv.addObject("idSede", idSede);
        return mv;
    }

    @RequestMapping("editaatividade.html")
    public RedirectView editaatividade(Atividade atividade, @RequestParam Long id, @RequestParam Long idSede){
        //System.err.println("Atividade ID:" + id);
        //System.err.println("Sede ID:" + idSede);
        Atividade updateAtividade = repAtividades.getOne(id);
        updateAtividade.setTitulo(atividade.getTitulo());
        updateAtividade.setDescricao(atividade.getDescricao());
        updateAtividade.setDataInicio(atividade.getDataInicio());
        updateAtividade.setDataFim(atividade.getDataFim());
        updateAtividade.setDuracao(atividade.getDuracao());
        updateAtividade.setCategoria(atividade.getCategoria());
        repAtividades.save(updateAtividade);
        return new RedirectView("visualizasede.html?id="+idSede);
    }

    ///Termina Atividade
    
    ///Inicio Relatorio
    
    @RequestMapping("relatorioduracaototal.html")
    public ModelAndView relatorioduracaototal(@RequestParam Long id){
        ModelAndView mv = new ModelAndView();
        int duracaoTotal = 0;
        int duracaoFinanceira = 0;
        int duracaoExecutiva = 0;
        int duracaoJuridica = 0;
        int duracaoAssistencial = 0;
        Sede sede = repSedes.getOne(id);
        for (Atividade a : sede.getAtividades()) {
            System.err.println(a.getCategoria());
            if(a.getCategoria().equals(Categoria.FINANCEIRA)){
                duracaoFinanceira += a.getDuracao();
            } else if(a.getCategoria().equals(Categoria.JURIDICA)){
                duracaoJuridica += a.getDuracao();
            } else if(a.getCategoria().equals(Categoria.ASSISTENCIAL)){
                duracaoAssistencial += a.getDuracao();
            } else {
                duracaoExecutiva += a.getDuracao();
            }
        }
        duracaoTotal = duracaoAssistencial + duracaoExecutiva + duracaoFinanceira + duracaoJuridica;
        mv.setViewName("relatorioduracaototal");
        mv.addObject("duracaoTotal", duracaoTotal);
        mv.addObject("duracaoJuridica", duracaoJuridica);
        mv.addObject("duracaoFinanceira", duracaoFinanceira);
        mv.addObject("duracaoExecutiva", duracaoExecutiva);
        mv.addObject("duracaoAssistencial", duracaoAssistencial);
        mv.addObject("id", id);
        return mv;
    }

    ///Termina Relatorio
    
}