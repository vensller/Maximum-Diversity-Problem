package Utilities;

import Model.Instance;
import Model.MDG;
/**
 *
 * @author Ivens
 */
public class MDGInstanceReader extends InstanceReader{

    @Override
    protected Instance createInstance(int n, int m) {
        return new MDG(n, m);
    }

    @Override
    protected String getInstanceName() {
        return "MDG";
    }

    @Override
    protected void populateMatrix(int x, int y, double val) {
        ((MDG)instance).getMatriz()[x][y] = val;
    }
 
    
}