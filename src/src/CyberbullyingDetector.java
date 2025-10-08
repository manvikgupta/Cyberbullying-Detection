import java.util.Arrays;
import java.util.List;

public class CyberBullyingDetector {

    // Example list of keywords indicative of cyberbullying
    private static final List<String> bullyingKeywords = Arrays.asList(
            "hate", "stupid", "idiot", "kill", "dumb", "loser"
    );

    // Method to check if the input text contains any bullying keywords
    public static boolean containsBullying(String input) {
        String lowerInput = input.toLowerCase();
        for (String keyword : bullyingKeywords) {
            if (lowerInput.contains(keyword)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Sample texts to test
        String[] testInputs = {
                "You are so stupid!",
                "Have a great day!",
                "I hate you.",
                "You are a genius!"
        };

        for (String text : testInputs) {
            if (containsBullying(text)) {
                System.out.println("Bullying detected in text: \"" + text + "\"");
            } else {
                System.out.println("No bullying detected in text: \"" + text + "\"");
            }
        }
    }
}

