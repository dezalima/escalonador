/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Escalonador;


import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author lab803
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args)  throws IOException {
        Scanner entrada = new Scanner(System.in);
        FilaDinamica fila = new FilaDinamica();
        LeituraProcessos lp = new LeituraProcessos();
        Lista lista = lp.Read("processos.txt");

        int quantum, tempo=0;
        int localTime=0;

        do{
        System.out.println("Digite o valor do Quantum");
        quantum = entrada.nextInt();
        }while(quantum<1);
        
        System.out.println("------ESCALONADOR ROUND ROBIN-------\n");
        System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
        System.out.println("         INCIANDO SIMULAÇÃO         ");
        System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
        
        //Verifica se chegou um processo e coloca na fila 
        if(lista.findEqualTime(tempo)){
            while (lista.findEqualTime(tempo)) {
                fila.enqueue(lista.removeFromTime(tempo));
            }
        }
        Processos processoAtual = fila.dequeue();
        
        do{  
            System.out.println("----------TEMPO "+(tempo)+"----------");          
            //Caso de I\O 
            if(!processoAtual.fila.isEmpty() && processoAtual.getDuracao()==(processoAtual.getDuracao_inicial()-processoAtual.fila.peek()) ){
                System.out.println("Evento - [Entrada ou saida de dados] <"+processoAtual.getPID()+">");
                processoAtual.fila.dequeue();
                fila.enqueue(processoAtual);
                processoAtual = fila.dequeue();
                localTime=0;
            }   
            //verifica se algum processo chegou 
            if(!lista.isEmpty()){
                if (lista.findEqualTime(tempo)) {
                    //faz a preenpção do escalonador
                    if (processoAtual.getDuracao()> lista.firstNo.dado.getDuracao()) {
                        fila.enqueue(processoAtual);
                        processoAtual = lista.removeFromTime(tempo);
                        System.out.println("Evento - [Chegada de Processo] <" + processoAtual.getPID() + ">");
                        localTime = 0;
                    } else {
                        Processos processoVariavel = lista.removeFromTime(tempo);
                        System.out.println("Evento - [Chegada de Processo] <" + processoVariavel.getPID() + ">");
                        fila.enqueue(processoVariavel);
                    }
                }
            }
            //Condição de troca
            if(quantum == localTime){
                 System.out.println("Evento - [Fim do Quantum] <"+processoAtual.getPID()+">");
                fila.enqueue(processoAtual);
                processoAtual = fila.dequeue();
                localTime=0;  
            }
            //encerramento do processo
            if(processoAtual.getDuracao()==0){
                System.out.println("Evento - [Encerramento] <"+processoAtual.getPID()+">");
                processoAtual =fila.dequeue();
                localTime=0;
            }
            //Impressão
            if(fila.isEmpty()){
               System.out.println("Não há processos na fila");
             }else{
               System.out.println("Fila: "+fila.show());
             }
            System.out.println("CPU: "+processoAtual.getPID()+"("+processoAtual.getDuracao()+")"); 
            
            processoAtual.Decrementa();
            localTime++;
            tempo++;
        }while(!((fila.isEmpty())&& processoAtual.getDuracao()==0));
        
        //Para imprimir o ultimo tempo
        System.out.println("----------TEMPO "+(tempo)+"----------");
        System.out.println("Evento - [Encerramento] <"+processoAtual.getPID()+">");
        System.out.println("Acabaram os Processos!!!");
        //
        
        System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
        System.out.println("        ENCERRANDO SIMULAÇÃO        ");
        System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
        
    }
    
}



