package Main;

import Model.Instance;
import Model.RandomicAlg;
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
            RandomicAlg alg = new RandomicAlg();
            alg.execute(som);
        }       
        
                
    }
    
}
