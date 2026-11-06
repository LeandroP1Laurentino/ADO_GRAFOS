
package algorithm;

import graph.Grafo;
import graph.Aresta;
import model.Local;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Dijkstra {

    public static Map<Local, Double> calcularMenoresDistancias(
            Grafo grafo, Local origem) {

        Map<Local, Double> distancias = new HashMap<>();

        PriorityQueue<Local> fila = new PriorityQueue<>(
            (a, b) -> Double.compare(
                distancias.get(a),
                distancias.get(b)
            )
        );

        // Inicializa as distâncias
        for (Local local : grafo.getAdjacencias().keySet()) {
            distancias.put(local, Double.POSITIVE_INFINITY);
        }

        distancias.put(origem, 0.0);

        fila.add(origem);

        // Processa os locais
        while (!fila.isEmpty()) {

            Local atual = fila.poll();

            double distanciaAtual = distancias.get(atual);

            // Percorre os vizinhos do local atual
            for (Aresta aresta : grafo.getVizinhos(atual)) {

                Local vizinho = aresta.getDestino();

                double novaDistancia =
                    distanciaAtual + aresta.getDistancia();

                // Verifica se encontrou um caminho menor
                if (novaDistancia < distancias.get(vizinho)) {

                    distancias.put(vizinho, novaDistancia);

                    fila.remove(vizinho);
                    fila.add(vizinho);
                }
            }
        }

        return distancias;
    }
}
