package Model;

/**
 *
 * @author Ivens
 */
public class Instance {
    
    private int n;
    private int m;
    private double[][] matrix;

    public Instance(int n, int m) {
        this.n = n;
        this.m = m;
        this.matrix = new double[n][n];
    }
    
    public int getN() {
        return n;
    }

    public int getM() {
        return m;
    }

    public double[][] getMatrix() {
        return matrix;
    }  
    
}
