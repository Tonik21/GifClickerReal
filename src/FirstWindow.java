import javax.swing.*;
import java.awt.*;

public class FirstWindow {
    private JFrame firstFrame;
    private JLabel introText;
    private JButton loadGameButton;
    private JButton endGameButton;
    private JButton saveGameButton;

    public FirstWindow() {
        firstFrame = new JFrame("GIFCLICKER");
        firstFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        firstFrame.setSize(new Dimension(900, 700));
        firstFrame.setResizable(false);
        firstFrame.setLayout(new BorderLayout());
        firstFrame.setLocationRelativeTo(null);
        init();
        firstFrame.setVisible(true);
    }

    public void init() {
        introText = new JLabel("Vítejte ve Hře", JLabel.CENTER);
        introText.setOpaque(true);
        introText.setBackground(new Color(100, 200, 100, 25)); // Pro design
        introText.setFont(new Font("Comic Sans", Font.BOLD, 50));
        introText.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        firstFrame.add(introText, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(80, 250, 80, 250));
        loadGameButton = new JButton("Start Game");
        saveGameButton = new JButton("Load Game");
        endGameButton = new JButton("Exit Game");
        panel.add(loadGameButton);
        panel.add(saveGameButton);
        panel.add(endGameButton);
        firstFrame.add(panel);

        endGameButton.addActionListener(e -> System.exit(0));
        //TODO Saving The Game (Serialization)
//        saveGameButton.addActionListener();    Trida
        loadGameButton.addActionListener(e -> {
            MainWindow mw = new MainWindow();
            firstFrame.setVisible(false);
        });


    }
}
