package Model;

/**
 *
 * @author Ivens
 */
public class Solution implements Cloneable{
    
    public Instance instance;
    public double value;    
    public int[] set;

    public Solution(Instance instance) {
        this.instance = instance;
        this.set = new int[instance.n];     
    }      
    
    public void evaluate(){
        double[][] matrix = instance.matrix;
        for (int x = 0; x < instance.n; x++){
            for (int y = x+1; y < instance.n; y++){
                value += matrix[x][y] * set[x] * set[y];
            }
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
    
}
