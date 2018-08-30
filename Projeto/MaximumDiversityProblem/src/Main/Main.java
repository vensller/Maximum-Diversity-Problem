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
            
            while (System.currentTimeMillis() - inicio < 500000){
                List<Integer> numbers = new ArrayList<Integer>();
                for (int i = 0; i < 100; i++) {
                    numbers.add(i);
                }                
                
                Collections.shuffle(numbers);
                int i1 = numbers.get(0);
                int i2 = numbers.get(1);
                int i3 = numbers.get(2);
                int i4 = numbers.get(3);
                int i5 = numbers.get(4);
                int i6 = numbers.get(5);
                int i7 = numbers.get(6);
                int i8 = numbers.get(7);
                int i9 = numbers.get(8);
                int i10 = numbers.get(9);
                
                Solution sol = new Solution(som);
                sol.set[i1] = 1;
                sol.set[i2] = 1;
                sol.set[i3] = 1;
                sol.set[i4] = 1;
                sol.set[i5] = 1;
                sol.set[i6] = 1;
                sol.set[i7] = 1;
                sol.set[i8] = 1;
                sol.set[i9] = 1;
                sol.set[i10] = 1;
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
