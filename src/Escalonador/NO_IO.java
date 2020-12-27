/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Escalonador;

/**
 *
 * @author Andrezza01
 */
public class NO_IO {
    protected int dado;
    protected NO_IO nextNo;
    
    public NO_IO(int dd) {
    this.dado = dd;
    this.nextNo = null;
    }
    
    public void setDado(int dado){
    this.dado = dado;
    }
    
    public int getDado(){
    return this.dado;
    }
    
    public void setNextNo(NO_IO nextNo){
    this.nextNo = nextNo;
    }
    
    public NO_IO getNextNo(){
    return this.nextNo;
    }

}
