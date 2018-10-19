package Estrategias;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GulosoPonderado extends ConstructionStrategy{
    
    private double pesoSelecionados;
    private double pesoNaoSelecionados;

    public GulosoPonderado(int quantidadeSelecionados, double peso) {
        super(quantidadeSelecionados);
        this.pesoSelecionados = peso;
        this.pesoNaoSelecionados = 1 - pesoSelecionados;
    }
    
    @Override
    public void select(int[] solucao, double[][] matriz) {
        int n;
        double soma, maior;
        
        // O primeiro é aleatório.
        n = new Random().nextInt( solucao.length );
        solucao[ n ] = 1;
        
        for (int i = 0; i < super.quantidadeSelecionados-1; i++) {
            maior = 0;
            for (int j = 0; j < matriz.length; j++) {
                soma = 0;
                if( solucao[ j ] != 1 ){
                    for (int k = 0; k < solucao.length; k++) {
                        if( solucao[ k ] != 1 ){
                            soma += matriz[ j ][ k ] * this.pesoSelecionados;
                        }else{
                            soma += matriz[ j ][ k ] * this.pesoNaoSelecionados;
                        }

                    }
                }
                
                if( maior < soma ){
                    maior = soma;
                    n = j;
                }
            }
            solucao[ n ] = 1;
        }
    }
    
}
