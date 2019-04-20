package br.ufjf.dcc193.trabalho01.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Sede
 */
@Entity
public class Sede {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String nome;
    private String estado;
    private String cidade;
    private String bairro;
    private String telefone;
    private String enderecoWeb;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Membro> membros;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Atividade> atividades;

    public Sede(){

    }

    public Sede(String nome, String estado, String cidade, String bairro, String telefone, String enderecoWeb){
        this.nome = nome;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.telefone = telefone;
        this.enderecoWeb = enderecoWeb;
        membros = new ArrayList<Membro>();
        atividades = new ArrayList<Atividade>();
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the enderecoWeb
     */
    public String getEnderecoWeb() {
        return enderecoWeb;
    }

    /**
     * @param enderecoWeb the enderecoWeb to set
     */
    public void setEnderecoWeb(String enderecoWeb) {
        this.enderecoWeb = enderecoWeb;
    }

    @Override
    public String toString() {
        return "Sede [bairro=" + bairro + ", cidade=" + cidade + ", enderecoWeb=" + enderecoWeb + ", estado=" + estado
                + ", id=" + id + ", nome=" + nome + ", telefone=" + telefone + "]";
    }
    
    /**
     * @return the membros
     */
    public List<Membro> getMembros() {
        return membros;
    }

    /**
     * @param membros the membros to set
     */
    public void setMembros(List<Membro> membros) {
        this.membros = membros;
    }

    public void addMembro(Membro membro){
        this.membros.add(membro);
    }

    public void removeMembro(Membro membro){
        this.membros.remove(membro);
    }
    
    /**
     * @return the atividades
     */
    public List<Atividade> getAtividades() {
        return atividades;
    }
    
    /**
     * @param atividades the atividades to set
     */
    public void setAtividades(List<Atividade> atividades) {
        this.atividades = atividades;
    }

    public void addAtividade(Atividade atividade){
        this.atividades.add(atividade);
    }

    public void removeAtividade(Atividade atividade){
        this.atividades.remove(atividade);
    }

    

}