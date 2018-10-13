package Estrategias;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import model.Instancia;

public class AlfaGulosoProbabilistico extends EstrategiaSelecao{
    
    private double alfa;

    public AlfaGulosoProbabilistico(int quantidadeSelecionados, double alfa) {
        super(quantidadeSelecionados);
        this.alfa = alfa;
    }
    
    @Override
    public void selecionar(List<Integer> indiceSelecionados, boolean[] solucao ) {
        int soma, n, posicaoPior, tamanhoAlfa;
        double somaPesos, somatorioPesos;
        double[][] alfaMelhores;
        Random sorteador = new Random();
        
        // O primeiro é aleatório.
        n = sorteador.nextInt( solucao.length );
        indiceSelecionados.add( n );
        solucao[ n ] = true;
        
        tamanhoAlfa = (int) Math.floor(solucao.length * alfa);
        
        for (int i = 0; i < super.quantidadeSelecionados-1; i++) {
            // Limpa esse vetor para que o resultados anteriores não interfiram nessa interação.
            alfaMelhores = new double[ tamanhoAlfa ][ 4 ];
            posicaoPior = 0;
            somaPesos = 0;
            somatorioPesos = 0;
            
            for (int j = 0; j < Instancia.matriz.length; j++) {
                soma = 0;
                
                if( !solucao[ j ] ){
                    for (int l = 0; l < indiceSelecionados.size(); l++) {
                        soma += Instancia.matriz[ j ][ indiceSelecionados.get( l ) ];                    
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
            
            QuickSort.ordenar(alfaMelhores, 0, alfaMelhores.length-1);
            
            for (int j = 0; j < alfaMelhores.length; j++) {
                alfaMelhores[j][2] = 1.0/( (double) j+1);
                somaPesos += alfaMelhores[j][2];
            }
            
            for (int j = 0; j < alfaMelhores.length; j++) {
                somatorioPesos += alfaMelhores[j][2] / somaPesos;
                alfaMelhores[j][3] = somatorioPesos;
            }

            double s = sorteador.nextDouble();
            for (int j = 0; j < alfaMelhores.length; j++) {
                if( s <= alfaMelhores[j][3]){
                    n = (int) alfaMelhores[j][0];
                    break;
                }
            }
            indiceSelecionados.add( n );
            solucao[ n ] = true;
        }
        
    }
    
    
    public static void main(String[] args) {
        List<Integer> indicesSelecionados = new ArrayList<>();
        boolean[] solucao = { false, false, false, false };
        double[][] matriz = { {0,2,4,5}, {2,0,3,1}, {4,3,0,2}, { 5,1,2,0}};
        Instancia.matriz = matriz;
        
        EstrategiaSelecao estrategiaSelecao = new AlfaGulosoProbabilistico(3, 0.5);
        estrategiaSelecao.selecionar( indicesSelecionados, solucao );
    }
}
