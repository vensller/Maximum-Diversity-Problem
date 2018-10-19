package Estrategias;

public abstract class ConstructionStrategy {
    
    protected int quantidadeSelecionados;

    public ConstructionStrategy(int quantidadeSelecionados) {
        this.quantidadeSelecionados = quantidadeSelecionados;
    }
    
    public abstract void select(int[] set, double[][] matriz);
}
