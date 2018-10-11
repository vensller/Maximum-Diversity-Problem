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
//        if( indiceSelecionados.isEmpty() ){
//            buscarComMaiorDiferenca( indiceSelecionados, solucao, matriz );
//        }else{
//            buscarComMaiorDiferencaComRelacaoSolucaoAtual( indiceSelecionados, solucao, matriz );
//        }
        int soma, n;
        double[][] somaLinhas = new double[solucao.length][2];
        Random sorteador = new Random();
        
        for (int i = 0; i < matriz.length; i++) {
            soma = 0;
            if( indiceSelecionados.isEmpty() ){
                for (int j = 0; j < matriz[i].length; j++) {
                    soma += matriz[i][j];
                }
            }else{
                if( !solucao[ i ] ){
                    for (int j = 0; j < indiceSelecionados.size(); j++) {
                        soma += matriz[ i ][ indiceSelecionados.get( j ) ];                    
                    }
                }
            }
            
            somaLinhas[i][0] = i;
            somaLinhas[i][1] = soma;
        }
        
        QuickSort.ordenar(somaLinhas, 0, somaLinhas.length-1);
        
        n = sorteador.nextInt( this.k );
        indiceSelecionados.add( n );
        solucao[ n ] = true;
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
        
        QuickSort.ordenar(somaLinhas, 0, somaLinhas.length-1);
        
        n = sorteador.nextInt( this.k );
        n = (int) somaLinhas[n][0];
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
        
        QuickSort.ordenar(somaLinhas, 0, somaLinhas.length-1);
        
        n = sorteador.nextInt( this.k );
        indiceSelecionados.add( n );
        solucao[ n ] = true;
    }
    
    
    
//    public static void main(String[] args) {
//        List<Integer> indicesSelecionados = new ArrayList<>();
//        boolean[] solucao = { false, false, false, false };
//        double[][] matriz = { {0,2,4,5}, {2,0,3,1}, {4,3,0,2}, { 5,1,2,0}};
//        
//        EstrategiaSelecao estrategiaSelecao = new KGuloso(2);
//        estrategiaSelecao.selecionar( indicesSelecionados, solucao, matriz );
//        estrategiaSelecao.selecionar( indicesSelecionados, solucao, matriz );
//        estrategiaSelecao.selecionar( indicesSelecionados, solucao, matriz );
//    }
}
