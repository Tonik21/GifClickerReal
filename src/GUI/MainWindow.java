package GUI;

import GameFunc.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Contains the Main window with the click button and panels containing the different types of updates
 */
public class MainWindow {
    Player pl1;
    int counter = 0;
    JFrame gameWindow;
    JPanel panel;
    JPanel rightPanel;
    JPanel leftPanel;
    JButton gifButton;
    JButton titleScreenButton;
    JPanel idlePanel;
    JLabel scoreLabel = new JLabel("Clicks: 0 | Strength: 1 | Multiplier: x1.0");

    List<Icon> frames = new ArrayList<>();



    public MainWindow(Player player, double offlineEarned) {
        this.pl1 = player;

        makeGifList(frames);
        gameWindow = new JFrame("CLICK CLICK CLICK!");
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow.setSize(new Dimension(1400, 1000));
        gameWindow.setResizable(false);
        gameWindow.setLayout(new BorderLayout());
        gameWindow.setLocationRelativeTo(null);
        init();
        gameWindow.setVisible(true);
        if (offlineEarned>0){
            AwayScreen aS = new AwayScreen(gameWindow, offlineEarned);
        }
    }

    public void init() {
        scoreLabel.setHorizontalAlignment(JLabel.CENTER);
        gameWindow.add(scoreLabel, BorderLayout.NORTH);


        gifButton = new JButton();
        gifButton.setIcon(frames.getFirst());
        gifButton.setContentAreaFilled(false);
        gifButton.setBorderPainted(false);
        gifButton.setFocusPainted(false);
        gifButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        gifButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pl1.addClicks();
                updateScoreLabel();
                gifButton.setIcon(frames.get(counter));
                counter = (counter + 1) % frames.size();
            }
        });

        panel = new JPanel(new GridBagLayout());
        panel.add(gifButton);
        gameWindow.add(panel, BorderLayout.CENTER);

        leftPanel = new JPanel();
        leftPanel.setPreferredSize(new Dimension(300, 1000));
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel leftTitle = new JLabel("Strength");
        leftTitle.setFont(new Font("Serif", Font.BOLD, 16));
        leftTitle.setAlignmentX(Component.LEFT_ALIGNMENT);
        leftPanel.add(leftTitle);
        leftPanel.add(Box.createVerticalStrut(10));


        idlePanel = new JPanel();
        idlePanel.setPreferredSize(new Dimension(800, 200));
        idlePanel.setLayout(new BoxLayout(idlePanel, BoxLayout.X_AXIS));
        idlePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        idlePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel idleTitle = new JLabel("Idle");
        idleTitle.setFont(new Font("Serif", Font.BOLD, 16));
        idleTitle.setAlignmentX(Component.LEFT_ALIGNMENT);
        idlePanel.add(idleTitle);

        rightPanel = new JPanel();
        rightPanel.setPreferredSize(new Dimension(300, 1000));
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel rightTitle = new JLabel("Multiplier");
        rightTitle.setFont(new Font("Serif", Font.BOLD, 16));
        rightTitle.setAlignmentX(Component.LEFT_ALIGNMENT);
        rightPanel.add(rightTitle);
        rightPanel.add(Box.createVerticalStrut(10));

        for (Upgrade upgrade : pl1.getUpgrades()) {
            UpgradeCard card = new UpgradeCard(upgrade, pl1, this);
            switch (upgrade.getType()) {
                case UpgradeType.MULTIPLIER :
                    rightPanel.add(card);rightPanel.add(Box.createVerticalStrut(10));break;
                case UpgradeType.STRENGTH :
                    leftPanel.add(card);leftPanel.add(Box.createVerticalStrut(10));break;
                case UpgradeType.IDLE :
                    idlePanel.add(card); idlePanel.add(Box.createVerticalStrut(10));break;
            }


        }

        JPanel bottomButtons = new JPanel(new GridLayout(2, 1, 0, 5));
        bottomButtons.setMaximumSize(new Dimension(180, 80));

        Savegame saveButton = new Savegame(pl1);
        titleScreenButton = new JButton("Title screen");
        titleScreenButton.addActionListener(e -> {
            int answer = JOptionPane.showConfirmDialog(null, "Are you sure?","Choice", JOptionPane.YES_NO_OPTION);
            if (answer == JOptionPane.YES_OPTION){
                FirstWindow firstWindow = new FirstWindow();
                gameWindow.dispose();
            }

        });

        bottomButtons.add(saveButton);
        bottomButtons.add(titleScreenButton);
        leftPanel.add(Box.createVerticalGlue());
        leftPanel.add(bottomButtons);
        gameWindow.add(leftPanel, BorderLayout.WEST);
        gameWindow.add(rightPanel, BorderLayout.EAST);
        JPanel southWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER));
        southWrapper.setPreferredSize(new Dimension(1400, 220));
        southWrapper.add(idlePanel);
        gameWindow.add(southWrapper, BorderLayout.SOUTH);
    }
    public void updateScoreLabel(){
        scoreLabel.setText("Clicks: " + (int) pl1.getClicks()
                + " | Strength: " + pl1.getStrengthOfClicks()
                + " | Multiplier: x" + pl1.getClicksMultiplier());
    }
    /**
     * Loads all 20 game frames from the Asset folder into the provided list.
     * @param list the list in which there will be the images
     */
    public void makeGifList(List<Icon> list) {
        for (int i = 0; i < 20; i++) {
            list.add(new ImageIcon(Objects.requireNonNull(
                    getClass().getResource("/Asset/P" + (i + 1) + ".jpg"))));
        }
    }
}