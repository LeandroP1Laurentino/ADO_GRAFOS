
package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Local;

public class Grafo {

    private Map<Local, List<Aresta>> adjacencias;

    public Grafo() {
        adjacencias = new HashMap<>();
    }

    // Adiciona um local ao grafo
    public void adicionarLocal(Local local) {
        adjacencias.putIfAbsent(local, new ArrayList<>());
    }

    // Adiciona uma conexão entre dois locais
    public void adicionarAresta(Local origem, Local destino, double distancia) {

        adicionarLocal(origem);
        adicionarLocal(destino);

        Aresta aresta1 = new Aresta(origem, destino, distancia);
        Aresta aresta2 = new Aresta(destino, origem, distancia);

        adjacencias.get(origem).add(aresta1);
        adjacencias.get(destino).add(aresta2);
    }

    // Retorna as conexões de um local
    public List<Aresta> getVizinhos(Local local) {
        return adjacencias.getOrDefault(local, new ArrayList<>());
    }

    // Retorna todos os locais do grafo
    public Map<Local, List<Aresta>> getAdjacencias() {
        return adjacencias;
    }
}
