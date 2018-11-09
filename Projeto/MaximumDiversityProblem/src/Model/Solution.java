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
        value = 0;
        double[][] matrix = instance.matrix;
        for (int x = 0; x < instance.n; x++){
            for (int y = x+1; y < instance.n; y++){
                value += matrix[x][y] * set[x] * set[y];
            }
        }
    }
    
    public double delta(int remove, int put){        
        double newValue = this.value;
        
        for (int x = 0; x < set.length; x++){
            if (x != remove && set[x] == 1){
                newValue -= instance.matrix[x][remove];                                
                newValue -= instance.matrix[remove][x];
                newValue += instance.matrix[x][put];
                newValue += instance.matrix[put][x];
            }
        }
        
        return newValue - this.value;
    }
    
    public void swap(int remove, int put){
        for (int x = 0; x < set.length; x++){
            if (x != remove && set[x] == 1){
                this.value -= instance.matrix[x][remove];  
                this.value -= instance.matrix[remove][x];
                this.value += instance.matrix[x][put];
                this.value += instance.matrix[put][x];
            }
        }
        
        this.set[remove] = 0;
        this.set[put] = 1;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
    
}
