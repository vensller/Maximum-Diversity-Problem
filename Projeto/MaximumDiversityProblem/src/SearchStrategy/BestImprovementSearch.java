package SearchStrategy;

import Model.Solution;

/**
 *
 * @author Ivens
 */
public class BestImprovementSearch extends SearchStrategy{

    @Override
    public boolean movement(Solution s) {
        remove = 0;
        put = 0;
        double bestDelta = 0;
        for (int i = 0; i < s.set.length; i++){                
            if (s.set[i] == 1){                    
                for (int j = 0; j < s.set.length; j++){
                    if (s.set[j] == 0){                    
                        double delta = s.delta(i, j);
                        
                        if (delta > bestDelta){
                            remove = i;
                            put = j;
                        }
                    }
                }
            }
        }   
               
        return bestDelta > 0;
    }
    
}
