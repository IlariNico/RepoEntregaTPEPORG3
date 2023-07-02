/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpep2nico;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author ilari
 */
public class Back {

    private static int iteraciones;

    public Back() {
        iteraciones = 0;
    }


    
    public ArrayList<Arco> construirBack(Grafo g){
        iteraciones=0;
        Iterator it=g.obtenerVertices();
        ArrayList<Arco>mejorCamino=new ArrayList();
        ArrayList<Arco>caminoAct=new ArrayList();
        ArrayList<Integer>visitados=new ArrayList();
        while(it.hasNext()){
            Integer v=(Integer)it.next();
            
            backTrack(mejorCamino,caminoAct,g,visitados,v);
            
        }
        return mejorCamino;
    }

    public int getIteraciones() {
        return iteraciones;
    }

    private void backTrack(ArrayList<Arco>mejorCamino, ArrayList<Arco>caminoAct, Grafo g, ArrayList<Integer>visitados, Integer vAct){
        iteraciones++;
        if(esSolucion(caminoAct,g)){
            if((distanciasCaminos(mejorCamino)>distanciasCaminos(caminoAct))||(mejorCamino.isEmpty())){
                mejorCamino.clear();
                mejorCamino.addAll(caminoAct);
            }
        }
        else if(vAct!=null){ //primero ejecuta el backtracking para cada uno de los adyacentes del vertice
            if(!visitados.contains(vAct)){
                visitados.add(vAct);
                Iterator it=g.obtenerAdyacentes(vAct);
                while(it.hasNext()){
                    int ady=(Integer)it.next();
                    Arco arcoAct=g.obtenerArco(vAct, ady);
                    caminoAct.add(arcoAct);
                    backTrack(mejorCamino,caminoAct,g,visitados,ady);
                    
                    caminoAct.remove(arcoAct);
                }
                it=g.obtenerAdyacentes(vAct);
                ArrayList<Arco>arcos=new ArrayList();
                while(it.hasNext()){ //llama al backtracking con los arcos adyacentes (tal vez sus adyacentes son el mejor camino y no un camino partiendo por uno de ellos)
                    int ady=(Integer)it.next();
                    Arco arcoAct=g.obtenerArco(vAct, ady);
                    caminoAct.add(arcoAct);
                    arcos.add(arcoAct);
                }
                backTrack(mejorCamino,caminoAct,g,visitados,null);
                for(Arco a:arcos)
                    caminoAct.remove(a);
                visitados.remove(vAct);
            }
        }
    }
    

    
    public boolean contieneTodosLosVertices(ArrayList<Integer>visitados,Grafo g){
        boolean todos=true;
        Iterator it=g.obtenerVertices();
        while(it.hasNext())
            if(!visitados.contains((Integer)it.next()))
                todos=false;
        return todos;
    }
    
    public int distanciasCaminos(ArrayList<Arco>camino){
        int dist=0;
        for(Arco a:camino)
            dist+=(Integer)a.getEtiqueta();
        return dist;
    }
    
    
    public boolean esSolucion(ArrayList<Arco> caminoAct, Grafo g) {
    // Verificar si el camino actual recorre todos los vértices al menos una vez
    HashSet<Integer> visitados = new HashSet<>();
    for (Arco arco : caminoAct) {
        visitados.add(arco.getVerticeOrigen());
        visitados.add(arco.getVerticeDestino());
    }
    if (visitados.size() < g.cantidadVertices()) {
        return false;
    }

    // Verificar si existen arcos en ambas direcciones para cada arco en el camino
    for (Arco arco : caminoAct) {
        int vInicial = arco.getVerticeOrigen();
        int vFinal = arco.getVerticeDestino();

        // Verificar si hay un arco en la dirección opuesta
        Arco arcoOpuesto = g.obtenerArco(vFinal, vInicial);
        if (arcoOpuesto == null) {
            return false;
        }
    }

    // Si se cumplen ambas condiciones, es una solución válida
    return true;
}










}
