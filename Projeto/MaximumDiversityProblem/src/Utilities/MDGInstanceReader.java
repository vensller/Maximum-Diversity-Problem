package Utilities;

import Model.MDG;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ivens
 */
public class MDGInstanceReader {
    
    public MDG getMDGInstance(String archive){
        MDG mdg = null;
        
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(archive));            
            String str = reader.readLine();
            String[] arrayStr = str.split(" ");
            
            if (arrayStr.length != 2){
                throw new IOException("Archive not containt a MDG instance");
            }
            
            mdg = new MDG(Integer.parseInt(arrayStr[0]), Integer.parseInt(arrayStr[1]));

            while ((str = reader.readLine()) != null) {                
                arrayStr = str.split(" ");
                
                if (arrayStr.length != 3){
                    throw new IOException("Archive not contain a MDG instance.");
                }
                
                mdg.getMatriz()[Integer.parseInt(arrayStr[0])][Integer.parseInt(arrayStr[1])] = Double.parseDouble(arrayStr[2]);
                mdg.getMatriz()[Integer.parseInt(arrayStr[1])][Integer.parseInt(arrayStr[0])] = Double.parseDouble(arrayStr[2]);
            }
            
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        return mdg;
    }
    
}
