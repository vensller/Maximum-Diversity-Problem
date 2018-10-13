package Estrategias;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import model.Instancia;

public class Guloso extends EstrategiaSelecao{

    public Guloso(int quantidadeSelecionados) {
        super(quantidadeSelecionados);
    }

    @Override
    public void selecionar( List<Integer> indicesSelecionados, boolean[] solucao ) {
        int n;
        double soma, maior;
        
        // O primeiro é aleatório.
        n = new Random().nextInt( solucao.length );
        indicesSelecionados.add( n );
        solucao[ n ] = true;
        
        for (int i = 0; i < super.quantidadeSelecionados-1; i++) {
            maior = 0;
            for (int j = 0; j < Instancia.matriz.length; j++) {
                soma = 0;
                if( !solucao[ j ] ){
                    for (int k = 0; k < indicesSelecionados.size(); k++) {
                        soma += Instancia.matriz[ j ][ indicesSelecionados.get( k ) ];                    
                    }
                }
                if( maior < soma ){
                    maior = soma;
                    n = j;
                }
            }
            indicesSelecionados.add( n );
            solucao[ n ] = true;
        }
    }
    
//    public static void main(String[] args) {
//        List<Integer> indicesSelecionados = new ArrayList<>();
//        boolean[] solucao = { false, false, false, false };
//        double[][] matriz = { {0,2,4,5}, {2,0,3,1}, {4,3,0,2}, { 5,1,2,0}};
//        Instancia.matriz = matriz;
//        
//        EstrategiaSelecao estrategiaSelecao = new Guloso( 3 );
//        estrategiaSelecao.selecionar( indicesSelecionados, solucao );
//        
//    }
}
