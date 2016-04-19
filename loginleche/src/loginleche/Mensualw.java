/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginleche;

/**
 *
 * @author MI
 */
public class Mensualw {
private String nombre;
    private String apellidoPat;
    private String apellidoMat;
    private String tel;
    private int litros;
    
 // Contructor clase
public Mensualw(String nombre,String apellidoPat, 
    String apellidoMat, String tel, int litros) {
    this.nombre= nombre;
    this.apellidoPat = apellidoPat;
    this.apellidoMat = apellidoMat;
    this.tel = tel;
    this.litros= litros;
}

// Métodos SET

public void setnombre(String nombre) {
    this.nombre= nombre;
}

public void setApellidoPat(String apellidoPat) {
    this.apellidoPat = apellidoPat;
}

public void setApellidoMat(String apellidoMat) {
    this.apellidoMat = apellidoMat;
}

public void settel(String tel) {
    this.tel= tel;
}

public void setSemestre(int litros) {
    this.litros = litros;
}

// Métodos GET

public String getnombre() {
    return nombre;
}

public String getApellidoPat() {
    return apellidoPat;
}

public String getApellidoMat() {
    return apellidoMat;
}

public String gettel() {
    return tel;
}

public int getlitros() {
    return litros;
}



}
   
