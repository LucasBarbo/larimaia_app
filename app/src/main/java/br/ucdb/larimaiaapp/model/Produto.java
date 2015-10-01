package br.ucdb.larimaiaapp.model;

/**
 * Created by Mar_Ju on 23/09/2015.
 */
public class Produto {

    private Long id;
    private String descricao;
    private Double valor;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "descricao='" + descricao + '\'' +
                '}';
    }
}

