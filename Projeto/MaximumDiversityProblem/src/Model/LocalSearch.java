package Model;

import SearchStrategy.SearchStrategy;

/**
 *
 * @author Ivens
 */
public class LocalSearch {
    
    private SearchStrategy strategy;

    public LocalSearch(SearchStrategy strategy) {
        this.strategy = strategy;
    }
    
    public void localSearch(Solution s){
        try{
            Solution newSol = (Solution) s.clone();
            newSol.set = s.set;
            strategy.localSearch(newSol);
            newSol.evaluate();

            if (newSol.value > s.value) {
                s = newSol;
            } 

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }    
    }
    
}
