package org.example;
import java.io.*;
import java.util.Map;
import java.util.TreeMap;

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
        userCardMap.put(cardName, userCardMap.getOrDefault(cardName, 0) + 1);
    }

    @Override
    public String getCardType(Map<String, String> cardMap, String cardName) {
        return cardMap.get(cardName);
    }

    @Override
    public void showUserCards(Map<String, Integer> userCardMap, Map<String, String> cardMap) {
        System.out.println("Cartas del usuario:");
        for (Map.Entry<String, Integer> entry : userCardMap.entrySet()) {
            System.out.println("Nombre: " + entry.getKey() + ", Tipo: " + cardMap.get(entry.getKey()) + ", Cantidad: " + entry.getValue());
        }
    }

    @Override
    public void showUserCardsSortedByType(Map<String, Integer> userCardMap, Map<String, String> cardMap) {
        // A implementar
        TreeMap<String, Integer> sortedUserCards = new TreeMap<>();
        for (Map.Entry<String, Integer> entry : userCardMap.entrySet()) {
            sortedUserCards.put(entry.getKey(), entry.getValue());
        }
        for (Map.Entry<String, Integer> entry : sortedUserCards.entrySet()) {
            System.out.println("Nombre: " + entry.getKey() + ", Tipo: " + cardMap.get(entry.getKey()) + ", Cantidad: " + entry.getValue());
        }
    }

    @Override
    public void showAllCards(Map<String, String> cardMap) {
        System.out.println("Todas las cartas disponibles:");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("showAllCards_timeHASH.csv", true))) {
            writer.write("Nombre,Tipo,Tiempo de ejecución (ms)\n"); // Encabezado fuera del bucle
            for (Map.Entry<String, String> entry : cardMap.entrySet()) {
                long startTime = System.nanoTime();
                System.out.println("Nombre: " + entry.getKey() + ", Tipo: " + entry.getValue());
                long endTime = System.nanoTime();
                long duration = (endTime - startTime);
                writer.write(startTime + "," + endTime + "," +  duration+ "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showAllCardsSortedByType(Map<String, String> cardMap) {
        // A implementar
        TreeMap<String, String> sortedCards = new TreeMap<>(cardMap);
        for (Map.Entry<String, String> entry : sortedCards.entrySet()) {
            System.out.println("Nombre: " + entry.getKey() + ", Tipo: " + entry.getValue());
        }
    }
}
