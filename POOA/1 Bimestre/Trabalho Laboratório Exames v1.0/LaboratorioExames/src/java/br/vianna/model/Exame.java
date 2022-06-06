/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.vianna.model;

import java.util.Date;

/**
 *
 * @author Gustavo Botti
 */
public class Exame {
    private double custo;
    private String descricao;
    private int tempoJejum;
    private Date dataEntrega;
    private boolean jaFoiEntregue;

    public Exame() {
    }

    public Exame(double custo, String descricao, int tempoJejum, Date dataEntrega, boolean jaFoiEntregue) {
        this.custo = custo;
        this.descricao = descricao;
        this.tempoJejum = tempoJejum;
        this.dataEntrega = dataEntrega;
        this.jaFoiEntregue = jaFoiEntregue;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getTempoJejum() {
        return tempoJejum;
    }

    public void setTempoJejum(int tempoJejum) {
        this.tempoJejum = tempoJejum;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public boolean isJaFoiEntregue() {
        return jaFoiEntregue;
    }

    public void setJaFoiEntregue(boolean jaFoiEntregue) {
        this.jaFoiEntregue = jaFoiEntregue;
    }
    
    
}
