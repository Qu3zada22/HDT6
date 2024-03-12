import java.io.IOException;
import java.util.Map;

public interface CardManager {
    void loadCards(Map<String, String> cardMap, String filename) throws IOException;
    void addCard(Map<String, Integer> userCardMap, String cardName);
    String getCardType(Map<String, String> cardMap, String cardName);
    void showUserCards(Map<String, Integer> userCardMap, Map<String, String> cardMap);
    void showUserCardsSortedByType(Map<String, Integer> userCardMap, Map<String, String> cardMap);
    void showAllCards(Map<String, String> cardMap);
    void showAllCardsSortedByType(Map<String, String> cardMap);
}
