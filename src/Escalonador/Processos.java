/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Escalonador;



/**
 *
 * @author lab803
 */
public class Processos {
    private String PID;
    private int duracao, chegada;
    private int duracao_inicial;
    FilaDinamica_IO fila = new FilaDinamica_IO ();


    public Processos() {}
    
    public Processos(String PID, int duracao, int chegada, int duracao_inicial) {
        this.PID = PID;
        this.duracao = duracao;
        this.chegada = chegada;
        this.duracao_inicial = duracao_inicial;
    }
    
    public int getDuracao_inicial() {
        return duracao_inicial;
    }

    public void setDuracao_inicial(int duracao_inicial) {
        this.duracao_inicial = duracao_inicial;
    }
    
    public String getPID() {
        return PID;
    }

    public void setPID(String PID) {
        this.PID = PID;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public int getChegada() {
        return chegada;
    }

    public void setChegada(int chegada) {
        this.chegada = chegada;
    }
    //metodo que faz a decrementação 
     public void Decrementa(){
        this.duracao--;
    }

}