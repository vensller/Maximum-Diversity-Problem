package Main;

import Utilities.GKDInstanceReader;
import Utilities.MDGInstanceReader;
import Utilities.SOMInstanceReader;
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
            SOMInstanceReader somReader = new SOMInstanceReader();
            System.out.println(somReader.getInstance(fileChooser.getSelectedFile().getAbsolutePath()));
        }    
        
        result = fileChooser.showDialog(null, "Choose a GKD instance!");        
        if (result == JFileChooser.APPROVE_OPTION){
            GKDInstanceReader gkdReader = new GKDInstanceReader();
            System.out.println(gkdReader.getInstance(fileChooser.getSelectedFile().getAbsolutePath()));
        }
        
        result = fileChooser.showDialog(null, "Choose a MDG instance!");        
        if (result == JFileChooser.APPROVE_OPTION){
            MDGInstanceReader mdgReader = new MDGInstanceReader();
            System.out.println(mdgReader.getInstance(fileChooser.getSelectedFile().getAbsolutePath()));
        }
                
    }
    
}
