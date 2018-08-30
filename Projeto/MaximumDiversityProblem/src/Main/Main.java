package Main;

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
            somReader.getInstance(fileChooser.getSelectedFile().getAbsolutePath());
        }    
        
        result = fileChooser.showDialog(null, "Choose a GKD instance!");        
        if (result == JFileChooser.APPROVE_OPTION){
            InstanceReader gkdReader = new InstanceReader();
            gkdReader.getInstance(fileChooser.getSelectedFile().getAbsolutePath());
        }
        
        result = fileChooser.showDialog(null, "Choose a MDG instance!");        
        if (result == JFileChooser.APPROVE_OPTION){
            InstanceReader mdgReader = new InstanceReader();
            mdgReader.getInstance(fileChooser.getSelectedFile().getAbsolutePath());
        }
                
    }
    
}
