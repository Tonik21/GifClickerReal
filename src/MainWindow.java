import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;


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
    Upgrades upgrades = new Upgrades(100, 0.0, 3, "SilnoPrstI");
    UpgradeCard ucCheapest = new UpgradeCard(upgrades, pl1, scoreLabel, false);
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
        leftPanel.add(ucCheapest);
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
        gameWindow.dispose();
    }
    public void makeGifList(List<Icon> list){
        for (int i = 0; i < 20; i++) {
            list.add(new ImageIcon(getClass().getResource("/Asset/P"+(i+1)+".jpg")));
        }
    }
}
