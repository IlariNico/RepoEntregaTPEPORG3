/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpep2nico;


import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author ilari
 */
public class Greedy {

    private static int iteraciones;
    public Greedy(){

        iteraciones = 0;
    }

    public int getIteraciones() {
        return iteraciones;
    }

    
    
    public ArrayList<NodoDijkstra> caminos(Grafo g, int origen) {
    ArrayList<NodoDijkstra> solucion = new ArrayList<>();
    ArrayList<Integer> vConsiderados = new ArrayList<>();
    ArrayList<Integer> vertices = new ArrayList<>();
    Iterator it = g.obtenerVertices();
   
    while (it.hasNext()) {
        int i=(Integer)it.next();
            vertices.add(i);
            solucion.add(new NodoDijkstra(i,Integer.MAX_VALUE,Integer.MAX_VALUE));
    }
    solucion.get(obtenerIndice(origen,solucion)).setDistancia(0);
    solucion.get(obtenerIndice(origen,solucion)).setPadre(origen);
    while (!vConsiderados.containsAll(vertices)) {
        int u = seleccionarVertice(vConsiderados, solucion).getValor();
        vConsiderados.add(u);
        
        int indice = obtenerIndice(u, solucion);
        
        ArrayList<Integer> ady = adyacentesNoVisitados(g, u, vConsiderados);
        
        for (Integer i : ady) {
            iteraciones++;
            int posi = obtenerIndice(i, solucion);
            
            int dist = (Integer) g.obtenerArco(u, i).getEtiqueta();
            int nuevaDistancia = solucion.get(indice).getDistancia() + dist;
            if (nuevaDistancia < solucion.get(posi).getDistancia()) {
                solucion.get(posi).setDistancia(nuevaDistancia);
                solucion.get(posi).setPadre(u);
                
            }
        }
        iteraciones++;
    }

    return solucion;
}


   
    public ArrayList<Integer> adyacentesNoVisitados(Grafo g, int v, ArrayList<Integer> vConsiderados){
        ArrayList<Integer> ady=new ArrayList();
        Iterator it=g.obtenerAdyacentes(v);
        while(it.hasNext()){
            int i=(Integer)it.next();
            if(!vConsiderados.contains(i))
                ady.add(i);
        }
        return ady;
    }
    
   
    public NodoDijkstra seleccionarVertice(ArrayList<Integer> vConsiderados,ArrayList<NodoDijkstra> vertices){
        NodoDijkstra v=null;
        for(NodoDijkstra n:vertices){
            if((v==null)||(n.getDistancia()<v.getDistancia()))
                if(!vConsiderados.contains(n.getValor()))
                v=n;
        }
        return v;
    }
    
    public int obtenerIndice(int v,ArrayList<NodoDijkstra> a){
        int pos=0;
        for(NodoDijkstra n:a){
            if(n.getValor()==v)
                return pos;
            pos++;
        }
        return Integer.MAX_VALUE;
    }
    
}
