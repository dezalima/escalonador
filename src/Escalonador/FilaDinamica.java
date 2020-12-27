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
public class FilaDinamica {

    private No inicio, fim;

    public FilaDinamica() {
        inicio = fim = null;
    }

    public boolean isEmpty() {
        return (inicio == null);
    }

    public void enqueue(Processos dd) {
        No newNo = new No(dd);
        if (this.inicio == null) {
            this.inicio = this.fim = newNo;
        } else {
            this.fim.nextNo = newNo;
            this.fim = newNo;
        }
    }

    public Processos dequeue() {
        if (isEmpty()) {
            return null;
        }
        No temp = inicio;
        inicio = inicio.nextNo;
        if (inicio == null) {
            fim = null;
        }
        return temp.getDado();
    }

    //Precisa mudar o metodo?
    public String show() {
        String saida = "";
        if (isEmpty()) {
            return saida;
        } else {
            No atual = inicio;
            while (atual != null) {
                saida += atual.getDado().getPID() + "(" + atual.getDado().getDuracao() + ")";
                atual = atual.nextNo;
            }
            return (saida);
        }
    }

    public int size() {
        int cont = 0;
        No atual = inicio;
        while (atual != null) {
            cont++;
            atual = atual.nextNo;
        }
        return cont;
    }

    public Processos peek() {
        return (inicio.getDado());
    }
}
