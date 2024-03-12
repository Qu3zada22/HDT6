import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class HashMapCardManager implements CardManager {
    @Override
    public void loadCards(Map<String, String> cardMap, String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("\\|");
            if (parts.length == 2) {
                cardMap.put(parts[0].trim(), parts[1].trim());
            }
        }
        reader.close();
    }

    @Override
    public void addCard(Map<String, Integer> userCardMap, String cardName) {
        // Implementación para agregar una carta al mapa del usuario
    }

    @Override
    public String getCardType(Map<String, String> cardMap, String cardName) {
        // Implementación para obtener el tipo de una carta específica
        return null;
    }

    @Override
    public void showUserCards(Map<String, Integer> userCardMap, Map<String, String> cardMap) {
        // Implementación para mostrar las cartas del usuario
    }

    @Override
    public void showUserCardsSortedByType(Map<String, Integer> userCardMap, Map<String, String> cardMap) {
        // Implementación para mostrar las cartas del usuario ordenadas por tipo
    }

    @Override
    public void showAllCards(Map<String, String> cardMap) {
        // Implementación para mostrar todas las cartas disponibles
    }

    @Override
    public void showAllCardsSortedByType(Map<String, String> cardMap) {
        // Implementación para mostrar todas las cartas disponibles ordenadas por tipo
    }
}
