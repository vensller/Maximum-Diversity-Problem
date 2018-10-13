package Estrategias;

import java.util.List;

public abstract class EstrategiaSelecao {
    
    protected int quantidadeSelecionados;

    public EstrategiaSelecao(int quantidadeSelecionados) {
        this.quantidadeSelecionados = quantidadeSelecionados;
    }
    
    public abstract void selecionar( List<Integer> indicesSelecionados, boolean[] solucao );
}
