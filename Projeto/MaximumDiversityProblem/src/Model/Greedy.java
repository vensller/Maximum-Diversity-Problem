package Model;

import Estrategias.ConstructionStrategy;

/**
 *
 * @author Ivens
 */
public class Greedy {
    
    private ConstructionStrategy strategy;

    public Greedy(ConstructionStrategy strategy) {
        this.strategy = strategy;
    }
    
    public Solution construct(Instance instance){
        Solution s = new Solution(instance);
        
        strategy.select( s.set, instance.matrix );
        s.evaluate();
//        for (int x = 0; x < instance.m; x++){
//            s.set[strategy.select(s.set, instance.matrix)] = 1;
//        }        
//        s.evaluate();

        
        return s;
    }
    
}
