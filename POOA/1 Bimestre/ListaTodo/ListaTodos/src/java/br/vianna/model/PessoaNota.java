/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.model;

/**
 *
 * @author Aluno
 */
public class PessoaNota {
    private String nome;
    private double nota1, nota2;
    
    public String passou(){
        if (((nota1+nota2)/2) >= 7){
            return "Aprovado!";
        
        }
        return "Reprovado!";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public PessoaNota(String nome, double nota1, double nota2) {
        this.nome = nome;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    public PessoaNota() {
    }
}
