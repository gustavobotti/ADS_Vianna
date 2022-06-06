/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.exercicio4.model;

/**
 *
 * @author Botti
 */
public class Aluno {

    private String nome;
    private boolean votou;
    private int votos;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }

    public boolean isVotou() {
        return votou;
    }

    public void setVotou(boolean votou) {
        this.votou = votou;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
        //this.votos++;
    }

    public Aluno(String nome, boolean votou, int votos) {
        this.nome = nome;
        this.votou = votou;
        this.votos = votos;
    }

    public Aluno() {
    }
}