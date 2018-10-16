package Estrategias;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class KGuloso {

    private int k;

    public KGuloso(int k) {
        this.k = k;
    }

    public static void main(String[] args) {

        List<Integer> indicesSelecionados = new ArrayList<>();
        boolean[] solucao = {false, false, false, false};
        double[][] matriz = {{0, 2, 4, 5}, {2, 0, 3, 1}, {4, 3, 0, 2}, {5, 1, 2, 0}};

        //Instanciando a estratégia, escolhendo o K-Guloso passando 2 como k elementos
//        SelectionStrategy estrategiaSelecao = new KGuloso(2);
//        estrategiaSelecao.selecionar(indicesSelecionados, solucao, matriz);

    }

    
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
        Map<Integer, Integer> somatorioLinhasComIndices = new HashMap<>();
        List<Integer> kElementosEscolhidos = new ArrayList<>();        

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

        // Criando uma lista com os índices organizados pelo seu respectivo valor de forma crescente
        List<Integer> indicesOrganizados = new ArrayList<>();
        organizarMapPorValor(somatorioLinhasComIndices).forEach((entry) -> {
            indicesOrganizados.add(entry.getKey());
        });

        // Escolhendo os 'k' elementos mais dispersos (pegando os 'k' elementos do final da lista)
        for(int i = 1; i <= this.k; i++){
            kElementosEscolhidos.add(indicesOrganizados.get(indicesOrganizados.size() - i));
        }

        // Escolher aleatoriamente um dos índices...        
        int posicaoAleatoria = (int) ((Math.random() * kElementosEscolhidos.size()));        

        // Gravar no vetor de 'solucao' o valor 'true' ...
        solucao[posicaoAleatoria] = true;
        indiceSelecionados.add(posicaoAleatoria);
    }

    /*
    * Método que orgniza o Map em ordem crescente
     */
    private <K, V extends Comparable<? super V>> SortedSet<Map.Entry<K, V>> organizarMapPorValor(Map<K, V> map) {
        SortedSet<Map.Entry<K, V>> sortedEntries = new TreeSet<>((Map.Entry<K, V> e1, Map.Entry<K, V> e2) -> {
            int res = e1.getValue().compareTo(e2.getValue());
            return res != 0 ? res : 1;
        });
        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
    }

}
