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
    JPanel leftPanel;
    JLabel scoreLabel;
    List<Icon> frames = new ArrayList<>();
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
        leftPanel.setLayout(new BoxLayout(leftPanel,BoxLayout.Y_AXIS));

        leftPanel.add(Box.createVerticalGlue()); // odtlaci cudlik dolu
        leftPanel.add(new JButton("Return to title screen"));
        gameWindow.add(leftPanel, BorderLayout.EAST);
    }


    public void makeGifList(List<Icon> list){
        for (int i = 0; i < 20; i++) {
            list.add(new ImageIcon(getClass().getResource("/Asset/P"+(i+1)+".jpg")));
        }
    }
}
