package Estrategias;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import model.Instancia;

public class AlfaGuloso extends EstrategiaSelecao{

    private double alfa;

    public AlfaGuloso(int quantidadeSelecionados, double alfa) {
        super(quantidadeSelecionados);
        this.alfa = alfa;
    }
    
    @Override
    public void selecionar(List<Integer> indiceSelecionados, boolean[] solucao ) {
        int soma, n;
        double[][] somaLinhas = new double[solucao.length][2];
        Random sorteador = new Random();
        
        for (int i = 0; i < Instancia.matriz.length; i++) {
            soma = 0;
            if( indiceSelecionados.isEmpty() ){
                for (int j = 0; j < Instancia.matriz[i].length; j++) {
                    soma += Instancia.matriz[i][j];
                }
            }else{
                if( !solucao[ i ] ){
                    for (int j = 0; j < indiceSelecionados.size(); j++) {
                        soma += Instancia.matriz[ i ][ indiceSelecionados.get( j ) ];                    
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
        
        EstrategiaSelecao estrategiaSelecao = new AlfaGuloso(3, 0.3);
        estrategiaSelecao.selecionar( indicesSelecionados, solucao );
    }

}
