/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.todo.model;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Gustavo Botti
 */
@Entity
public class Exame {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = false)
    @Lob
    private String descricao;
    
    private boolean concluida;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date dataPlanejada;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = true)
    private Date dataFinalizada;
        
    @Column(nullable = false)
    private double custo;
    
    @Column(nullable = false)
    private int tempoJejum;   
   
    
    @ManyToOne
    private Usuario usuario;
    

    public Exame() {
    }

    public Exame(int id, String descricao, boolean concluida, Date dataPlanejada, Date dataFinalizada, double custo, int tempoJejum) {
        this.id = id;
        this.descricao = descricao;
        this.concluida = concluida;
        this.dataPlanejada = dataPlanejada;
        this.dataFinalizada = dataFinalizada;
        this.custo = custo;
        this.tempoJejum = tempoJejum;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }
    
    public String dataPlanejadaString(){
    
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                
        return sdf.format(dataPlanejada);
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    public Date getDataPlanejada() {
        return dataPlanejada;
    }

    public void setDataPlanejada(Date dataPlanejada) {
        this.dataPlanejada = dataPlanejada;
    }

    public Date getDataFinalizada() {
        return dataFinalizada;
    }

    public void setDataFinalizada(Date dataFinalizada) {
        this.dataFinalizada = dataFinalizada;
    }

    public int getTempoJejum() {
        return tempoJejum;
    }

    public void setTempoJejum(int tempoJejum) {
        this.tempoJejum = tempoJejum;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
}
