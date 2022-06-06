/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.vianna.exercicio1.model;

/**
 *
 * @author -
 */
public class Carro {
    
    private EPintura pintura;
    private ETipo tipo;
    private EModelo modelo;
    private EMotor motor;
    private boolean ar, cambio, vidro, alarme, solar, mult, importado;

    public Carro(EPintura pintura, ETipo tipo, EModelo modelo, EMotor motor, boolean ar, boolean cambio, boolean vidro, boolean alarme, boolean solar, boolean mult, boolean importado) {
        this.pintura = pintura;
        this.tipo = tipo;
        this.modelo = modelo;
        this.motor = motor;
        this.ar = ar;
        this.cambio = cambio;
        this.vidro = vidro;
        this.alarme = alarme;
        this.solar = solar;
        this.mult = mult;
        this.importado = importado;
    }

    public boolean isImportado() {
        return importado;
    }

    public void setImportado(boolean importado) {
        this.importado = importado;
    }



    public EMotor getMotor() {
        return motor;
    }

    public void setMotor(EMotor motor) {
        this.motor = motor;
    }

    public ETipo getTipo() {
        return tipo;
    }

    public void setTipo(ETipo tipo) {
        this.tipo = tipo;
    }

    public EModelo getModelo() {
        return modelo;
    }

    public void setModelo(EModelo modelo) {
        this.modelo = modelo;
    }


    public Carro() {
    }

    public EPintura getPintura() {
        return pintura;
    }

    public void setPintura(EPintura pintura) {
        this.pintura = pintura;
    }

    public boolean isAr() {
        return ar;
    }

    public void setAr(boolean ar) {
        this.ar = ar;
    }

    public boolean isCambio() {
        return cambio;
    }

    public void setCambio(boolean cambio) {
        this.cambio = cambio;
    }

    public boolean isVidro() {
        return vidro;
    }

    public void setVidro(boolean vidro) {
        this.vidro = vidro;
    }

    public boolean isAlarme() {
        return alarme;
    }

    public void setAlarme(boolean alarme) {
        this.alarme = alarme;
    }

    public boolean isSolar() {
        return solar;
    }

    public void setSolar(boolean solar) {
        this.solar = solar;
    }

    public boolean isMult() {
        return mult;
    }

    public void setMult(boolean mult) {
        this.mult = mult;
    }
    
}
