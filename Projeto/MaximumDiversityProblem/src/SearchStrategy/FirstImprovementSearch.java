package SearchStrategy;

import Model.Solution;

/**
 *
 * @author Ivens
 */
public class FirstImprovementSearch implements SearchStrategy{

    @Override
    public void localSearch(Solution s) {        
        for (int i = 0; i < s.set.length; i++){                
            if (s.set[i] == 1){                    
                for (int j = 0; j < s.set.length; j++){
                    if (s.set[j] == 0){
                        Solution newSol = new Solution(s.instance);
                        newSol.set = s.set;
                        newSol.set[i] = 0;
                        newSol.set[j] = 1;

                        newSol.evaluate();

                        if (newSol.value > s.value){
                            s = newSol;
                            return;
                        }
                    }
                }
            }
        }             
    }

    
}
