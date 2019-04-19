package br.ufjf.dcc193.trabalho01.model;

import java.util.List;

/**
 * Sede
 */
public class Sede {

    private Long id;
    private String nome;
    private String estado;
    private String cidade;
    private String bairro;
    private String telefone;
    private String enderecoWeb;
    private List<Membro> membros;
    private List<Atividade> atividades;

    public Sede(String nome, Long id){
        this.nome = nome;
        this.id = id;
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
    
    
}