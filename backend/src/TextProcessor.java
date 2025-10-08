package backend.src;
import java.util.*;
import java.io.*;

public class TextProcessor {

    private Set<String> badWords = new HashSet<>();

    // Load rules from file
    public void loadRules(String filePath) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = br.readLine()) != null) {
                badWords.add(line.trim().toLowerCase());
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error loading rules: " + e.getMessage());
        }
    }

    // Check if a message is bullying
    public boolean isCyberbullying(String message) {
        String[] words = message.toLowerCase().split("\\s+");
        for (String word : words) {
            if (badWords.contains(word)) {
                return true;
            }
        }
        return false;
    }
}

