/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.trabalho.T2estrutura;

/**
 *
 * @author higor.chaves
 */
public class Lista {

    No ini;
    No fim;

    public Lista() {
        ini = null;
        fim = null;
    }

    public void adicionar(No no) {
        if (ini == null) {
            ini = no;
            fim = no;
            no.prox = ini;
            no.ant = fim;
        } else {
            fim.prox = no;
            no.ant = fim;
            no.prox = ini;
            fim = no;
        }
    }

    public No remover(int id) {
        if (ini == null) {
            System.out.println("Lista Vazia!");
            return null;
        }
        No aux = ini;
        No maior = null;
        while (aux.prox != fim) {
            if (aux.elemento.id == id) {
                maior = aux;
                break;
            }
            aux = aux.prox;
        }
        if (aux.elemento.id == id) {
            maior = aux;
        }
        if (maior!=null){
            if (maior == fim) {
                if (fim == ini) {
                    ini = null;
                    fim = null;
                } else {
                    maior.ant.prox = ini;
                    fim = maior.ant;
                    maior.ant = null;
                    maior.prox = null;
                }
            } else if (maior == ini) {
                maior.prox.ant = fim;
                ini = maior.prox;
                fim.ant = ini;
                maior.prox = null;
                maior.ant = null;
            } else {
                maior.prox.ant = maior.ant;
                maior.ant.prox = maior.prox;
                maior.ant = null;
                maior.prox = null;
            }
        }
        return maior;
    }

    @Override
    public String toString() {

        StringBuilder s = new StringBuilder();
        s.append("[");

        if (ini != null) {
            No aux = ini;
            s.append(aux.info);
            while (aux.prox != ini) {
                aux = aux.prox;
                s.append(", " + aux.info);
            }
        }

        s.append("]");

        return s.toString();
    }

    public boolean EstaVazia() {
        return ini == null;
    }

}
