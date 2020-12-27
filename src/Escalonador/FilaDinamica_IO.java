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
public class FilaDinamica_IO {

    protected NO_IO inicio, fim;

    public FilaDinamica_IO() {
        inicio = fim = null;
    }

    public boolean isEmpty() {
        return (inicio == null);
    }

    public void enqueue(int dd) {
        NO_IO newNo = new NO_IO(dd);
        if (this.inicio == null) {
            this.inicio = this.fim = newNo;
        } else {
            //mudei
            this.fim.nextNo = newNo; 
            this.fim = newNo;
            
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            return 0;
        }
        NO_IO temp = inicio;
        inicio = inicio.nextNo;
        if (inicio == null) {
            fim = null;
        }
        return temp.getDado();
    }

    public String show() {
        String saida = "";
        if (isEmpty()) {
            return saida;
        } else {
            NO_IO atual = inicio;
            while (atual != null) {
                saida += atual.getDado() + " ";
                atual = atual.nextNo;
            }
            return (saida);
        }
    }

    public int size() {
        int cont = 0;
        NO_IO atual = inicio;
        while (atual != null) {
            cont++;
            atual = atual.nextNo;
        }
        return cont;
    }

    public int peek() {
        return (inicio.getDado());
    }

}
