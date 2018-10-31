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
        while (true) {
            try{
                if (strategy.movement(s)) {
                    s.swap(strategy.remove, strategy.put);
                }else break; 

            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
            if( Grasp.tempoInicial + Grasp.TEMPO < System.currentTimeMillis() ){
                break;
            }
        }
    }
    
}
