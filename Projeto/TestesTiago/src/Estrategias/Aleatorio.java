package Estrategias;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import model.Instancia;

public class Aleatorio extends EstrategiaSelecao{

    public Aleatorio(int quantidadeSelecionados) {
        super(quantidadeSelecionados);
    }

    @Override
    public void selecionar( List<Integer> indicesSelecionados, boolean[] solucao ) {
        int n;
        Random sorteador = new Random();
        for (int i = 0; i < super.quantidadeSelecionados; i++) {
            do{
                n = sorteador.nextInt( solucao.length );
            }while( solucao[ n ] );
            solucao[ n ] = true;
        }
    }
    
//    public static void main(String[] args) {
//        List<Integer> indicesSelecionados = new ArrayList<>();
//        boolean[] solucao = { false, false, false, false };
//        double[][] matriz = { {0,2,4,5}, {2,0,3,1}, {4,3,0,2}, { 5,1,2,0}};
//        Instancia.matriz = matriz;
//        
//        EstrategiaSelecao estrategiaSelecao = new Aleatorio( 2 );
//        estrategiaSelecao.selecionar( indicesSelecionados, solucao );
//        
//    }
}
