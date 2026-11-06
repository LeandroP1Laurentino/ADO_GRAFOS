package model;

public class Caminho {

    private Local destino;
    private double distancia;

    public Caminho(Local destino, double distancia) {
        this.destino = destino;
        this.distancia = distancia;
    }

    public Local getDestino() {
        return destino;
    }

    public double getDistancia() {
        return distancia;
    }
}