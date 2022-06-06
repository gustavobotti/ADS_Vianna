/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.vianna.exercicio2.model;

/**
 *
 * @author -
 */
public class Empregado {
    
    private String nome;
    private int idade, anosTrabalhados;

    public String podeAposentar(){
        if(idade > 65 || anosTrabalhados > 30 || idade > 60 && anosTrabalhados > 25){
        return "voce pode aposentar.";
        } else {
            return "voce nao pode aposentar.";
        }
    }    
  
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getAnosTrabalhados() {
        return anosTrabalhados;
    }

    public void setAnosTrabalhados(int anosTrabalhados) {
        this.anosTrabalhados = anosTrabalhados;
    }

    public Empregado(String nome, int idade, int anosTrabalhados) {
        this.nome = nome;
        this.idade = idade;
        this.anosTrabalhados = anosTrabalhados;
    }

    public Empregado() {
    }
    
}
