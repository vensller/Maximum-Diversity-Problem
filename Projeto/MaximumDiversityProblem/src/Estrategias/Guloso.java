package Estrategias;

import java.util.ArrayList;
import java.util.List;

public class Guloso{
    
     
     public void selecionar( List<Integer> indicesSelecionados, boolean[] solucao, double[][] matriz ){        
        if( indicesSelecionados.isEmpty() ){
            buscarComMaiorDiferenca( indicesSelecionados, solucao, matriz );
        }else{
            buscarComMaiorDiferencaComRelacaoSolucaoAtual( indicesSelecionados, solucao, matriz );
        }
    }

    private void buscarComMaiorDiferenca( List<Integer> indicesSelecionados, boolean[] solucao, double[][] matriz) {
        int soma, maior = 0, n = -1;
        for (int i = 0; i < matriz.length; i++) {
            soma = 0;
            for (int j = 0; j < matriz[ i ].length; j++) {
                soma += matriz[i][j];
            }
            if( maior < soma ){
                maior = soma;
                n = i;
            }
        }
        indicesSelecionados.add( n );
        solucao[ n ] = true;
    }

    private void buscarComMaiorDiferencaComRelacaoSolucaoAtual( List<Integer> indicesSelecionados, boolean[] solucao, double[][] matriz) {
        int soma, maior = 0, n = -1;
        for (int i = 0; i < matriz.length; i++) {
            if( !solucao[ i ] ){
                soma = 0;
                for (int j = 0; j < indicesSelecionados.size(); j++) {
                    soma += matriz[ i ][ indicesSelecionados.get(j) ];
                }
                if( maior < soma ){
                    maior = soma;
                    n = i;
                }
            }
        }
        indicesSelecionados.add( n );
        solucao[ n ] = true;
    }
    
     public static void main(String[] args) {
        List<Integer> indicesSelecionados = new ArrayList<>();
        boolean[] solucao = { false, false, false, false };
        double[][] matriz = { {0,2,4,5}, {2,0,3,1}, {4,3,0,2}, { 5,1,2,0}};
        
//        SelectionStrategy estrategiaSelecao = new Guloso();
//        estrategiaSelecao.selecionar( indicesSelecionados, solucao, matriz );
//        estrategiaSelecao.selecionar( indicesSelecionados, solucao, matriz );
//        estrategiaSelecao.selecionar( indicesSelecionados, solucao, matriz );
        
    }
}
