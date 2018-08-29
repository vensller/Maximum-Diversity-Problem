package Utilities;

import Model.SOM;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Ivens
 */
public class SOMInstanceReader {
    
    public SOM getSomInstance(String archive){
        SOM som = null;
        
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(archive));            
            String str = reader.readLine();
            String[] arrayStr = str.split(" ");
            
            if (arrayStr.length != 2){
                throw new IOException("Archive not containt a SOM instance");
            }
            
            som = new SOM(Integer.parseInt(arrayStr[0]), Integer.parseInt(arrayStr[1]));

            while ((str = reader.readLine()) != null) {                
                arrayStr = str.split(" ");
                
                if (arrayStr.length != 3){
                    throw new IOException("Archive not contain a SOM instance.");
                }
                
                som.getMatriz()[Integer.parseInt(arrayStr[0])][Integer.parseInt(arrayStr[1])] = (int)Double.parseDouble(arrayStr[2]);
                som.getMatriz()[Integer.parseInt(arrayStr[1])][Integer.parseInt(arrayStr[0])] = (int)Double.parseDouble(arrayStr[2]);
            }
            
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        return som;
    }
    
}
