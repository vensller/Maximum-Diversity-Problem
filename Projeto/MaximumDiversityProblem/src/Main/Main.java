package Main;

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
            System.out.println(somReader.getSomInstance(fileChooser.getSelectedFile().getAbsolutePath()));
        }    
        
        result = fileChooser.showDialog(null, "Choose a MDG instance!");
        
        if(result == JFileChooser.APPROVE_OPTION){
            MDGInstanceReader mdgReader = new MDGInstanceReader();
            System.out.println(mdgReader.getMDGInstance(fileChooser.getSelectedFile().getAbsolutePath()));
        }
                
    }
    
}
