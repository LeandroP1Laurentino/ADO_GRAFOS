
import graph.Grafo;
import model.Local;
import model.Caminho;
import service.RotaService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // 1. Criando os prédios acadêmicos
        Local predio1 = new Local("P1", "Prédio Acadêmico 1");
        Local predio2 = new Local("P2", "Prédio Acadêmico 2");
        Local predio3 = new Local("P3", "Prédio Acadêmico 3");

        // 2. Criando as praças de alimentação
        Local praca1 = new Local("A1", "Praça de Alimentação 1");
        Local praca2 = new Local("A2", "Praça de Alimentação 2");
        Local praca3 = new Local("A3", "Praça de Alimentação 3");

        // 3. Criando os cruzamentos dos corredores
        Local corredor1 = new Local("C1", "Corredor Central");
        Local corredor2 = new Local("C2", "Corredor Lateral");

        // 4. Criando o grafo
        Grafo grafo = new Grafo();

        // 5. Adicionando as conexões e distâncias
        grafo.adicionarAresta(predio1, corredor1, 20);
        grafo.adicionarAresta(predio2, corredor1, 30);
        grafo.adicionarAresta(predio3, corredor2, 25);

        grafo.adicionarAresta(corredor1, corredor2, 15);

        grafo.adicionarAresta(corredor1, praca1, 40);
        grafo.adicionarAresta(corredor1, praca2, 25);
        grafo.adicionarAresta(corredor2, praca3, 35);

        // 6. Criando a lista de praças
        List<Local> pracas = new ArrayList<>();

        pracas.add(praca1);
        pracas.add(praca2);
        pracas.add(praca3);

        // 7. Criando o serviço de rotas
        RotaService rotaService = new RotaService(grafo);

        // 8. Menu principal
        System.out.println("==================================");
        System.out.println("   LOCALIZADOR DE PRACAS - SENAC");
        System.out.println("==================================");

        System.out.println("Escolha o predio academico:");

        System.out.println("1 - " + predio1.getNome());
        System.out.println("2 - " + predio2.getNome());
        System.out.println("3 - " + predio3.getNome());

        System.out.print("\nOpcao: ");

        int opcao = scanner.nextInt();

        Local origem = null;

        switch (opcao) {
            case 1:
                origem = predio1;
                break;

            case 2:
                origem = predio2;
                break;

            case 3:
                origem = predio3;
                break;

            default:
                System.out.println("Opcao invalida!");
                scanner.close();
                return;
        }

        // 9. Calculando as rotas
        List<Caminho> caminhos =
                rotaService.buscarPracasMaisProximas(origem, pracas);

        // 10. Exibindo os resultados
        System.out.println("\n==================================");
        System.out.println("       RESULTADO DAS ROTAS");
        System.out.println("==================================");

        System.out.println("Origem: " + origem.getNome());

        for (int i = 0; i < caminhos.size(); i++) {

            Caminho caminho = caminhos.get(i);

            System.out.println("\n" + (i + 1) + " - "
                    + caminho.getDestino().getNome());

            System.out.println("Distancia: "
                    + caminho.getDistancia() + " metros");
        }

        // 11. Identificando a praça mais próxima
        Caminho maisProximo =
                rotaService.buscarPracaMaisProxima(origem, pracas);

        if (maisProximo != null) {

            System.out.println("\n==================================");
            System.out.println("       PRACA MAIS PROXIMA");
            System.out.println("==================================");

            System.out.println("Local: "
                    + maisProximo.getDestino().getNome());

            System.out.println("Distancia: "
                    + maisProximo.getDistancia() + " metros");

        } else {
            System.out.println("Nenhuma praca foi encontrada.");
        }

        scanner.close();
    }
}
