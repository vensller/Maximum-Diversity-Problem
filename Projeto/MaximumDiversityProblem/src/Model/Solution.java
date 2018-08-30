package Model;

/**
 *
 * @author Ivens
 */
public class Solution {
    
    private Instance instance;
    private double value;    
    private int[] set;

    public Solution(Instance instance) {
        this.instance = instance;
        this.set = new int[instance.getN()];     
    }      
    
    public void evaluate(){
        for (int x = 0; x < instance.getN(); x++){
            for (int y = 0; y < instance.getN(); y++){
                value += instance.getMatrix()[x][y] * set[x] * set[y];
            }
        }
    }

    public double getValue() {
        return value;
    }   
    
}
