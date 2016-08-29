/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufms.trabalho.estrutura;

/**
 *
 * @author usuário
 */
public class Experimentos {

    public Experimentos[] Experimentospilha = new Experimentos[1000];
    int numeroIdentificacao;
    String nomeExperimento, resultado;
    //o indice do vetor começa em 0, se ta em -1 é pq esta vazio o vetor
    public int posicaoPilha = -1;

    public boolean pilhaVazia() {
        //isEmpty
        if (this.posicaoPilha == -1) {
            return true;
        }
        return false;
    }

    public void empilhar(int numeroIdentificacao, String nomeExperimento, String resultado) {
        // push
        if (this.posicaoPilha < this.Experimentospilha.length - 1) {
            Experimentos experimentos = new Experimentos();
            experimentos.nomeExperimento = nomeExperimento;
            experimentos.numeroIdentificacao = numeroIdentificacao;
            experimentos.resultado = resultado;
            this.Experimentospilha[++posicaoPilha] = experimentos;
        }
    }

}
