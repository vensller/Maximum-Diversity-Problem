package Utilities;

import Model.Instance;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ivens
 */
public abstract class InstanceReader {
    
    protected Instance instance;
    
    public Instance getInstance(String archive){  
        instance = null;
        
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(archive));            
            String str = reader.readLine();
            String[] arrayStr = str.split(" ");
            
            if (arrayStr.length != 2){
                throw new IOException("Archive not containt a " + getInstanceName() + " instance");
            }
            
            instance = createInstance(Integer.parseInt(arrayStr[0]), Integer.parseInt(arrayStr[1]));
            
            while ((str = reader.readLine()) != null) {                
                arrayStr = str.split(" ");
                
                if (arrayStr.length != 3){
                    throw new IOException("Archive not containt a " + getInstanceName() + " instance");
                }
                
                populateMatrix(Integer.parseInt(arrayStr[0]), Integer.parseInt(arrayStr[1]), Double.parseDouble(arrayStr[2]));
                populateMatrix(Integer.parseInt(arrayStr[1]), Integer.parseInt(arrayStr[0]), Double.parseDouble(arrayStr[2]));
            }
            
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        return instance;
    }
    
    protected abstract Instance createInstance(int n, int m);
    
    protected abstract String getInstanceName();
    
    protected abstract void populateMatrix(int x, int y, double val);
    
}
