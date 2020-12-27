/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Escalonador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Andrezza01
 */
public class LeituraProcessos {

    
    public Lista Read(String caminho) throws IOException {
        
        File arquivo = new File(caminho);
        Lista lista = new Lista();
        if (arquivo.exists()) {
            if (arquivo.isFile()) {
                FileReader leitura = new FileReader(caminho);
                BufferedReader bfLeitura = new BufferedReader(leitura);

                while (bfLeitura.ready()) {
                    Processos pro = new Processos();
                    String str = bfLeitura.readLine();
                    String[] s = str.split(" ");
                    String[] q = null;


                    if (str.contains(",")) {

                        pro.setPID(s[0]);
                        pro.setDuracao(Integer.parseInt(s[1])); 
                        pro.setDuracao_inicial(Integer.parseInt(s[1]));
                        pro.setChegada(Integer.parseInt(s[2])); 
                        q = s[s.length - 1].split(",");
                        for (int i = 0; i < q.length; i++) {
                            pro.fila.enqueue(Integer.parseInt(q[i]));
                        }
                        lista.insertAtBack(pro);
                    } else if (s.length == 4) {

                        pro.setPID(s[0]);
                        pro.setDuracao(Integer.parseInt(s[1])); 
                        pro.setDuracao_inicial(Integer.parseInt(s[1]));
                        pro.setChegada(Integer.parseInt(s[2])); 
                        pro.fila.enqueue(Integer.parseInt(s[3]));
                        lista.insertAtBack(pro);
                    } else {

                        pro.setPID(s[0]);
                        pro.setDuracao(Integer.parseInt(s[1])); 
                        pro.setDuracao_inicial(Integer.parseInt(s[1]));
                        pro.setChegada(Integer.parseInt(s[2])); 
                        lista.insertAtBack(pro);
                    }
                   
                }//while 
                leitura.close();
                bfLeitura.close();
            } else {
                System.out.println("Nao existe arquivo com este nome");
            }
        }//if principal
        return lista;
    }
}
