/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.vianna.projetoaula.model;

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
 * @author Aluno
 */
@Entity
public class Tarefa {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int Id;
    
    @Column( nullable = false )
    @Lob
    private String Descricao;    
    
    private boolean Concluida;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column (nullable = true)
    private Date dataPlanejada;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column (nullable = true)
    private Date dataFinalizada;
    
    private int horasGastas;
    
    //@OnetoMany
    //@Manytoone
    //@Manytomany
    //@Onetone
    
    @ManyToOne    //categoria muitos para um, pode definir tarefar sem categoria e tals ...
    private Categoria Categoria;

    public Categoria getCategoria() {
        return Categoria;
    }

    public void setCategoria(Categoria Categoria) {
        this.Categoria = Categoria;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public boolean isConcluida() {
        return Concluida;
    }

    public void setConcluida(boolean Concluida) {
        this.Concluida = Concluida;
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

    public int getHorasGastas() {
        return horasGastas;
    }

    public void setHorasGastas(int horasGastas) {
        this.horasGastas = horasGastas;
    }

    public Tarefa(int Id, String Descricao, boolean Concluida, Date dataPlanejada, Date dataFinalizada, int horasGastas) {
        this.Id = Id;
        this.Descricao = Descricao;
        this.Concluida = Concluida;
        this.dataPlanejada = dataPlanejada;
        this.dataFinalizada = dataFinalizada;
        this.horasGastas = horasGastas;
    }

    public Tarefa() {
    }    
}
