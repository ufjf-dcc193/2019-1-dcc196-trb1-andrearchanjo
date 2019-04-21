package br.ufjf.dcc193.trabalho01.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Atividade
 */
@Entity
public class Atividade {

    public enum Categoria {
        ASSISTENCIAL,
        JURIDICA,
        FINANCEIRA,
        EXECUTIVA;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String titulo;
    private String descricao;
    private String dataInicio;
    private String dataFim;
    private int duracao;
    private Categoria categoria;

    public Atividade(){

    }

    public Atividade(String titulo, String descricao, String dataInicio, String dataFim, int duracao, Categoria categoria){
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.duracao = duracao;
        this.categoria = categoria;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the dataInicio
     */
    public String getDataInicio() {
        return dataInicio;
    }

    /**
     * @param dataInicio the dataInicio to set
     */
    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    /**
     * @return the dataFim
     */
    public String getDataFim() {
        return dataFim;
    }

    /**
     * @param dataFim the dataFim to set
     */
    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    /**
     * @return the duracao
     */
    public int getDuracao() {
        return duracao;
    }

    /**
     * @param duracao the duracao to set
     */
    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    /**
     * @return the categoria
     */
    public Categoria getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Atividade [categoria=" + categoria + ", dataFim=" + dataFim + ", dataInicio=" + dataInicio
                + ", descricao=" + descricao + ", duracao=" + duracao + ", id=" + id + ", titulo=" + titulo + "]";
    }

    

}