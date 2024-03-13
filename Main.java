import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> cardMap = new HashMap<>();
        Map<String, Integer> userCardMap = new HashMap<>();
        CardManager cardManager = null;

        System.out.println("Selecciona la implementación de Map:");
        System.out.println("1. HashMap");
        System.out.println("2. TreeMap");
        System.out.println("3. LinkedHashMap");
        System.out.println("4. Ejecicion para profier");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                cardManager = new HashMapCardManager();
                break;
            case 2:
                cardManager = new TreeMapCardManager();
                break;
            case 3:
                cardManager = new LinkedHashMapCardManager();
                break;
            case 4:
                cardManager = new HashMapCardManager();
                cardManager.loadCards(cardMap, "cartas.txt");
                long startTime1 = System.nanoTime();
                cardManager.showAllCards(cardMap);
                long endTime1 = System.nanoTime();
                long duration1 = (endTime1 - startTime1); // Tiempo en nanosegundos

                cardManager = new TreeMapCardManager();
                cardManager.loadCards(cardMap, "cartas.txt");
                long startTime2 = System.nanoTime();
                cardManager.showAllCards(cardMap);
                long endTime2 = System.nanoTime();
                long duration2 = (endTime2 - startTime2); // Tiempo en nanosegundos

                cardManager = new LinkedHashMapCardManager();
                cardManager.loadCards(cardMap, "cartas.txt");
                long startTime3 = System.nanoTime();
                cardManager.showAllCards(cardMap);
                long endTime3 = System.nanoTime();
                long duration3 = (endTime3 - startTime3); // Tiempo en nanosegundos

                System.out.println("Tiempo de ejecución total: " + duration1 + " milisegundos");
                System.out.println("Tiempo de ejecución total: " + duration2 + " milisegundos");
                System.out.println("Tiempo de ejecución total: " + duration3 + " milisegundos");
                System.exit(0);
                break;
            default:
                System.out.println("Opción no válida. Saliendo del programa...");
                System.exit(0);
        }

        try {
            cardManager.loadCards(cardMap, "cartas.txt");
        } catch (IOException e) {
            System.out.println("Error al cargar las cartas: " + e.getMessage());
            System.exit(1);
        }

        while (true) {
            System.out.println("\nElije una opción:");
            System.out.println("1. Agregar una carta");
            System.out.println("2. Mostrar tipo de carta");
            System.out.println("3. Mostrar todas las cartas del usuario");
            System.out.println("4. Mostrar todas las cartas del usuario ordenadas por tipo");
            System.out.println("5. Mostrar todas las cartas disponibles");
            System.out.println("6. Mostrar todas las cartas disponibles ordenadas por tipo");
            System.out.println("7. Salir");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea después de la opción

            switch (option) {
                case 1:
                    System.out.println("Ingrese el nombre de la carta que desea agregar:");
                    String cardName = scanner.nextLine();
                    cardManager.addCard(userCardMap, cardName);
                    break;
                case 2:
                    System.out.println("Ingrese el nombre de la carta:");
                    String card = scanner.nextLine();
                    String type = cardManager.getCardType(cardMap, card);
                    System.out.println("Tipo de carta: " + type);
                    break;
                case 3:
                    cardManager.showUserCards(userCardMap, cardMap);
                    break;
                case 4:
                    cardManager.showUserCardsSortedByType(userCardMap, cardMap);
                    break;
                case 5:
                    cardManager.showAllCards(cardMap);
                    break;
                case 6:
                    cardManager.showAllCardsSortedByType(cardMap);
                    break;
                case 7:
                    System.out.println("Saliendo del programa...");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                    break;
            }
        }
    }
}
