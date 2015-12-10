package br.ucdb.larimaiaapp.model;

import java.io.Serializable;

/**
 * Created by Usuario on 02/12/2015.
 */
public class Cerimonial implements Serializable {

    private Integer idCerimonial;
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String descricao) {
        this.nome = descricao;
    }

    public Integer getIdCerimonial() {
        return idCerimonial;
    }

    public void setIdCerimonial(Integer idCerimonial) {
        this.idCerimonial = idCerimonial;
    }

    @Override
    public String toString() {
        return nome;
    }
}
