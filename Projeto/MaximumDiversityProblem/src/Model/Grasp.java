package Model;

import Estrategias.ConstructionStrategy;
import SearchStrategy.SearchStrategy;

/**
 *
 * @author Ivens
 */
public class Grasp {
    
    private int repNum;
    private Greedy greedy;
    private LocalSearch localSearch;
    private Instance instance;

    public Grasp(int repNum, ConstructionStrategy construct, SearchStrategy search, Instance instance) {
        this.repNum = repNum;
        this.greedy = new Greedy(construct);
        this.localSearch = new LocalSearch(search);
        this.instance = instance;
    }  
    
    public Solution execute(){
        Solution best = null;
        
        for (int x = 0; x < repNum; x++){
            Solution s = greedy.construct(instance);
            localSearch.localSearch(s);
            if (best == null || s.value > best.value){
                best = s;
            }
        }
        
        return best;
    }
    
    
}
