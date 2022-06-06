/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.vianna.todo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Gustavo Botti
 */
@Entity
//@Table(name = "tb_user")
public class Usuario {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(length = 50, nullable = false)
    private String nome;
    
    @Column(length = 50, nullable = false)
    private String telefone;
    
    @Column(length = 150, nullable = false)
    private String endereco;
    
    @Column(length = 50, nullable = false)
    private String sexo;
    
    @Column(length = 50, nullable = false)
    private String planoSaude;
    
    @Column(length = 50, nullable = false)
    private int tipo;
    
    @Column(length = 50, nullable = false, unique = true)
    private int cpf;
    
    @Column(length = 60, nullable = false)
    private String senha;
    
    @Column(nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUltimoAcesso;
    
    @OneToMany(mappedBy="usuario")
    private List<Exame> exames;

    public Usuario() {
        exames = new ArrayList<>();
    }

    public Usuario(int id, String nome, String telefone, String endereco, String sexo, String planoSaude, int tipo, int cpf, String senha, Date dataUltimoAcesso) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.sexo = sexo;
        this.planoSaude = planoSaude;
        this.tipo = tipo;
        this.cpf = cpf;
        this.senha = senha;
        this.dataUltimoAcesso = dataUltimoAcesso;
        exames = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getPlanoSaude() {
        return planoSaude;
    }

    public void setPlanoSaude(String planoSaude) {
        this.planoSaude = planoSaude;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }    

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getDataUltimoAcesso() {
        return dataUltimoAcesso;
    }

    public void setDataUltimoAcesso(Date dataUltimoAcesso) {
        this.dataUltimoAcesso = dataUltimoAcesso;
    }

    public List<Exame> getExames() {
        return exames;
    }

    public void setExames(List<Exame> exames) {
        this.exames = exames;
    }

    
    
    
}
