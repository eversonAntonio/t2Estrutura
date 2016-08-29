/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.trabalho.estrutura.listaResultado;

/**
 *
 * @author PC
 */
public class ListaResultados {

    public No no;
    public No ini = null;
    public No fim = null;

    public void Adicionar(No no) {
        if (ini == null && fim == null) {
            this.no = no;
            ini = no;
            fim = no;
            no.prox = no;
            no.ante = no;
        } else {
            fim.prox = no;
            ini.ante = no;
            no.ante = fim;
            no.prox = ini;
            fim = no;
        }
    }

}
