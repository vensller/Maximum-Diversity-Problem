package Estrategias;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import model.Instancia;

public class KGuloso extends EstrategiaSelecao{
    
    private int k;

    public KGuloso(int quantidadeSelecionados, int k) {
        super(quantidadeSelecionados);
        this.k = k;
    }

    @Override
    public void selecionar( List<Integer> indiceSelecionados, boolean[] solucao ) {
        int soma, n, posicaoPior = 0;
        double[][] KMelhores;
//        double[][] somaLinhas = new double[solucao.length][2];
        Random sorteador = new Random();
        
        // O primeiro é aleatório.
        n = sorteador.nextInt( solucao.length );
        indiceSelecionados.add( n );
        solucao[ n ] = true;
        
        for (int i = 0; i < super.quantidadeSelecionados; i++) {
            // Limpa esse vetor para que o resultados anteriores não interfiram nessa interação.
            KMelhores = new double[ this.k ][ 2 ];
            for (int j = 0; j < Instancia.matriz.length; j++) {
                soma = 0;
                if( !solucao[ j ] ){
                    for (int l = 0; l < indiceSelecionados.size(); l++) {
                        soma += Instancia.matriz[ j ][ indiceSelecionados.get( l ) ];                    
                    }
                    
                    if( soma > KMelhores[ posicaoPior ][ 1 ] ){
                        KMelhores[ posicaoPior ][ 0 ] = j;
                        KMelhores[ posicaoPior ][ 1 ] = soma;
                        double pior = Double.MAX_VALUE;
                        for (int l = 0; l < KMelhores.length; l++) {
                            if( KMelhores[ l ][ 1 ] < pior ){
                                pior = KMelhores[ l ][ 1 ];
                                posicaoPior = l;
                            }
                        }
                    }
                }
                
            }

            int s = sorteador.nextInt( this.k );
            indiceSelecionados.add( (int) KMelhores[s][0] );
            solucao[ (int) KMelhores[s][0] ] = true;
        }
    }   
    
    
    public static void main(String[] args) {
        List<Integer> indicesSelecionados = new ArrayList<>();
        boolean[] solucao = { false, false, false, false };
        double[][] matriz = { {0,2,4,5}, {2,0,3,1}, {4,3,0,2}, { 5,1,2,0}};
        Instancia.matriz = matriz;
        
        EstrategiaSelecao estrategiaSelecao = new KGuloso( 3, 2 );
        estrategiaSelecao.selecionar( indicesSelecionados, solucao );
        
        
        if( soma > KMelhores[ posicaoPior ][ 1 ] ){
            KMelhores[ posicaoPior ][ 0 ] = j;
            KMelhores[ posicaoPior ][ 1 ] = soma;
            double pior = Double.MAX_VALUE;
            for (int l = 0; l < KMelhores.length; l++) {
                if( KMelhores[ l ][ 1 ] < pior ){
                    pior = KMelhores[ l ][ 1 ];
                    posicaoPior = l;
                }
            }
        }

    }
}
