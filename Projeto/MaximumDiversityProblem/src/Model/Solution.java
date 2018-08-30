package Model;

/**
 *
 * @author Ivens
 */
public class Solution {
    
    private Instance instance;
    public double value;    
    public int[] set;

    public Solution(Instance instance) {
        this.instance = instance;
        this.set = new int[instance.getN()];     
    }      
    
    public void evaluate(){
        double[][] matrix = instance.getMatrix();
        for (int x = 0; x < instance.getN(); x++){
            for (int y = x+1; y < instance.getN(); y++){
                value += matrix[x][y] * set[x] * set[y];
            }
        }
    }
}
