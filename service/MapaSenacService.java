
package service;

import graph.Grafo;
import model.Local;

import java.util.ArrayList;
import java.util.List;

public class MapaSenacService {

    private Grafo grafo;

    private List<Local> predios;
    private List<Local> pracas;

    public MapaSenacService() {

        grafo = new Grafo();

        predios = new ArrayList<>();
        pracas = new ArrayList<>();

        // Prédios acadêmicos
        Local predio1 = new Local("P1", "Prédio Acadêmico 1");
        Local predio2 = new Local("P2", "Prédio Acadêmico 2");
        Local predio3 = new Local("P3", "Prédio Acadêmico 3");

        // Praças de alimentação
        Local praca1 = new Local("A1", "Praça de Alimentação 1");
        Local praca2 = new Local("A2", "Praça de Alimentação 2");
        Local praca3 = new Local("A3", "Praça de Alimentação 3");

        // Cruzamentos
        Local cruzamento1 = new Local("X1", "Cruzamento 1");
        Local cruzamento2 = new Local("X2", "Cruzamento 2");

        // Cadastrando prédios
        predios.add(predio1);
        predios.add(predio2);
        predios.add(predio3);

        // Cadastrando praças
        pracas.add(praca1);
        pracas.add(praca2);
        pracas.add(praca3);

        // Conexões dos corredores (distâncias fictícias)
        grafo.adicionarAresta(predio1, cruzamento1, 20);
        grafo.adicionarAresta(predio2, cruzamento1, 30);
        grafo.adicionarAresta(predio3, cruzamento2, 25);

        grafo.adicionarAresta(cruzamento1, cruzamento2, 15);

        grafo.adicionarAresta(cruzamento1, praca1, 40);
        grafo.adicionarAresta(cruzamento1, praca2, 25);
        grafo.adicionarAresta(cruzamento2, praca3, 35);
    }

    public Grafo getGrafo() {
        return grafo;
    }

    public List<Local> getPredios() {
        return predios;
    }

    public List<Local> getPracas() {
        return pracas;
    }
}
