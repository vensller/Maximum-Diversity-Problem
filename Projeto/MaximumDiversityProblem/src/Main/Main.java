package Main;

import Model.Instance;
import Model.RandomicAlg;
import Model.Solution;
import SearchStrategy.SwapLocalSearch;
import Utilities.InstanceReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JFileChooser;

/**
 *
 * @author Ivens
 */
public class Main {
    
    public static void main(String[] args){       
//        JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir"));;
//        
//        int result = fileChooser.showDialog(null, "Choose a SOM instance!");        
//        if (result == JFileChooser.APPROVE_OPTION){
//            InstanceReader gkdReader = new InstanceReader();
//            Instance som = gkdReader.getInstance(fileChooser.getSelectedFile().getAbsolutePath());
//            RandomicAlg alg = new RandomicAlg();
//            alg.execute(som);
//        }       
        Instance instance = new Instance(5, 2);
        double[][] matriz = {{0,2,4,5,4}, {2,0,3,1,4}, {4,3,0,2,4}, {5,1,2,0,4}, {5,3,2,1,5}};
        instance.matrix = matriz;
        Solution solucao = new Solution(instance);
        solucao.set[0] = 1;
        solucao.set[2] = 1;
        solucao.evaluate();
        SwapLocalSearch swap = new SwapLocalSearch();
        swap.localSearch(solucao);
   }
    
}
