
import graph.Grafo;
import model.Local;
import model.Caminho;
import service.RotaService;
import service.MapaSenacService;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // 1. Criando o mapa do SENAC
        MapaSenacService mapa = new MapaSenacService();

        // 2. Obtendo o grafo, prédios e praças
        Grafo grafo = mapa.getGrafo();

        List<Local> predios = mapa.getPredios();

        List<Local> pracas = mapa.getPracas();

        // 3. Criando o serviço de rotas
        RotaService rotaService = new RotaService(grafo);

        // 4. Exibindo o menu
        System.out.println("==================================");
        System.out.println("     LOCALIZADOR DE PRACAS SENAC");
        System.out.println("==================================");

        System.out.println("\nEscolha o predio academico:\n");

        for (int i = 0; i < predios.size(); i++) {

            System.out.println((i + 1) + " - "
                    + predios.get(i).getNome());
        }

        System.out.print("\nOpcao: ");

        int opcao = scanner.nextInt();

        // 5. Validando a escolha
        if (opcao < 1 || opcao > predios.size()) {

            System.out.println("Opcao invalida!");

            scanner.close();
            return;
        }

        // 6. Definindo o prédio de origem
        Local origem = predios.get(opcao - 1);

        // 7. Calculando as distâncias
        List<Caminho> caminhos =
                rotaService.buscarPracasMaisProximas(origem, pracas);

        // 8. Exibindo os resultados
        System.out.println("\n==================================");
        System.out.println("          RESULTADO");
        System.out.println("==================================");

        System.out.println("\nOrigem: " + origem.getNome());

        for (int i = 0; i < caminhos.size(); i++) {

            Caminho caminho = caminhos.get(i);

            System.out.println("\n" + (i + 1) + " - "
                    + caminho.getDestino().getNome());

            System.out.println("Distancia: "
                    + caminho.getDistancia() + " metros");
        }

        // 9. Identificando a praça mais próxima
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

            System.out.println("\nNenhuma praca acessivel encontrada.");
        }

        scanner.close();
    }
}
