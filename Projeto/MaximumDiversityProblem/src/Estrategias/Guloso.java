package Estrategias;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Guloso extends ConstructionStrategy{

    public Guloso(int quantidadeSelecionados) {
        super(quantidadeSelecionados);
    }
    
    @Override
    public void select(int[] solucao, double[][] matriz) {
        int n;
        double soma, maior;
        List<Integer> indicesSelecionados = new ArrayList<>();
        
        for (int i = 0; i < solucao.length; i++) {
            if( solucao[i] == 1 ){
                indicesSelecionados.add( i );
            }
        }
        
        // O primeiro é aleatório.
        n = new Random().nextInt( solucao.length );
        indicesSelecionados.add( n );
        solucao[ n ] = 1;
        
        for (int i = 0; i < super.quantidadeSelecionados-1; i++) {
            maior = 0;
            for (int j = 0; j < matriz.length; j++) {
                soma = 0;
                if( solucao[ j ] != 1 ){
                    for (int k = 0; k < indicesSelecionados.size(); k++) {
                        soma += matriz[ j ][ indicesSelecionados.get( k ) ];                    
                    }
                }
                if( maior < soma ){
                    maior = soma;
                    n = j;
                }
            }
            indicesSelecionados.add( n );
            solucao[ n ] = 1;
        }
    }
    
}
