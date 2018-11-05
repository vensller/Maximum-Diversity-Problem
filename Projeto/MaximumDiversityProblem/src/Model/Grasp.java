package Model;

import Estrategias.ConstructionStrategy;
import SearchStrategy.SearchStrategy;
import Utilities.FileText;

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
    private static final double TEMPO_ARTIGO = 2 * 60 * 60 * 1000;

    private static final double COEF_I7_UDESC = 9786;
    private static final double CEOF_TIAGO = 1426;
//    private static final int CEOF_DOUGLAS = 1;

    public static long tempoInicial = (long) ((COEF_I7_UDESC * TEMPO_ARTIGO) / COEF_ARTIGO);
    public static final long TEMPO = (long) ((COEF_I7_UDESC * TEMPO_ARTIGO) / COEF_ARTIGO);
//    public static final long TEMPO = 5000;

    public Grasp(int repNum, ConstructionStrategy construct, SearchStrategy search, Instance instance) {
        this.repNum = repNum;
        this.greedy = new Greedy(construct);
        this.localSearch = new LocalSearch(search);
        this.instance = instance;
    }

    public Solution execute() {
        tempoInicial = System.currentTimeMillis();
        Solution best = null;

        for (int x = 0; x < repNum; x++) {
            Solution s = greedy.construct(instance);

            localSearch.localSearch(s);

            if (best == null || s.value > best.value) {
                best = s;
                String dados = "X - " + x + 
                        "\tTempo: " + (System.currentTimeMillis() - Main.Main.tempoInicialTotal) + 
                        "\tBest.Value: " + best.value;
                new FileText().escrever(dados, 2);
            }
            if (tempoInicial + TEMPO < System.currentTimeMillis()) {
                break;
            }
        }

        return best;
    }

}
