/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginleche;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/**
 *
 * @author MI
 */
public class Usuario {
   private String usuario;
    private String contra;
    private int cveTipo;
    private String nombre;
    
    // Constructor
    
    public void Usuario(String strNomUsuario, String strPassword, 
            int nCveTipo, String strNombre) {
        this.usuario = strNomUsuario;
        this.contra = strPassword;
        this.cveTipo = nCveTipo;
        this.nombre = strNombre;
    }
    
    // Métodos SET
    
    public void setNomUsuario(String strNomUsuario) {
        this.usuario = strNomUsuario;
    }
    
    public void setPassword(String strPassword) {
        this.contra = strPassword;
    }
    
    public void setTipoUsuario(int nCveTipo) {
        this.cveTipo = nCveTipo;
    }
    
    public void setNombre(String strNombre) {
        this.nombre = strNombre;
    }
    
    // Métodos GET
    
    public String getNomUsuario() {
        return usuario;
    }
    
    public String getPasswod() {
        return contra;
    }
    
    public int getTipoUsuario() {
        return cveTipo;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    // Método valida usuario
    public int validaUsuario(String strNomUsuario, 
            char[] strPassword) {
        int tipoUsuario = 0;
        
        try {
            File archivo = new File("users.txt");
            if(archivo.exists()) {
                BufferedReader br = new BufferedReader(new FileReader("users.txt"));
                String linea;
                while((linea = br.readLine()) != null) {
                    StringTokenizer st = new StringTokenizer(linea, ",");
                    String usuario = st.nextToken().trim();
                    String contra = st.nextToken().trim();                    
                    char[] clave = contra.toCharArray();
                    if ((usuario.equals(strNomUsuario)) && 
                            (Arrays.equals(clave, strPassword))) {
                        tipoUsuario = Integer.parseInt(st.nextToken().trim());
                    }
                }
            } 
            else {
                JOptionPane.showMessageDialog(null, "El archivo de usuarios no existe");
            }
        
        } 
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error" + e);
        }
        return tipoUsuario;
    }
    
}
