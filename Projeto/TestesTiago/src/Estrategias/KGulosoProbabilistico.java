package Estrategias;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class KGulosoProbabilistico implements EstrategiaSelecao{
    
    private int k;

    public KGulosoProbabilistico(int k) {
        this.k = k;
    }

    @Override
    public void selecionar(List<Integer> indiceSelecionados, boolean[] solucao, double[][] matriz) {
        int soma, n = -1;
        double somaPesos = 0, somatorioPesos = 0;
        double[][] somaLinhas = new double[solucao.length][4];
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
        
        for (int i = 0; i < this.k; i++) {
            somaPesos += somaLinhas[i][1];
        }
        for (int i = 0; i < this.k; i++) {
            somaLinhas[i][2] = somaLinhas[i][1] / somaPesos;
            somatorioPesos += somaLinhas[i][2];
            somaLinhas[i][3] = somatorioPesos;
        }
        
        double s = sorteador.nextDouble();
        for (int i = 0; i < k; i++) {
            if( s <= somaLinhas[i][3] ){
                n = (int) somaLinhas[i][0];
                break;
            }
        }
        indiceSelecionados.add( n );
        solucao[ n ] = true;
    }
    
    public static void main(String[] args) {
        List<Integer> indicesSelecionados = new ArrayList<>();
        boolean[] solucao = { false, false, false, false };
        double[][] matriz = { {0,2,4,5}, {2,0,3,1}, {4,3,0,2}, { 5,1,2,0}};
        
        EstrategiaSelecao estrategiaSelecao = new KGulosoProbabilistico(2);
        estrategiaSelecao.selecionar( indicesSelecionados, solucao, matriz );
        estrategiaSelecao.selecionar( indicesSelecionados, solucao, matriz );
        estrategiaSelecao.selecionar( indicesSelecionados, solucao, matriz );
    }
}
