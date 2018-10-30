package SearchStrategy;

import Model.Solution;

/**
 *
 * @author Ivens
 */
public class FirstImprovementSearch extends SearchStrategy{
    
    @Override
    public boolean movement(Solution s) {        
        for (int i = 0; i < s.set.length; i++){                
            if (s.set[i] == 1){                    
                for (int j = 0; j < s.set.length; j++){
                    if (s.set[j] == 0){
                        double delta = s.delta(i, j);
                        
                        if (delta > 0){ 
                            remove = i;
                            put = j;
                            return true;
                        }
                    }
                }
            }
        }             
        
        return false;
    }

    
}
