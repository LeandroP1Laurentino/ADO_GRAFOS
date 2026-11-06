
package service;

import algorithm.Dijkstra;
import graph.Grafo;
import model.Local;
import model.Caminho;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RotaService {

    private Grafo grafo;

    public RotaService(Grafo grafo) {
        this.grafo = grafo;
    }

    // Calcula as distâncias entre o prédio e todos os locais
    public List<Caminho> buscarPracasMaisProximas(
            Local origem, List<Local> pracas) {

        Map<Local, Double> distancias =
                Dijkstra.calcularMenoresDistancias(grafo, origem);

        List<Caminho> caminhos = new ArrayList<>();

        // Cria um caminho para cada praça
        for (Local praca : pracas) {

            double distancia = distancias.get(praca);

            if (distancia != Double.POSITIVE_INFINITY) {
                Caminho caminho = new Caminho(praca, distancia);
                caminhos.add(caminho);
            }
        }

        // Ordena as praças pela menor distância
        caminhos.sort(
            (a, b) -> Double.compare(
                a.getDistancia(),
                b.getDistancia()
            )
        );

        return caminhos;
    }

    // Retorna a praça mais próxima
    public Caminho buscarPracaMaisProxima(
            Local origem, List<Local> pracas) {

        List<Caminho> caminhos =
                buscarPracasMaisProximas(origem, pracas);

        if (caminhos.isEmpty()) {
            return null;
        }

        return caminhos.get(0);
    }
}
