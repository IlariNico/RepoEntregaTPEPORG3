/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpep2nico;


/**
 *
 * @author ilari
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import java.util.Map;


public class GrafoDirigido<T> implements Grafo<T> {
        private Map<Integer,ArrayList<Arco<T>>>vertices=new HashMap<>();
        private int cantidadArcos=0;
	@Override
        
        //Complejidad O(1) debido a que inserta el vertice en la key y si ya esta en uso lo reemplaza
	public void agregarVertice(int verticeId) {
            if(!vertices.containsKey(verticeId))
		vertices.put(verticeId, new ArrayList<>());
                
	}
        //Complejidad O(Vertices*Arcos)+O(1) remove HashMap = O(V+A)+O(1) debido a que revisa en el peor caso todos los vertices y todos los arcos, y ademas se debe sumar el costo de borrar una entrada en el HashMap que en promedio es O(1)
	@Override
	public void borrarVertice(int verticeId) {
                 for (ArrayList<Arco<T>> arcos : vertices.values()) {
                    Iterator<Arco<T>> iter = arcos.iterator();
                    while (iter.hasNext()) {
                        Arco a = iter.next();
                        if (a.getVerticeDestino() == verticeId) {
                            iter.remove();
                        }
                    }
                }
		vertices.remove(verticeId);
	}

        
        //Complejidad O(n)+O(1)+O(1) donde n es la cantidad de arcos en el vertice 1, y donde O(1) es el costo de verificar que las claves introducidas esten almacenadas
	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
                if((this.contieneVertice(verticeId2))&&(this.contieneVertice(verticeId1))){
                ArrayList<Arco<T>> arcos=vertices.get(verticeId1);
                Arco a=new Arco(verticeId1,verticeId2,etiqueta);
                if(!arcos.contains(a)){
                    arcos.add(a);
                    cantidadArcos++;
                }
                
                }
	}

        //O(n)+O(1)+O(1) ya que debe comparar si existe el arco donde N representaria la cantidad de arcos en el vertice 1, y donde O(1) es el costo de verificar que las claves introducidas esten almacenadas
	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
                if((this.contieneVertice(verticeId2))&&(this.contieneVertice(verticeId1))){
                    if(this.existeArco(verticeId1, verticeId2)){
                        vertices.get(verticeId1).remove(new Arco(verticeId1,verticeId2,null));
                        this.cantidadArcos--;
                    }
                }

	}

        //O(1) debido a la implementacion de hashmap
	@Override
	public boolean contieneVertice(int verticeId) {
		return vertices.containsKey(verticeId);
	}
        //O(a) donde a representa la cantidad de arcos del vertice
	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
		boolean existe=false;
                ArrayList<Arco<T>> arcos=vertices.get(verticeId1); //get O(1)
                Arco a1=new Arco(verticeId1,verticeId2,null);
                for(Arco a:arcos){
                    if(a1.equals(a))
                        existe=true;
                }
                return existe;
	}
        //O(Arcos en v1)=O(a) recorre todos los arcos del vertice 1 en el peor de los casos para ver que los vertices sean iguales
	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		ArrayList<Arco<T>>arcos=vertices.get(verticeId1);
                for(Arco a:arcos)
                    if(a.getVerticeDestino()==verticeId2){
                        return a;
                    }     
		return null;
	}

        
        //O(1) solo retorna un valor que almacena el hashmap
	@Override
	public int cantidadVertices() {
		return vertices.size();
	}
        
        //O(1) devuelvo la variable guardada
	@Override
	public int cantidadArcos() {
		return this.cantidadArcos;
	}
        
        //O(1) se crea el iterador en base a las claves del mapa
	@Override
	public Iterator<Integer> obtenerVertices() {
                Iterator<Integer> it=vertices.keySet().iterator();
                return it;
	}
        
        //O(n) donde N es la cantidad de arcos debe acceder a cada arco de el vertice 
	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		ArrayList<Integer>ady=new ArrayList();
                if(vertices.containsKey(verticeId)){
                    ArrayList<Arco<T>>arcos=vertices.get(verticeId);
                for(Arco a:arcos)
                    ady.add(a.getVerticeDestino());
                }
                return ady.iterator();
	}
        //O(v*a)=O(n) donde V es la cantidad de vertices y A la cantidad de arcos por vertices ya que se debe acceder a TODOS los arcos de todos los verticees
	@Override
	public Iterator<Arco<T>> obtenerArcos() {
            ArrayList<Arco<T>>arcos=new ArrayList();
            for(ArrayList<Arco<T>> a:vertices.values()){
                for(Arco<T> ar:a)
                    arcos.add(ar);
            }
            return arcos.iterator();
	}

        //O(1) ya que solo devuelve el iterador de arcos de la key seleccionada
	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		if(vertices.containsKey(verticeId)){
                    return vertices.get(verticeId).iterator();
                }
		return null;
	}
        //toString generado por chatGPT
        public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, ArrayList<Arco<T>>> entry : vertices.entrySet()) {
            int verticeId = entry.getKey();
            sb.append("Vertice ").append(verticeId).append(": ");
            ArrayList<Arco<T>> arcos = entry.getValue();
            for (Arco<T> arco : arcos) {
                sb.append(arco).append(", ");
            }
            sb.append("\n");
        }
        return sb.toString();
        }
}
