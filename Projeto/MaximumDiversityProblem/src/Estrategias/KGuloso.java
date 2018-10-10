package Estrategias;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class KGuloso implements EstrategiaSelecao {

    private int k;

    public KGuloso(int k) {
        this.k = k;
    }

    public static void main(String[] args) {

        List<Integer> indicesSelecionados = new ArrayList<>();
        boolean[] solucao = {false, false, false, false};
        double[][] matriz = {{0, 2, 4, 5}, {2, 0, 3, 1}, {4, 3, 0, 2}, {5, 1, 2, 0}};

        //Instanciando a estratégia, escolhendo o K-Guloso passando 2 como k elementos
        EstrategiaSelecao estrategiaSelecao = new KGuloso(2);
        estrategiaSelecao.selecionar(indicesSelecionados, solucao, matriz);

    }

    @Override
    public void selecionar(List<Integer> indiceSelecionados, boolean[] solucao, double[][] matriz) {

        if (indiceSelecionados.isEmpty()) {
            // precisa ser escolhido o primeiro elemento da solução
            selecionarMaiorDiferenca(indiceSelecionados, solucao, matriz);
        } else {
            // primeiro elemento ja foi escolhido
        }

    }

    private void selecionarMaiorDiferenca(List<Integer> indiceSelecionados, boolean[] solucao, double[][] matriz) {

        /*
        * Etapas
            - Obter a soma de cada linha
            - Selecionar os índices (de acordo com 'k') das linhas que possuem maior soma
            - Escolher aleatoriamente um dos índices e colocar no vetor 'solucao' o valor 'true' na posição correspondente ao índice escolhido
         */
        int soma;
        HashMap<Integer, Integer> somatorioLinhasComIndices = new HashMap<>();
        HashMap<Integer, Integer> kElementosEscolhidos = new HashMap<>();

        // Obtendo soma de cada linha
        for (int i = 0; i < matriz.length; i++) {
            soma = 0;
            if (!solucao[i]) {
                for (int j = 0; j < matriz[i].length; j++) {
                    soma += matriz[i][j];
                }
                //Adicionando em um Hashmap a soma obtida com o índice da linha
                somatorioLinhasComIndices.put(i, soma);
            }
        }                

        // Selecionandos os índices de acordo com 'k'
        for (int i = 0; i < this.k; i++) {

            int valorMaior = 0;
            int indiceValorMaior = -1;
            for (int j = 0; j < somatorioLinhasComIndices.size(); j++) {

                //Verifico se, de acordo com o índice 'J', já existe este indice cadastrado
                //No Hashmap de kElementosEscolhidos
                if (!kElementosEscolhidos.containsKey(j) && somatorioLinhasComIndices.get(j) > valorMaior) {
                    valorMaior = somatorioLinhasComIndices.get(j);
                    indiceValorMaior = j;
                }
            }

            // removendo a linha cujo a soma já foi calculada            
            kElementosEscolhidos.put(indiceValorMaior, valorMaior);

        }

        // Escolher aleatoriamente um dos índices...        
        int posicaoAleatoria = new Random().nextInt(kElementosEscolhidos.size() - 1) * 10;
        System.out.println("Posição aleatória: " + posicaoAleatoria);

        // Gravar no vetor de 'solucao' o valor 'true' ...
        solucao[posicaoAleatoria] = true;

    }

}
