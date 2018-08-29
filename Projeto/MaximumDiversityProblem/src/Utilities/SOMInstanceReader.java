package Utilities;

import Model.Instance;
import Model.SOM;

/**
 *
 * @author Ivens
 */
public class SOMInstanceReader extends InstanceReader{

    @Override
    protected Instance createInstance(int n, int m) {
        return new SOM(n, m);
    }

    @Override
    protected String getInstanceName() {
        return "SOM";
    }

    @Override
    protected void populateMatrix(int x, int y, double val) {
        ((SOM)instance).getMatriz()[x][y] = (int) val;
    }
}
