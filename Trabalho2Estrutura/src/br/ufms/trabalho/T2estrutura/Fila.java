/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.trabalho.T2estrutura;

/**
 *
 * @author PC
 */
public class Fila {
    
    static Cientista[] vetorCientistas;
    static int ini=-1;
    static int fim=-1;
    
    public static void DefinirTamanhoFila(int tamanho) {
        vetorCientistas = new Cientista[tamanho];
        ini=-1;
        fim=-1;
    }
    
    public static void Enfileirar(Cientista c){
        if (fim<vetorCientistas.length-1){
            if (ini==-1){
                ini++;
            }
            fim++;
            vetorCientistas[fim] = c;
        } else {
            System.out.println("Fila cheia!");
        }
    }
    
    public static boolean TemEspaco(){
        return fim<vetorCientistas.length-1;
    }
    
    public static Cientista Desenfileirar(){
        if (!EstaVazia()){
            Cientista c;
            c=vetorCientistas[0];
            if (fim==ini){
                ini--;
            } else {
                for (int i=0;i<fim;i++){
                    vetorCientistas[i]=vetorCientistas[i+1];
                }
            }
            fim--;
            return c;
        } else {
            System.out.println("Fila Vazia!");
            return null;
        }
    }
    
    public static boolean EstaVazia(){
        return ini==-1;
    }
    
}
