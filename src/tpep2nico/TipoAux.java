/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpep2nico;

/**
 *
 * @author ilari
 */
public class TipoAux {
    int vertice;
    Arco a;

    public void setVertice(int vertice) {
        this.vertice = vertice;
    }

    public void setA(Arco a) {
        this.a = a;
    }

    public int getVertice() {
        return vertice;
    }

    public Arco getA() {
        return a;
    }

    public TipoAux(int vertice, Arco a) {
        this.vertice = vertice;
        this.a = a;
    }
    
    
}
