package pck01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Dijkstra {
	
    public void processaCaminho(Vertice vertice)
    {
	vertice.distanciaMinima = 0.;
        PriorityQueue<Vertice> filaVertice = new PriorityQueue<Vertice>();
        filaVertice.add(vertice);	
        while (!filaVertice.isEmpty()) 
        {
            Vertice verticeAux = filaVertice.poll();
            // Visita se existir aresta ligada ao vertice
            for (Aresta aresta : verticeAux.vizinho)
            {
                Vertice v = aresta.trajeto;
                double custo = aresta.custo;
                double distanciaMinima = verticeAux.distanciaMinima + custo;
                if (distanciaMinima < v.distanciaMinima) 
                {
                    filaVertice.remove(v);
                    v.distanciaMinima = distanciaMinima ;
                    v.anterior = verticeAux;
                    filaVertice.add(v);
                }
            }
        }
    }

    public ArrayList<Vertice> getMenorCaminho(Vertice destino)
    {
    	ArrayList<Vertice> listVertice = new ArrayList<Vertice>();
        for (Vertice vertice = destino; vertice != null; vertice = vertice.anterior)
            listVertice.add(vertice);
        Collections.reverse(listVertice);
        return listVertice;
    }
    
}

