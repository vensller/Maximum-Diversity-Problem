package SearchStrategy;

import Model.Solution;

/**
 *
 * @author Ivens
 */
public abstract class SearchStrategy {
    
    public int remove;
    public int put;
    
    public abstract boolean movement(Solution s);  
}
