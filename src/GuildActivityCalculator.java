import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuildActivityCalculator {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Guild Activity Calculator");
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(6, 2));

        JTextField playtimeField = new JTextField();
        JTextField chestsField = new JTextField();
        JTextField raidsField = new JTextField();
        JTextField warcountField = new JTextField();
        JTextField resultField = new JTextField();
        resultField.setEditable(false);

        JButton calculateButton = new JButton("Calculate");

        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double playtime = Double.parseDouble(playtimeField.getText());
                    double chests = Double.parseDouble(chestsField.getText());
                    double raids = Double.parseDouble(raidsField.getText());
                    double warcount = Double.parseDouble(warcountField.getText());

                    // Calculate percentage for each category (max 50%)
                    double playtimeScore = Math.min(playtime / 4.0, 1.0) * 50;
                    double chestsScore = Math.min(chests / 200.0, 1.0) * 50;
                    double raidsScore = Math.min(raids / 15.0, 1.0) * 50;
                    double warcountScore = Math.min(warcount / 30.0, 1.0) * 50;

                    // Total score out of 100
                    double totalScore = playtimeScore + chestsScore + raidsScore + warcountScore;

                    // Display result
                    String status = (totalScore >= 75) ? "✅ You are safe!" : "❌ You will be kicked!";
                    resultField.setText(String.format("%.2f%% - %s", totalScore, status));

                } catch (NumberFormatException ex) {
                    resultField.setText("Invalid input");
                }
            }
        });

        frame.add(new JLabel("Playtime (hours):"));
        frame.add(playtimeField);
        frame.add(new JLabel("Chests Opened:"));
        frame.add(chestsField);
        frame.add(new JLabel("Raids Completed:"));
        frame.add(raidsField);
        frame.add(new JLabel("War Participation:"));
        frame.add(warcountField);
        frame.add(calculateButton);
        frame.add(resultField);

        frame.setVisible(true);
    }
}
