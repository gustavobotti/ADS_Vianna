/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.model;

/**
 *
 * @author Botti
 */
public class Aluno {
    private String nome;
    private int nota1, nota2;

    public double media(){
        return (nota1+nota2)/2;
    }
    
    public boolean isAprovado(){
        return media()>=7;
    }
    
    public Aluno() {
    }

    public Aluno(String nome, int nota1, int nota2) {
        this.nome = nome;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNota1() {
        return nota1;
    }

    public void setNota1(int nota1) {
        this.nota1 = nota1;
    }

    public int getNota2() {
        return nota2;
    }

    public void setNota2(int nota2) {
        this.nota2 = nota2;
    }
    
    
}
