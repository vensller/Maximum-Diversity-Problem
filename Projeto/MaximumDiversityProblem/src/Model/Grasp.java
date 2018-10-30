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
    
    /**
     * 9786
     */
    private static final double COEF_ARTIGO = 2986;
    private static final double TEMPO_ARTIGO = 2*60*60*1000;
    
    private static final double COEF_I_7_UDESC = 9786;
//    private static final int CEOF_DOUGLAS = 1;
    private static final int TEMPO = (int) ( (COEF_I_7_UDESC*TEMPO_ARTIGO)/COEF_ARTIGO );

    public Grasp(int repNum, ConstructionStrategy construct, SearchStrategy search, Instance instance) {
        this.repNum = repNum;
        this.greedy = new Greedy(construct);
        this.localSearch = new LocalSearch(search);
        this.instance = instance;
    }  
    
    public Solution execute(){
        long tempoInicial = System.currentTimeMillis();
        Solution best = null;
        
        for (int x = 0; x < repNum; x++){
            Solution s = greedy.construct(instance);
            
            localSearch.localSearch(s);
            
            if (best == null || s.value > best.value){
                best = s;
            }
            if( tempoInicial + TEMPO < System.currentTimeMillis() ){
                break;
            }
        }
        
        return best;
    }
    
    
}
