/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpep2nico;




import java.util.ArrayList;


/**
 *
 * @author ilari
 */
public class Main {
    public static void main(String[] args) {
        GrafoNoDirigido grafo = new GrafoNoDirigido();
        CSVReader csvReader = new CSVReader("src/tpep2nico/dataset/dataset1.txt");
        csvReader.setGrafo(grafo);
        csvReader.read();
        
        System.out.println(grafo);
        
        
      Back backtracking = new Back();
        ArrayList<Arco> tunelCorto = backtracking.construirBack(grafo);
        System.out.println("Tecnica utilizada: Backtracking");
        System.out.print("Tunel: ");
        for(int i = 0; i < tunelCorto.size();i++){
            System.out.print("E"+tunelCorto.get(i).getVerticeOrigen()+"-E"+tunelCorto.get(i).getVerticeDestino());
            if (i< tunelCorto.size() - 1){
                System.out.print(",");
            }
        }
        System.out.println("\n"+backtracking.distanciasCaminos(tunelCorto) + "kms");
        System.out.println("Iteraciones: "+backtracking.getIteraciones());
        System.out.println(tunelCorto);

        System.out.println("------------");
        double distancia = 0;
        Greedy greedy = new Greedy();
        Integer origen = (Integer) grafo.obtenerVertices().next();
        ArrayList<NodoDijkstra> tunelCortoGreedy = greedy.caminos(grafo,origen);
        System.out.println(tunelCortoGreedy);
        System.out.println("Tecnica utilizada: Greedy");
        System.out.print("Tunel: ");
        for(int i = 1; i < tunelCortoGreedy.size();i++){
            System.out.print("E"+tunelCortoGreedy.get(i).getPadre() + "-E" +tunelCortoGreedy.get(i).getValor() );
            if (i< tunelCortoGreedy.size() - 1){
                System.out.print(",");
            }
            distancia += tunelCortoGreedy.get(i).getDistancia();
        }
        System.out.println("\n" + distancia+ "kms");
        System.out.println("Iteraciones: "+greedy.getIteraciones());
    }
}

