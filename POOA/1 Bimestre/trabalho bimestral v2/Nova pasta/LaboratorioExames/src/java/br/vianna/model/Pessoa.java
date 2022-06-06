/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.vianna.model;

/**
 *
 * @author Gustavo Botti
 */
public class Pessoa {
    
    private String nome, telefone, endereco;
    private ESexo sexo;
    private EPlano planoSaude;
    private ETipo tipo;
    private int cpf;
    private String login, senha;

    public Pessoa(String nome, String telefone, String endereco, ESexo sexo, EPlano planoSaude, ETipo tipo, int cpf, String login, String senha) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.sexo = sexo;
        this.planoSaude = planoSaude;
        this.tipo = tipo;
        this.cpf = cpf;
        this.login = login;
        this.senha = senha;
    }

    public Pessoa() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public ESexo getSexo() {
        return sexo;
    }

    public void setSexo(ESexo sexo) {
        this.sexo = sexo;
    }

    public EPlano getPlanoSaude() {
        return planoSaude;
    }

    public void setPlanoSaude(EPlano planoSaude) {
        this.planoSaude = planoSaude;
    }

    public ETipo getTipo() {
        return tipo;
    }

    public void setTipo(ETipo tipo) {
        this.tipo = tipo;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
