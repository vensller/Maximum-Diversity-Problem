package Model;

/**
 *
 * @author Ivens
 */
public abstract class Instance {
    
    protected int n;
    protected int m;
    protected int[] set;

    public Instance(int n, int m) {
        this.n = n;
        this.m = m;
        this.set = new int[n];
        populateSet();
    }
    
    private void populateSet(){        
        for (int x = 0; x < n; x++){
            set[x] = 0;
        }
    }

    public int getN() {
        return n;
    }

    public int getM() {
        return m;
    }

    public int[] getSet() {
        return set;
    } 
    
    
}
