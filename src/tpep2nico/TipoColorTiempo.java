/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpep2nico;

/**
 *
 * @author ilari
 */
public class TipoColorTiempo {
    String color;
    int tiempoDescubrimiento;
    int tiempoFinalizacion;
    public String getColor() {
        return color;
    }

    public int getTiempotiempoDescubrimiento() {
        return tiempoDescubrimiento;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setTiempotiempoDescubrimiento(int tiempo) {
        this.tiempoDescubrimiento = tiempo;
    }
    
    public boolean igualAColor(String color){
        return this.color.equals(color);
    }
    
    public void settiempoFinalizacion(int tiempo) {
        this.tiempoFinalizacion = tiempo;
    }
    
    public int gettiempoFinalizacion() {
        return tiempoFinalizacion;
    }
    
    public String toString(){
        return ("Color "+color+" Tiempo descubrimiento "+tiempoDescubrimiento+" Tiempo Finalizacion "+tiempoFinalizacion);
    }
}
