package Model;

/**
 *
 * @author Ivens
 */
public class SOM {
    
    private int[][] matriz;
    private int n;
    private int m;    

    public SOM(int n, int m) {
        this.n = n;
        this.m = m;
        matriz = new int[n][n];
    }   

    public int[][] getMatriz() {
        return matriz;
    }

    public int getN() {
        return n;
    }

    public int getM() {
        return m;
    }   

    @Override
    public String toString() {
        String result = "SOM INSTANCE \n";
        
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
