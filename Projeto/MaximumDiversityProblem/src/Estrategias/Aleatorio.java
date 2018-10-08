package Estrategias;

import java.util.Random;

public class Aleatorio implements EstrategiaSelecao{
    
    @Override
    public int selecionar( boolean[] solucao){
        int n;
        Random sorteador = new Random();
        do{
            n = sorteador.nextInt( solucao.length );
        }while( solucao[ n ] );
        return n;
    }
}
