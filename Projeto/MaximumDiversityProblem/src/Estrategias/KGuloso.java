package Estrategias;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class KGuloso extends ConstructionStrategy{
    
    private int k;
    private int kParam;

    public KGuloso(int quantidadeSelecionados, int k) {
        super(quantidadeSelecionados);
        this.kParam = k;
    }
    
    @Override
    public void select(int[] solucao, double[][] matriz) {
        
        double d = ( (double) this.kParam / 100) * matriz.length;
        this.k =  (int) Math.ceil( d );
        int soma, n, posicaoPior;
        double[][] kMelhores;
        Random sorteador = new Random();
        List<Integer> indicesSelecionados = new ArrayList<>();
        
        for (int i = 0; i < solucao.length; i++) {
            if( solucao[i] == 1 ){
                indicesSelecionados.add( i );
            }
        }
        
        // O primeiro é aleatório.
        n = sorteador.nextInt( solucao.length );
        indicesSelecionados.add( n );
        solucao[ n ] = 1;
        
        for (int i = 0; i < super.quantidadeSelecionados-1; i++) {
            // Limpa esse vetor para que o resultados anteriores não interfiram nessa interação.
            kMelhores = new double[ this.k ][ 2 ];
            posicaoPior = 0;
            
            for (int j = 0; j < matriz.length; j++) {
                soma = 0;
                if( solucao[ j ] != 1 ){
                    for (int l = 0; l < indicesSelecionados.size(); l++) {
                        soma += matriz[ j ][ indicesSelecionados.get( l ) ];                    
                    }
                    
                    if( soma > kMelhores[ posicaoPior ][ 1 ] ){
                        kMelhores[ posicaoPior ][ 0 ] = j;
                        kMelhores[ posicaoPior ][ 1 ] = soma;
                        double pior = Double.MAX_VALUE;
                        for (int l = 0; l < kMelhores.length; l++) {
                            if( kMelhores[ l ][ 1 ] < pior ){
                                pior = kMelhores[ l ][ 1 ];
                                posicaoPior = l;
                            }
                        }
                    }
                }
                
            }

            n = sorteador.nextInt( this.k );
            indicesSelecionados.add( (int) kMelhores[n][0] );
            solucao[ (int) kMelhores[n][0] ] = 1;
        }
    }

}
