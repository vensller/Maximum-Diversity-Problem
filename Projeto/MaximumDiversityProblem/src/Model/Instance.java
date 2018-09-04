package Model;

/**
 *
 * @author Ivens
 */
public class Instance {
    
    public int n;
    public int m;
    public double[][] matrix;

    public Instance(int n, int m) {
        this.n = n;
        this.m = m;
        this.matrix = new double[n][n];
    }
        
}
