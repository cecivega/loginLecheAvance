/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginleche;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/**
 *
 * @author MI
 */
public class arregloMensual {
 private ArrayList<Mensualw> objMensualw;
    
    // Contructor
    public arregloMensual() {
        objMensualw= new ArrayList<Mensualw>();
        
    }
    
    // Métodos de manejo del ArrayList
    public void agregar(Mensualw me) {
        objMensualw.add(me);
    }
    
    public void borrar(Mensualw me) {
        objMensualw.remove(me);
    }
    
    public Mensualw obtener(int pos) {
        return objMensualw.get(pos);
    }
    
    public Mensualw buscar(String tel) {
        for (int i = 0; i < objMensualw.size(); i++) {
            if(tel.equals(objMensualw.get(i).gettel()))
                return objMensualw.get(i);
        }
        return null;
    }
    
    public int numElementos() {
        return objMensualw.size();
    }
    
    public void leerDatos() {
        cargar();
    }
    
    
    
    // Cargar lista de alumnos
    private void cargar() {
        try {
            
            File archivo = new File("mensual.txt");
            // Si el archivo existe
            if(archivo.exists()) {
                BufferedReader br = new BufferedReader(new FileReader("mensual.txt"));
                String linea;
                
                while((linea = br.readLine()) != null) {
                    StringTokenizer st = new StringTokenizer(linea, ",");
                    String nombre = st.nextToken().trim();
                    String apellidoPat = st.nextToken().trim();
                    String apellidoMat = st.nextToken().trim();
                    String tel= st.nextToken().trim();
                    int litros= Integer.parseInt(st.nextToken().trim());
                    Mensualw me = new Mensualw(nombre, apellidoPat, apellidoMat, tel, litros);
                    agregar(me);
                }
                       
                
            }
            
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error: " + e);
        }   
    }
    public void guardar() {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter("mensual.txt"));
            for(int i=0; i<numElementos(); i++) {
                pw.println(obtener(i).gettel()+","+obtener(i).getApellidoPat()+","+
                        obtener(i).getApellidoMat()+","+obtener(i).getnombre()+","+obtener(i).getlitros());
                pw.close();
            }
            
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo el siguiente error: " + e);
        }

    }

}
