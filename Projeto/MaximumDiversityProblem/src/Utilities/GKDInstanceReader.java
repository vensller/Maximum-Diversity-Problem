package Utilities;

import Model.GKD;
import Model.Instance;

/**
 *
 * @author Ivens
 */
public class GKDInstanceReader extends InstanceReader{

    @Override
    protected Instance createInstance(int n, int m) {
        return new GKD(n, m);
    }

    @Override
    protected String getInstanceName() {
        return "GDK";
    }

    @Override
    protected void populateMatrix(int x, int y, double val) {
        ((GKD)instance).getMatriz()[x][y] = val;
    }

    
}
