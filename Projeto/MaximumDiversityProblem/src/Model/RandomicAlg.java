package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Ivens
 */
public class RandomicAlg {
        
    public void execute(Instance instance){
        double best = 0.0;
        int[] bestSet = new int[instance.n];
        double inicio = System.currentTimeMillis();

        while (System.currentTimeMillis() - inicio < 150000){
            List<Integer> numbers = new ArrayList<Integer>();
            for (int i = 0; i < instance.n; i++) {
                numbers.add(i);
            }                

            Collections.shuffle(numbers);

            Solution sol = new Solution(instance);

            for (int i = 0; i < instance.m; i++){
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
