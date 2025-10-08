package frontend.src;

import backend.src.TextProcessor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainUI extends JFrame {

    private JTextArea inputArea;
    private JButton checkButton;
    private JLabel resultLabel;
    private TextProcessor processor;

    public MainUI() {
        super("Cyberbullying Detection");

        processor = new TextProcessor();
        processor.loadRules("rules/bad_words.txt");

        inputArea = new JTextArea(5, 30);
        checkButton = new JButton("Check Message");
        resultLabel = new JLabel("Type a message and click Check.");

        checkButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String message = inputArea.getText();
                boolean isBullying = processor.isCyberbullying(message);
                if (isBullying) {
                    resultLabel.setText("⚠️ Bullying Detected!");
                    resultLabel.setForeground(Color.RED);
                } else {
                    resultLabel.setText("✅ Message is Safe.");
                    resultLabel.setForeground(Color.GREEN.darker());
                }
            }
        });

        setLayout(new FlowLayout());
        add(new JScrollPane(inputArea));
        add(checkButton);
        add(resultLabel);

        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainUI();
    }
}

