package Model;

/**
 *
 * @author Ivens
 */
public class MDG extends Instance{
        
    private double[][] matriz;    

    public MDG(int n, int m) {
        super(n, m);
        this.matriz = new double[n][n];
    }

    public double[][] getMatriz() {
        return matriz;
    }

    @Override
    public String toString() {
        String result = "MDG INSTANCE \n";
           
        /* FICA MUITO LENTO O PRINT, CASO QUEIRA VISUALIZAR OS DADOS, DESCOMENTE ESTE BLOCO.
        for (int x = 0; x < n; x++){
            for (int y = 0; y < n; y++){
                result += matriz[x][y] + " ";
            }
            
            result += "\n";
        }*/
        
        result += "\n\n";
        
        return result;        
    }   
}