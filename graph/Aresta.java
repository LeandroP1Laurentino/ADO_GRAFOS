
package graph;

import model.Local;

public class Aresta {

    private Local origem;
    private Local destino;
    private double distancia;

    public Aresta(Local origem, Local destino, double distancia) {
        this.origem = origem;
        this.destino = destino;
        this.distancia = distancia;
    }

    public Local getOrigem() {
        return origem;
    }

    public Local getDestino() {
        return destino;
    }

    public double getDistancia() {
        return distancia;
    }
}
