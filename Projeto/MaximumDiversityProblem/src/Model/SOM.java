package Model;

/**
 *
 * @author Ivens
 */
public class SOM extends Instance{
    
    private int[][] matriz;    

    public SOM(int n, int m) {
        super(n, m);
        this.matriz = new int[n][n];
    }

    public int[][] getMatriz() {
        return matriz;
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
