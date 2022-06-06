/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.exercicio3.model;

/**
 *
 * @author Botti
 */
public class Pessoa {
           
    private int cpf, idade, altura;
    private EOlhos olhos;
    private ECabelos cabelos;
    private ESexo sexo;

    public Pessoa() {
    }

    public Pessoa(int cpf, int idade, int altura, EOlhos olhos, ECabelos cabelos, ESexo sexo) {
        this.cpf = cpf;
        this.idade = idade;
        this.altura = altura;
        this.olhos = olhos;
        this.cabelos = cabelos;
        this.sexo = sexo;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public EOlhos getOlhos() {
        return olhos;
    }

    public void setOlhos(EOlhos olhos) {
        this.olhos = olhos;
    }

    public ECabelos getCabelos() {
        return cabelos;
    }

    public void setCabelos(ECabelos cabelos) {
        this.cabelos = cabelos;
    }

    public ESexo getSexo() {
        return sexo;
    }

    public void setSexo(ESexo sexo) {
        this.sexo = sexo;
    }
    
    
}
