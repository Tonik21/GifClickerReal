import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class MainWindow  {
    Player pl1 = new Player();
    int counter = 0;
    JFrame gameWindow;
    JPanel panel;
    JButton gifButton;
    JButton titleScreenButton;
    JPanel leftPanel;
    JLabel scoreLabel;
    List<Icon> frames = new ArrayList<>();
    Upgrades StrengthUpgrade1 = new Upgrades(100, 0.0, 3, "SilnoPrstI");
    Upgrades StrengthUpgrade2 = new Upgrades(1000, 0.0, 7, "SilnoPrstII");
    Upgrades StrengthUpgrade3 = new Upgrades(10000, 0.0, 10, "SilnoPrstIII");
    UpgradeCard StrengthUpgradeCard1 = new UpgradeCard(StrengthUpgrade1, pl1, scoreLabel, false);
    UpgradeCard StrengthUpgradeCard2 = new UpgradeCard(StrengthUpgrade2, pl1, scoreLabel,false);
    UpgradeCard StrengthUpgradeCard3 = new UpgradeCard(StrengthUpgrade3, pl1, scoreLabel,false);
    public MainWindow() {
        makeGifList(frames);
        gameWindow = new JFrame("CLICK CLICK CLICK! ");
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow.setSize(new Dimension(1200, 900));
        gameWindow.setResizable(false);
        gameWindow.setLayout(new BorderLayout());
        gameWindow.setLocationRelativeTo(null);
        init();
        gameWindow.setVisible(true);
    }
    public void init(){
        gifButton = new JButton();
        gifButton.setIcon(frames.getFirst());
        panel = new JPanel();
        gifButton.setContentAreaFilled(false);
        gifButton.setBorderPainted(false);
        gifButton.setFocusPainted(false);



        gifButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pl1.addClicks();
                scoreLabel.setText("Clicks: " + (int) pl1.getClicks());
                gifButton.setIcon(frames.get(counter));
                counter++;
                if (counter >= frames.size()){
                    counter = 0;
                }
            }
        });
        panel.setLayout(new GridBagLayout());
        panel.add(gifButton);
        gameWindow.add(panel, BorderLayout.CENTER);

        scoreLabel = new JLabel("Clicks: 0");
        scoreLabel.setHorizontalAlignment(JLabel.CENTER);
        gameWindow.add(scoreLabel, BorderLayout.NORTH);
        //TODO left Panel for multiUpgrades, right for strength click based
        leftPanel = new JPanel();
        leftPanel.setPreferredSize(new Dimension(200,700));
        leftPanel.setLayout(new BoxLayout(leftPanel,BoxLayout.Y_AXIS));
        leftPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        JLabel leftTitle = new JLabel("Click Strength");
        leftTitle.setFont(new Font("Serif", Font.BOLD, 16));
        leftTitle.setAlignmentX(Component.LEFT_ALIGNMENT);
        leftPanel.add(leftTitle);
        leftPanel.add(Box.createVerticalStrut(10));
        leftPanel.add(StrengthUpgradeCard1);
        leftPanel.add(Box.createVerticalStrut(10));
        leftPanel.add(StrengthUpgradeCard2);
        leftPanel.add(Box.createVerticalStrut(10));
        leftPanel.add(StrengthUpgradeCard3);
        leftPanel.add(Box.createVerticalStrut(10));
        titleScreenButton = new JButton("Return to title screen");
        titleScreenButton.addActionListener(e->{
            AreYouSureWindow areYouSureWindow = new AreYouSureWindow(this);
        });
        leftPanel.add(Box.createVerticalGlue()); // odtlaci cudlik dolu
        leftPanel.add(titleScreenButton);
        gameWindow.add(leftPanel, BorderLayout.EAST);
    }

    public void closeWindow(){
        gameWindow.dispose();//muze byt i .setVisible(false); I guess
    }
    public void makeGifList(List<Icon> list){
        for (int i = 0; i < 20; i++) {
            list.add(new ImageIcon(Objects.requireNonNull(getClass().getResource("/Asset/P" + (i + 1) + ".jpg"))));
        }
    }
}
