/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tpep2nico;

import java.util.ArrayList;

/**
 *
 * @author ilari
 */
public class MainPruebasGreedy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            // Crear el grafo
    Grafo<Integer> grafo = new GrafoDirigido<>();
    grafo.agregarVertice(1);
    grafo.agregarVertice(2);
    grafo.agregarVertice(3);
    grafo.agregarVertice(4);
    grafo.agregarVertice(5);

    grafo.agregarArco(1, 2, 10);
    grafo.agregarArco(1, 3, 5);
    grafo.agregarArco(2, 3, 2);
    grafo.agregarArco(2, 4, 1);
    grafo.agregarArco(3, 2, 3);
    grafo.agregarArco(3, 4, 9);
    grafo.agregarArco(3, 5, 2);
    grafo.agregarArco(4, 5, 4);
    grafo.agregarArco(5, 1, 7);
    grafo.agregarArco(5, 4, 6);

    int origen = 2;
    int dist=0;
    Greedy dijkstra = new Greedy();
    ArrayList<NodoDijkstra> solucion = dijkstra.caminos(grafo, origen);

    // Imprimir los caminos más cortos desde el origen
    for (NodoDijkstra nodo : solucion) {
        System.out.println("Vertice: " + nodo.getValor());
        System.out.println("Distancia: " + nodo.getDistancia());
        System.out.println("Padre: " + nodo.getPadre());
        System.out.println("------------------");
        dist+=nodo.getDistancia();
    }
    System.out.println("Distancia "+dist);
    // Imprimir el número de iteraciones realizadas
    System.out.println("Número de iteraciones: " + dijkstra.getIteraciones());
    }
    
}
