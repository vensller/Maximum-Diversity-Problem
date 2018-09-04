package Main;

import Model.Instance;
import Model.Solution;
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
        JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir"));
        
        int result = fileChooser.showDialog(null, "Choose a SOM instance!");        
        if (result == JFileChooser.APPROVE_OPTION){
            InstanceReader gkdReader = new InstanceReader();
            Instance som = gkdReader.getInstance(fileChooser.getSelectedFile().getAbsolutePath());
            double best = 0.0;
            int[] bestSet = new int[100];
            double inicio = System.currentTimeMillis();
            
            while (System.currentTimeMillis() - inicio < 150000){
                List<Integer> numbers = new ArrayList<Integer>();
                for (int i = 0; i < som.n; i++) {
                    numbers.add(i);
                }                
                                                
                Collections.shuffle(numbers);
                
                Solution sol = new Solution(som);
                
                for (int i = 0; i < som.m; i++){
                    sol.set[numbers.get(i)] = 1;
                }
                
                sol.evaluate();
                
                System.out.println("Solution: " + sol.value);
                
                if (sol.value > best){
                    best = sol.value;
                    bestSet = sol.set;
                }
                
            }
            
            System.out.println("Best Solution: " + best);
            System.out.println("Set of the best solution: ");
            String res = "";
            for (int x = 0; x < 100; x++){
                res += bestSet[x] + " | ";
            }
            System.out.println(res);
        }       
        
                
    }
    
}
