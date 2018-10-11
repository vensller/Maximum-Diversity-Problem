package Estrategias;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class KGuloso implements EstrategiaSelecao{
    
    private int k;

    public KGuloso(int k) {
        this.k = k;
    }

    @Override
    public void selecionar(List<Integer> indiceSelecionados, boolean[] solucao, double[][] matriz) {
        if( indiceSelecionados.isEmpty() ){
            buscarComMaiorDiferenca( indiceSelecionados, solucao, matriz );
        }else{
            buscarComMaiorDiferencaComRelacaoSolucaoAtual( indiceSelecionados, solucao, matriz );
        }
    }

    private void buscarComMaiorDiferenca(List<Integer> indiceSelecionados, boolean[] solucao, double[][] matriz) {
        int soma, maior = 0, n;
        double[][] somaLinhas = new double[solucao.length][2];
        Random sorteador = new Random();
        
        for (int i = 0; i < matriz.length; i++) {
            soma = 0;
            for (int j = 0; j < matriz[i].length; j++) {
                soma += matriz[i][j];
            }
            somaLinhas[i][0] = i;
            somaLinhas[i][1] = soma;
        }
        
        quickSort(somaLinhas, 0, somaLinhas.length-1);
        
        n = sorteador.nextInt( this.k );
        indiceSelecionados.add( n );
        solucao[ n ] = true;
    }

    private void buscarComMaiorDiferencaComRelacaoSolucaoAtual(List<Integer> indiceSelecionados, boolean[] solucao, double[][] matriz) {
        int soma, maior = 0, n;
        double[][] somaLinhas = new double[solucao.length][2];
        Random sorteador = new Random();
        
        for (int i = 0; i < matriz.length; i++) {
            soma = 0;
            for (int j = 0; j < indiceSelecionados.size(); j++) {
                soma += matriz[ i ][ indiceSelecionados.get( j ) ];                    
            }
            somaLinhas[i][0] = i;
            somaLinhas[i][1] = soma;
        }
        
        quickSort(somaLinhas, 0, somaLinhas.length-1);
        
        n = sorteador.nextInt( this.k );
        indiceSelecionados.add( n );
        solucao[ n ] = true;
    }
    
    private void quickSort(double[][] matriz, int inicio, int fim) {
        if (inicio < fim) {
            int posicaoPivo = separar(matriz, inicio, fim);
            quickSort(matriz, inicio, posicaoPivo - 1);
            quickSort(matriz, posicaoPivo + 1, fim);
        }
    }

    private int separar(double[][] matriz, int inicio, int fim) {
        double indicePivo = matriz[inicio][0];
        double pivo = matriz[inicio][1];
        int i = inicio + 1, f = fim;
        
        while (i <= f) {
            if (matriz[i][1] >= pivo) {
                i++;
            } else if (pivo > matriz[f][1]) {
                f--;
            } else {
                double troca;
                troca = matriz[i][0];
                matriz[i][0] = matriz[f][0];
                matriz[f][0] = troca;
                
                troca = matriz[i][1];
                matriz[i][1] = matriz[f][1];
                matriz[f][1] = troca;
                
                i++;
                f--;
            }
        }
        matriz[inicio][0] = matriz[f][0];
        matriz[f][0] = indicePivo;
        matriz[inicio][1] = matriz[f][1];
        matriz[f][1] = pivo;
        return f;
    }
    
    public static void main(String[] args) {
        List<Integer> indicesSelecionados = new ArrayList<>();
        boolean[] solucao = { false, false, false, false };
        double[][] matriz = { {0,2,4,5}, {2,0,3,1}, {4,3,0,2}, { 5,1,2,0}};
        
        EstrategiaSelecao estrategiaSelecao = new KGuloso(2);
        estrategiaSelecao.selecionar( indicesSelecionados, solucao, matriz );
        estrategiaSelecao.selecionar( indicesSelecionados, solucao, matriz );
        estrategiaSelecao.selecionar( indicesSelecionados, solucao, matriz );
    }
}
