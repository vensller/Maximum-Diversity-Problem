package Estrategias;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Aleatorio{
        
    public void selecionar( List<Integer> indiceSelecionados, boolean[] solucao, double[][] matriz ){
        int n;
        Random sorteador = new Random();
        do{
            n = sorteador.nextInt( solucao.length );
        }while( solucao[ n ] );
        indiceSelecionados.add( n );
        solucao[ n ] = true;
    }
    
    public static void main(String[] args) {
        List<Integer> indicesSelecionados = new ArrayList<>();
        boolean[] solucao = { false, false, false };
        double[][] matriz = { {0,2,4}, {2,0,3}, {4,3,0}};
        
//        SelectionStrategy estrategiaSelecao = new Aleatorio();
//        estrategiaSelecao.selecionar(indicesSelecionados, solucao, matriz);
//        estrategiaSelecao.selecionar(indicesSelecionados, solucao, matriz);
        
    }
}
