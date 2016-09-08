/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.trabalho.T2estrutura;

/**
 *
 * @author usuário
 */
public class Experimento {

    String nome;
    int id = 0;
    static int iterador = 1;
    String resultado;

    public Experimento(String nome) {
        this.nome = nome;
        this.id = iterador++;
    }
}
