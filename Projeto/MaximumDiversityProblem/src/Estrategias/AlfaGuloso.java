package Estrategias;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AlfaGuloso extends ConstructionStrategy{

    private double alfa;

    public AlfaGuloso(int quantidadeSelecionados, double alfa) {
        super(quantidadeSelecionados);
        this.alfa = alfa;
    }
    
    @Override
    public void select(int[] solucao, double[][] matriz) {
        int soma, n, posicaoPior, tamanhoAlfa;
        double[][] alfaMelhores;
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
        
        tamanhoAlfa = (int) Math.floor(solucao.length * alfa);
        
        for (int i = 0; i < super.quantidadeSelecionados-1; i++) {
            // Limpa esse vetor para que o resultados anteriores não interfiram nessa interação.
            alfaMelhores = new double[ tamanhoAlfa ][ 2 ];
            posicaoPior = 0;
            
            for (int j = 0; j < matriz.length; j++) {
                soma = 0;
                if( solucao[ j ] != 1){
                    for (int l = 0; l < indicesSelecionados.size(); l++) {
                        soma += matriz[ j ][ indicesSelecionados.get( l ) ];                    
                    }
                    
                    if( soma > alfaMelhores[ posicaoPior ][ 1 ] ){
                        alfaMelhores[ posicaoPior ][ 0 ] = j;
                        alfaMelhores[ posicaoPior ][ 1 ] = soma;
                        double pior = Double.MAX_VALUE;
                        for (int l = 0; l < alfaMelhores.length; l++) {
                            if( alfaMelhores[ l ][ 1 ] < pior ){
                                pior = alfaMelhores[ l ][ 1 ];
                                posicaoPior = l;
                            }
                        }
                    }
                }

            }

            int s = sorteador.nextInt( tamanhoAlfa );
            n = (int) alfaMelhores[s][0];
            indicesSelecionados.add( n );
            solucao[ n ] = 1;
        }
    }

}
