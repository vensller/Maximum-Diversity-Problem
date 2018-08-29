package Model;

/**
 *
 * @author Ivens
 */
public class GKD extends Instance{   
    
    private double[][] matriz;
    
    public GKD(int n, int m) {
        super(n, m);
        this.matriz = new double[n][n];
    }

    public double[][] getMatriz() {
        return matriz;
    }

    @Override
    public String toString() {
        String result = "GKD INSTANCE \n";
        
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
