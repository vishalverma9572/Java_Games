import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RockPaperScissorsGame extends JFrame implements ActionListener {
    private JLabel resultLabel;
    private JButton rockButton, paperButton, scissorsButton;

    public RockPaperScissorsGame() {
        setTitle("Rock Paper Scissors Game");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel and set its layout to BorderLayout
        JPanel panel = new JPanel(new GridLayout(2, 1));
        setContentPane(panel);

        // Create a subpanel for the buttons
        JPanel buttonPanel = new JPanel(new FlowLayout());
        resultLabel = new JLabel("Choose Rock, Paper, or Scissors");
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);

        rockButton = new JButton("Rock");
        paperButton = new JButton("Paper");
        scissorsButton = new JButton("Scissors");

        rockButton.addActionListener(this);
        paperButton.addActionListener(this);
        scissorsButton.addActionListener(this);

        buttonPanel.add(rockButton);
        buttonPanel.add(paperButton);
        buttonPanel.add(scissorsButton);

        // Add components to the main panel
        panel.add(resultLabel);
        panel.add(buttonPanel);

        // Center the frame on the screen
        setLocationRelativeTo(null);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String userChoice = e.getActionCommand();
        String computerChoice = generateComputerChoice();

        String result = determineWinner(userChoice, computerChoice);

        resultLabel.setText("You chose " + userChoice + ". Computer chose " + computerChoice + ". " + result);
    }

    private String generateComputerChoice() {
        String[] choices = {"Rock", "Paper", "Scissors"};
        Random random = new Random();
        int index = random.nextInt(choices.length);
        return choices[index];
    }

    private String determineWinner(String userChoice, String computerChoice) {
        if (userChoice.equals(computerChoice)) {
            return "It's a tie!";
        } else if ((userChoice.equals("Rock") && computerChoice.equals("Scissors")) ||
                   (userChoice.equals("Paper") && computerChoice.equals("Rock")) ||
                   (userChoice.equals("Scissors") && computerChoice.equals("Paper"))) {
            return "You win!";
        } else {
            return "You lose!";
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RockPaperScissorsGame());
    }
}
