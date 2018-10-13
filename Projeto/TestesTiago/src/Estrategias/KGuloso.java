package Estrategias;

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
        int soma, n, posicaoPior;
        double[][] kMelhores;
        Random sorteador = new Random();
        
        // O primeiro é aleatório.
        n = sorteador.nextInt( solucao.length );
        indiceSelecionados.add( n );
        solucao[ n ] = true;
        
        for (int i = 0; i < super.quantidadeSelecionados-1; i++) {
            // Limpa esse vetor para que o resultados anteriores não interfiram nessa interação.
            kMelhores = new double[ this.k ][ 2 ];
            posicaoPior = 0;
            
            for (int j = 0; j < Instancia.matriz.length; j++) {
                soma = 0;
                if( !solucao[ j ] ){
                    for (int l = 0; l < indiceSelecionados.size(); l++) {
                        soma += Instancia.matriz[ j ][ indiceSelecionados.get( l ) ];                    
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
            indiceSelecionados.add( (int) kMelhores[n][0] );
            solucao[ (int) kMelhores[n][0] ] = true;
        }
    }   
    
    
//    public static void main(String[] args) {
//        List<Integer> indicesSelecionados = new ArrayList<>();
//        boolean[] solucao = { false, false, false, false };
//        double[][] matriz = { {0,2,4,5}, {2,0,3,1}, {4,3,0,2}, { 5,1,2,0}};
//        Instancia.matriz = matriz;
//        
//        EstrategiaSelecao estrategiaSelecao = new KGuloso( 3, 2 );
//        estrategiaSelecao.selecionar( indicesSelecionados, solucao );
//
//    }
    
//    private void teste(){
//        int soma;
//        int posicaoPior = 0;
//        int[] vetor = new int[]{2,3,6,5,7,8,12,9,1,13,8,14,17};
//        int[][] KMelhores = new int[3][2];
//        
//        for (int i = 0; i < vetor.length; i++) {
//            soma = vetor[ i ];
//            if( soma > KMelhores[ posicaoPior ][ 1 ] ){
//                KMelhores[ posicaoPior ][ 0 ] = i;
//                KMelhores[ posicaoPior ][ 1 ] = soma;
//                double pior = soma;
//                for (int l = 0; l < KMelhores.length; l++) {
//                    if( KMelhores[ l ][ 1 ] < pior ){
//                        pior = KMelhores[ l ][ 1 ];
//                        posicaoPior = l;
//                    }
//                }
//            }
//        }
//    }
}
