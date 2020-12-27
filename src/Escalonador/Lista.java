package Escalonador;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Andrezza01
 */
public class Lista {

    protected No firstNo;
    protected No lastNo;
    protected int qtdNos;

    public Lista() {
        firstNo = lastNo = null;
        qtdNos = 0;
    }

    public boolean isEmpty() {
        return firstNo == null;
    }

    public void insertAtFront(Processos item) {
        if (isEmpty()) {
            firstNo = lastNo = new No(item);
            qtdNos++;
        } else {
            No node = new No(item);
            node.setNextNo(firstNo);
            firstNo = node;
            qtdNos++;
        }
    }

    public void insertAtBack(Processos item) {
        if (isEmpty()) {
            firstNo = lastNo = new No(item);
            qtdNos++;
        } else {
            lastNo = lastNo.nextNo = new No(item);
            qtdNos++;
        }
    }

    public Processos removeFromFront() {
        if (isEmpty()) {
            return null;
        }

        Processos removedItem = firstNo.getDado();

        if (firstNo == lastNo) {
            firstNo = lastNo = null;
        } else {
            firstNo = firstNo.nextNo;
        }
        qtdNos--;
        return removedItem;
    }

    public Processos removeFromBack() {
        if (isEmpty()) {
            return null;
        }

        Processos removedItem = lastNo.getDado();

        if (firstNo == lastNo) {
            firstNo = lastNo = null;
        } else {
            No current = firstNo;

            while (current.nextNo != lastNo) {
                current = current.nextNo;
            }

            lastNo = current;
            current.nextNo = null;
        }
        qtdNos--;
        return removedItem;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Lista vazia ");
        }

        System.out.print("Dados da lista: ");
        No current = firstNo;

        while (current != null) {
            System.out.print(current.getDado() + " ");
            current = current.nextNo;
        }
        System.out.println("\n");
    }


    public Processos find(Processos item) {
        if (isEmpty()) {
            return null;
        }

        No current = firstNo;
        int pos = 1;
        while (current != null) {
            if (current.getDado() == item) {
                return (current.getDado());
            }
            current = current.nextNo;
            pos++;
        }
        return null;
    }

    public Processos removeFromTime(int time) {
        Processos processos=null;
        if (isEmpty()) {
            return processos;
        } else {
            No current = firstNo;
            while (current != null) {
                if (current.getDado().getChegada() == time) {
                    processos = current.getDado();
                    remove(current.getDado());
                    return processos;
                }
                current = current.getNextNo();
            }
        }
        return processos;
    }

    public boolean remove(Processos item) {
        No current, before;

        if (isEmpty()) {
            return false;
        }

        before = current = firstNo;
        while (current != null && current.getDado() != item) {
            before = current;
            current = current.getNextNo();
        }

        if (current == null) {
            return false;
        }

        if (current == firstNo) {
            removeFromFront();
        } else if (current == lastNo) {
            removeFromBack();
        } else {
            before.setNextNo(current.getNextNo());
        }

        return true;
    }
    
    //Mostrar quando um processo chegou
    public boolean findEqualTime(int time) {
        if (isEmpty()){
            return false;
        }
        No current = firstNo;
        while (current != null) {
            if (current.getDado().getChegada() == time){
               return true; 
            }   
            if(current.getNextNo() == null){
                return false;
            }else{
            current = current.getNextNo();    
            }
            
        }
        return false;
    }
    
     public Processos VerificarProcessoTempo(int time) {
        
         if(findEqualTime(time)){
             
         }
                 No current = firstNo;
        while (current != null) {
            if (current.getDado().getChegada() == time){
               Processos PorcRetorno = current.getDado();
                return PorcRetorno; 
            }   
            if(current.getNextNo() == null){
                break;
            }else{
            current = current.getNextNo();    
            }
            
        }
        Processos ProcNull =null;
        return ProcNull;
               
    }

}
