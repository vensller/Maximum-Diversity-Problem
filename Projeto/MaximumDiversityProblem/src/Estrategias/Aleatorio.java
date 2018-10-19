package Estrategias;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Aleatorio extends ConstructionStrategy{

    public Aleatorio(int quantidadeSelecionados) {
        super(quantidadeSelecionados);
    }
    
    @Override
    public void select(int[] set, double[][] matriz) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < set.length; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        for (int i = 0; i < super.quantidadeSelecionados; i++){
            set[numbers.get(i)] = 1;
        }
    }

}
