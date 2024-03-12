import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

// Interfaz para el Mapa de cartas
interface CardMap {
    void addCard(String cardName, String cardType);
    String getCardType(String cardName);
    Map<String, Integer> getUserCollection();
    void displayUserCollection();
    void displayUserCollectionSortedByType();
    void displayAllCards();
    void displayAllCardsSortedByType();
}