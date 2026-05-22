import javax.swing.*;
import java.awt.*;

public class FirstWindow {
    private JFrame firstFrame;
    private JLabel introText;
    private JButton playGameButton;
    private JButton endGameButton;
    private JButton loadGameButton;

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
        introText = new JLabel("Welcome to the game", JLabel.CENTER);
        introText.setOpaque(true);
        introText.setBackground(new Color(100, 200, 100, 25)); // Pro design
        introText.setFont(new Font("Comic Sans", Font.BOLD, 50));
        introText.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        firstFrame.add(introText, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(80, 250, 80, 250));
        playGameButton = new JButton("Start Game");
        loadGameButton = new JButton("Load Game");
        endGameButton = new JButton("Exit Game");
        panel.add(playGameButton);
        panel.add(loadGameButton);
        panel.add(endGameButton);
        firstFrame.add(panel);

        endGameButton.addActionListener(e -> System.exit(0));
        //TODO Saving The Game (Serialization)
        loadGameButton.addActionListener(e -> {
            Player loaded = Savegame.load();
            new MainWindow(loaded);
            firstFrame.setVisible(false);
        });
        playGameButton.addActionListener(e -> {
            MainWindow mw = new MainWindow(new Player());
            firstFrame.setVisible(false);
        });


    }
}
