package GUI;

import GameFunc.Player;
import GameFunc.Savegame;

import javax.swing.*;
import java.awt.*;

/**
 * First Window in which there are buttons that Load the game, Start it and End it
 */
public class FirstWindow {
    private JFrame firstFrame;
    private JLabel introText;
    private JButton playGameButton;
    private JButton endGameButton;
    private JButton loadGameButton;
    private MainWindow  mw;

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
        firstFrame.getContentPane().setBackground(new Color(30, 30, 30));


        introText = new JLabel("GIF CLICKER", JLabel.CENTER);
        introText.setFont(new Font("Serif", Font.BOLD, 55));
        introText.setForeground(Color.WHITE);
        introText.setBorder(BorderFactory.createEmptyBorder(60, 0, 0, 0));
        firstFrame.add(introText, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(new GridLayout(3, 1, 0, 12));
        panel.setBorder(BorderFactory.createEmptyBorder(80, 250, 80, 250));

        playGameButton = createStyledButton("Start Game");
        loadGameButton = createStyledButton("Load Game");
        endGameButton  = createStyledButton("Exit Game");

        panel.add(playGameButton);
        panel.add(loadGameButton);
        panel.add(endGameButton);
        firstFrame.add(panel);

        endGameButton.addActionListener(e -> System.exit(0));
        loadGameButton.addActionListener(e -> {
            String name = JOptionPane.showInputDialog("Enter the registered name:");
            if (name != null) {
                Player loaded = Savegame.load(name);
                double offlineMoney = loaded.calculateOffTime();
                loaded.setClicks(loaded.getClicks() + offlineMoney);
                loaded.resetEntrance();
                new MainWindow(loaded, offlineMoney);
                firstFrame.setVisible(false);
            }
        });
        playGameButton.addActionListener(e -> {
            mw = new MainWindow(new Player(), 0);
            firstFrame.setVisible(false);
        });
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Serif", Font.PLAIN, 18));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(55, 55, 55));
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(80, 80, 80)),
                BorderFactory.createEmptyBorder(8, 20, 8, 20)
        ));
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        return button;
    }
}
