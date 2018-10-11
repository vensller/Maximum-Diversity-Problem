package Estrategias;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AlfaGuloso implements EstrategiaSelecao{

    private double alfa;

    public AlfaGuloso(double alfa) {
        this.alfa = alfa;
    }
    
    @Override
    public void selecionar(List<Integer> indiceSelecionados, boolean[] solucao, double[][] matriz) {
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
        
        n = sorteador.nextInt( (int) Math.floor(solucao.length * alfa) );
        n = (int) somaLinhas[n][0];
        indiceSelecionados.add( n );
        solucao[ n ] = true;
    }
    
    
        public static void main(String[] args) {
        List<Integer> indicesSelecionados = new ArrayList<>();
        boolean[] solucao = { false, false, false, false };
        double[][] matriz = { {0,2,4,5}, {2,0,3,1}, {4,3,0,2}, { 5,1,2,0}};
        
        EstrategiaSelecao estrategiaSelecao = new AlfaGuloso(0.3);
        estrategiaSelecao.selecionar( indicesSelecionados, solucao, matriz );
        estrategiaSelecao.selecionar( indicesSelecionados, solucao, matriz );
        estrategiaSelecao.selecionar( indicesSelecionados, solucao, matriz );
    }

}
