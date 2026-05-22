import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainWindow {
    Player pl1;
    int counter = 0;
    JFrame gameWindow;
    JPanel panel;
    JPanel rightPanel;
    JPanel leftPanel;
    JButton gifButton;
    JButton titleScreenButton;
    JLabel scoreLabel = new JLabel("Clicks: 0 | Strength: 1 | Multiplier: x1.0");

    List<Icon> frames = new ArrayList<>();
    Upgrade StrengthUpgrade1 = new Upgrade(100, 0.0, 3, "SilnoPrstI");
    Upgrade StrengthUpgrade2 = new Upgrade(1000, 0.0, 7, "SilnoPrstII");
    Upgrade StrengthUpgrade3 = new Upgrade(10000, 0.0, 10, "SilnoPrstIII");
    Upgrade MultUpgrade1 = new Upgrade(150, 1.5, 0, "RychloKlikI");
    Upgrade MultUpgrade2 = new Upgrade(1500, 3.0, 0, "RychloKlikII");
    Upgrade MultUpgrade3 = new Upgrade(15000, 6.0, 0, "RychloKlikIII");


    UpgradeCard MultUpgradeCard1;
    UpgradeCard MultUpgradeCard2;
    UpgradeCard MultUpgradeCard3;
    UpgradeCard StrengthUpgradeCard1;
    UpgradeCard StrengthUpgradeCard2;
    UpgradeCard StrengthUpgradeCard3;

    public MainWindow(Player player) {
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
    }

    public void init() {
        MultUpgradeCard1 = new UpgradeCard(MultUpgrade1, pl1, true,scoreLabel);
        MultUpgradeCard2 = new UpgradeCard(MultUpgrade2, pl1,  true,scoreLabel);
        MultUpgradeCard3 = new UpgradeCard(MultUpgrade3, pl1,  true,scoreLabel);
        StrengthUpgradeCard1 = new UpgradeCard(StrengthUpgrade1, pl1,  false,scoreLabel);
        StrengthUpgradeCard2 = new UpgradeCard(StrengthUpgrade2, pl1,  false,scoreLabel);
        StrengthUpgradeCard3 = new UpgradeCard(StrengthUpgrade3, pl1,  false,scoreLabel);


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
                scoreLabel.setText("Clicks: " + (int) pl1.getClicks()
                        + " | Strength: " + pl1.getStrengthOfClicks()
                        + " | Multiplier: x" + pl1.getClicksMultiplier());
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
        leftPanel.add(StrengthUpgradeCard1);
        leftPanel.add(Box.createVerticalStrut(10));
        leftPanel.add(StrengthUpgradeCard2);
        leftPanel.add(Box.createVerticalStrut(10));
        leftPanel.add(StrengthUpgradeCard3);
        leftPanel.add(Box.createVerticalGlue());

        JPanel bottomButtons = new JPanel(new GridLayout(2, 1, 0, 5));
        bottomButtons.setMaximumSize(new Dimension(180, 80));

        Savegame saveButton = new Savegame(pl1);
        titleScreenButton = new JButton("Title screen");
        titleScreenButton.addActionListener(e -> new AreYouSureWindow(this));

        bottomButtons.add(saveButton);
        bottomButtons.add(titleScreenButton);
        leftPanel.add(bottomButtons);


        rightPanel = new JPanel();
        rightPanel.setPreferredSize(new Dimension(300, 1000));
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel rightTitle = new JLabel("Multiplier");
        rightTitle.setFont(new Font("Serif", Font.BOLD, 16));
        rightTitle.setAlignmentX(Component.LEFT_ALIGNMENT);
        rightPanel.add(rightTitle);
        rightPanel.add(Box.createVerticalStrut(10));
        rightPanel.add(MultUpgradeCard1);
        rightPanel.add(Box.createVerticalStrut(10));
        rightPanel.add(MultUpgradeCard2);
        rightPanel.add(Box.createVerticalStrut(10));
        rightPanel.add(MultUpgradeCard3);

        gameWindow.add(leftPanel, BorderLayout.WEST);
        gameWindow.add(rightPanel, BorderLayout.EAST);
    }

    public void closeWindow() {
        gameWindow.dispose();
    }

    public void makeGifList(List<Icon> list) {
        for (int i = 0; i < 20; i++) {
            list.add(new ImageIcon(Objects.requireNonNull(
                    getClass().getResource("/Asset/P" + (i + 1) + ".jpg"))));
        }
    }
}