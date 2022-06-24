package com.example.appmedidas.model;

public class Pessoa {

    private String nome;
    private double peso, altura;
    private int idade;

    public double imc(){
        return peso/(altura*altura);
    }

    public String resultado(){
        double valor = imc();
        if (valor <= 18.5){
            return "Abaixo do peso";
        }else if (valor <= 24.9){
            return "Normal";
        }else if (valor <= 29.9){
            return "Sobrepeso";
        }else{
            return "Obeso";
        }
    }

    public Pessoa() {
    }

    public Pessoa(String nome, double peso, double altura, int idade) {
        this.nome = nome;
        this.peso = peso;
        this.altura = altura;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}