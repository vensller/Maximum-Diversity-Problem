package Estrategias;

import java.util.List;
import java.util.Random;
import model.Instancia;

public class KGulosoProbabilistico extends EstrategiaSelecao{
    
    private int k;

    public KGulosoProbabilistico(int quantidadeSelecionados, int k) {
        super(quantidadeSelecionados);
        this.k = k;
    }

    @Override
    public void selecionar(List<Integer> indiceSelecionados, boolean[] solucao ) {
        int soma, n, posicaoPior;
        double somaPesos, somatorioPesos;
        double[][] kMelhores;
        Random sorteador = new Random();
        
        // O primeiro é aleatório.
        n = sorteador.nextInt( solucao.length );
        indiceSelecionados.add( n );
        solucao[ n ] = true;
        
        for (int i = 0; i < super.quantidadeSelecionados-1; i++) {
            // Limpa esse vetor para que o resultados anteriores não interfiram nessa interação.
            kMelhores = new double[ this.k ][ 3 ];
            posicaoPior = 0;
            somaPesos = 0;
            somatorioPesos = 0;
            
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
            
            for (int j = 0; j < this.k; j++) {
                somaPesos += kMelhores[j][1];
            }

            for (int j = 0; j < this.k; j++) {
                somatorioPesos += kMelhores[j][1] / somaPesos;
                kMelhores[j][2] = somatorioPesos;
            }

            double s = sorteador.nextDouble();
            for (int j = 0; j < k; j++) {
                if( s <= kMelhores[j][2] ){
                    n = (int) kMelhores[j][0];
                    break;
                }
            }
            indiceSelecionados.add( n );
            solucao[ n ] = true;
        }
    }
    
//    public static void main(String[] args) {
//        List<Integer> indicesSelecionados = new ArrayList<>();
//        boolean[] solucao = { false, false, false, false };
//        double[][] matriz = { {0,2,4,5}, {2,0,3,1}, {4,3,0,2}, { 5,1,2,0}};
//        Instancia.matriz = matriz;
//        
//        EstrategiaSelecao estrategiaSelecao = new KGulosoProbabilistico(3, 2);
//        estrategiaSelecao.selecionar( indicesSelecionados, solucao );
//    }
}
