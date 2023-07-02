/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpep2nico;

import java.util.Objects;

/**
 *
 * @author ilari
 */
/*
 * La clase arco representa un arco del grafo. Contiene un vertice origen, un vertice destino y una etiqueta.
 * Nota: Para poder exponer los arcos fuera del grafo y que nadie los modifique se hizo esta clase inmutable
 * (Inmutable: una vez creado el arco no es posible cambiarle los valores).
 */
public class Arco<T> {

	private int verticeOrigen;
	private int verticeDestino;
	private T etiqueta;

        //Todos los métodos son O(1)
        
	public Arco(int verticeOrigen, int verticeDestino, T etiqueta) {
		this.verticeOrigen = verticeOrigen;
		this.verticeDestino = verticeDestino;
		this.etiqueta = etiqueta;
	}
	
	public int getVerticeOrigen() {
		return verticeOrigen;
	}
	
	public int getVerticeDestino() {
		return verticeDestino;
	}

	public T getEtiqueta() {
		return etiqueta;
	}
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Arco)) {
                return false;
            }
            Arco arco = (Arco) o;
            return Objects.equals(getVerticeOrigen(), arco.getVerticeOrigen()) &&
                    Objects.equals(getVerticeDestino(), arco.getVerticeDestino()) ;
        }
        //toString por chatGPT
        public String toString() {
            return "Arco { Origen: " + verticeOrigen + ", Destino: " + verticeDestino + ", Etiqueta: " + etiqueta + " }";
        }
}
