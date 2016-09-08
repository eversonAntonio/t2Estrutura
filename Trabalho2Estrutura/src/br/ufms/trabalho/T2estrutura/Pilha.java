/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.trabalho.T2estrutura;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author usuário
 */
public class Pilha {

    static Experimento[] Vetorexperimento;
    static int topo = 0;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String resultado;

    public static void definirTamanhoPilha(int tamanho) {
        Vetorexperimento = new Experimento[tamanho];
    }

    public int tamanhoTopo() {
        return topo;
    }

    public static boolean EstaCheia() {
        return topo == Vetorexperimento.length;
    }

    static void empilhar(Experimento experimentos) throws ArrayIndexOutOfBoundsException, IOException {
        if (topo + 1 <= Vetorexperimento.length) {
            Pilha.Vetorexperimento[topo] = experimentos;
            ++topo;
        } else {
            System.out.println("----------------------");
            throw new ArrayIndexOutOfBoundsException(" A Pilha esta cheia");
        }
    }

    static public Experimento desempilhar() throws ArrayIndexOutOfBoundsException, IOException {
        if (topo > 0) {
            --topo;
            /*
            AQUI DESEMPILHA O EXPERIMENTO E JA PEDE PRO "ASTRONAUTA" INSERIR O RESULTADO
             */
            System.out.println("INFORME O RESULTADO");
            resultado = br.readLine();
            Vetorexperimento[topo].resultado = resultado;
            return Vetorexperimento[topo];
        } else {
            throw new ArrayIndexOutOfBoundsException("A PILHA ESTA VAZIA");
        }
    }

    public static boolean EstaVazia() {
        return topo == 0;
    }
}
