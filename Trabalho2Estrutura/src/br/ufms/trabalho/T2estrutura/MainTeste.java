/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.trabalho.T2estrutura;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author usuário
 */
public class MainTeste {

    public static void main(String[] args) throws IOException {
        Scanner opcao = new Scanner(System.in);
        String valor;
        int topo = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Lista listaResultados = new Lista();
        boolean valida = true;

        while (valida) {
            System.out.println("Digite o tamanho da pilha");
            try {
                int tamanho = Integer.parseInt(br.readLine());
                valida = false;
                Pilha.definirTamanhoPilha(tamanho);
            } catch (IOException | NumberFormatException e) {
                System.out.println(e.getMessage() + " defina um valor valido");
            }
        }

        while (true) {
            System.out.println("1-empilhar um experimento\n"
                    + "2-desempilhar um experimento\n"
                    + "3-Fazer um experimento\n"
                    + "4-Enfileirar cientista\n"
                    + "5-Desenfileirar cientista\n"
                    + "6-Entregar um experimento para o primeiro cientista da fila\n"
                    + "0-Sair");
            valor = opcao.nextLine();
            try {
                int var = Integer.parseInt(valor);
                switch (var) {
                    case 1:
                        try {
                            if (Pilha.EstaCheia()) {
                                System.out.println("A pilha esta cheia");
                            } else {
                                System.out.println("DIGITE O NOME DO EXPERIMENTO");
                                String nomeExperimento = br.readLine();
                                Experimento experimentos = new Experimento(nomeExperimento);
                                Pilha.empilhar(experimentos);
                            }
                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 2:
                        try {
                            Pilha.desempilhar();
                        } catch (ArrayIndexOutOfBoundsException | IOException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 3:
                        if (!Pilha.EstaVazia()) {
                            Experimento e = Pilha.desempilhar();
                            No no = new No();
                            no.elemento = e;
                            listaResultados.adicionar(no);
                        } else {
                            System.out.println("Pilha Vazia!");
                        }
                        break;
                    case 4:
                        if (Fila.vetorCientistas == null) {
                            System.out.print("Digite o tamanho da fila: ");
                            Fila.DefinirTamanhoFila(Integer.parseInt(br.readLine()));
                        }
                        if (Fila.TemEspaco()) {
                            Cientista c = new Cientista();
                            System.out.print("Digite o nome do cientista: ");
                            c.nome = br.readLine();
                            Fila.Enfileirar(c);
                        } else {
                            System.out.println("Fila cheia!");
                        }
                        break;
                    case 5:
                        Cientista c = Fila.Desenfileirar();
                        if (c != null) {
                            System.out.println(c.nome);
                        }
                        break;
                    case 6:
                        if (Fila.EstaVazia()) {
                            System.out.println("Fila Vazia!");
                        } else if (listaResultados.EstaVazia()) {
                            System.out.println("Lista Vazia!");
                        } else {
                            try {
                                System.out.print("Digite o numero do experimento: ");
                                No removido = listaResultados.remover(Integer.parseInt(br.readLine()));
                                if (removido == null) {
                                    System.out.println("Experimento não consta na lista.");
                                } else {
                                    Cientista carinha = Fila.Desenfileirar();
                                    carinha.experimento = removido.elemento;
                                    System.out.println("Cientista " + carinha.nome
                                            + " recebeu o experimento " + carinha.experimento.nome
                                            + " que foi um " + carinha.experimento.resultado + ".");
                                }
                            } catch (Exception ex) {
                                System.out.println("Valor inválido!");
                            }
                        }
                        break;
                    case 0:
                        System.exit(0);
                    default:
                        System.out.println("opcao invalida");
                        break;
                }
            } catch (Exception ex) {
                System.out.println("opcao invalida");
            }
        }
    }
}
