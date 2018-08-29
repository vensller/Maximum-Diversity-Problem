package Model;

/**
 *
 * @author Ivens
 */
public class MDG {
    
    private int n;
    private int m;
    private double[][] matriz;

    public MDG(int n, int m) {
        this.n = n;
        this.m = m;
        this.matriz = new double[n][n];
    }  

    public int getN() {
        return n;
    }

    public int getM() {
        return m;
    }

    public double[][] getMatriz() {
        return matriz;
    }

    @Override
    public String toString() {
        String result = "MDG INSTANCE \n";
        
        for (int x = 0; x < n; x++){
            for (int y = 0; y < n; y++){
                result += matriz[x][y] + " ";
            }
            
            result += "\n";
        }
        
        result += "\n\n";
        
        return result;        
    }   
    
}
