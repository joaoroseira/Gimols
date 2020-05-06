/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author joaovitor
 */
public class Login {
    String home_diretorio = System.getProperty("user.home");
    String path= home_diretorio+"/hicolm/";
    public void criarDiretorio(String usuario, String senha){
        File diretorio = new File(this.path+usuario);
        diretorio.mkdir();
        if(diretorio.exists()==false){
             JOptionPane.showMessageDialog(null, "Error creating directory", "Warning",  JOptionPane.ERROR_MESSAGE);
        }
        else{
            try {
                PrintWriter pw = new PrintWriter(this.path+usuario+"/useraccount.txt");
                pw.println(usuario);
                pw.println(senha);
                pw.flush();
                pw.close();
            } catch (FileNotFoundException ex) {
                 JOptionPane.showMessageDialog(null, "Could not create access file", "Warning",  JOptionPane.ERROR_MESSAGE);
            }
        }
    
        
    }
    
}
