package Main;

import Model.Solution;
import Utilities.InstanceReader;
import javax.swing.JFileChooser;

/**
 *
 * @author Ivens
 */
public class Main {
    
    public static void main(String[] args){       
        JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir"));
        
        int result = fileChooser.showDialog(null, "Choose a SOM instance");        
        if (result == JFileChooser.APPROVE_OPTION){            
            InstanceReader somReader = new InstanceReader();            
            Solution som = new Solution(somReader.getInstance(fileChooser.getSelectedFile().getAbsolutePath()));
            som.evaluate();
            System.out.println("SOM solution: " + som.getValue());
        }    
        
        result = fileChooser.showDialog(null, "Choose a GKD instance!");        
        if (result == JFileChooser.APPROVE_OPTION){
            InstanceReader gkdReader = new InstanceReader();
            Solution gkd = new Solution(gkdReader.getInstance(fileChooser.getSelectedFile().getAbsolutePath()));
            gkd.evaluate();
            System.out.println("GKD solution: " + gkd.getValue());
        }
        
        result = fileChooser.showDialog(null, "Choose a MDG instance!");        
        if (result == JFileChooser.APPROVE_OPTION){
            InstanceReader mdgReader = new InstanceReader();
            Solution mdg = new Solution(mdgReader.getInstance(fileChooser.getSelectedFile().getAbsolutePath()));
            mdg.evaluate();
            System.out.println("MDG solution: " + mdg.getValue());
        }
                
    }
    
}
