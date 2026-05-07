import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;


public class MainWindow  {
    JFrame gameWindow;
    JPanel panel;
    JButton gifButton;
    JPanel leftPanel;
    List<Icon> frames = new ArrayList<>();
    public MainWindow() {
        makeGifList(frames);
        gameWindow = new JFrame("CLICK CLICK CLICK! ");
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow.setSize(new Dimension(900, 700));
        gameWindow.setResizable(false);
        gameWindow.setLayout(new BorderLayout());
        gameWindow.setLocationRelativeTo(null);
        init();
        gameWindow.setVisible(true);
    }//TODO BetterLayout
    public void init(){
        gifButton = new JButton();
        gifButton.setIcon(frames.getFirst());
        panel = new JPanel();
        gifButton.setContentAreaFilled(false);
        gifButton.setBorderPainted(false);
        gifButton.setFocusPainted(false);
        gifButton.setCursor(new Cursor(Cursor.HAND_CURSOR));


        //TODO Fix problem with no pictures
        gifButton.addMouseListener(new MouseAdapter() {
            int counter = 0;

            @Override
            public void mouseClicked(MouseEvent e) {
                gifButton.setIcon(frames.get(counter));
                counter = (counter + 1) % frames.size();
            }
        });
        panel.setLayout(new GridBagLayout());
        panel.add(gifButton);
        gameWindow.add(panel, BorderLayout.CENTER);
    }


    public void makeGifList(List<Icon> list){
        for (int i = 0; i < 20; i++) {
            list.add(new ImageIcon(getClass().getResource("/Asset/P"+(i+1)+".jpg")));
        }
    }
}
