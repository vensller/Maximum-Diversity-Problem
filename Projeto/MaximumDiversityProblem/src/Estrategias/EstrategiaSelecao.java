package Estrategias;

import java.util.List;

public interface EstrategiaSelecao {
    
    public void selecionar( List<Integer> indiceSelecionados, boolean[] solucao, double[][] matriz );
}
