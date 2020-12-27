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
public class No {

    protected Processos dado;
    protected No nextNo;

    public No(Processos dd) {
        this.dado = dd;
        this.nextNo = null;
    }

    public void setDado(Processos dado) {
        this.dado = dado;
    }

    public Processos getDado() {
        return this.dado;
    }

    public void setNextNo(No nextNo) {
        this.nextNo = nextNo;
    }

    public No getNextNo() {
        return this.nextNo;
    }

}
