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
        panel.setLayout(new GridLayout(3, 1, 10, 10));
        gameWindow.add(panel);
        //TODO Fix problem with no pictures
        gifButton.addMouseListener(new MouseAdapter() {
            int counter = 0;
            @Override
            public void mouseClicked(MouseEvent e) {
                gifButton.setIcon(frames.get(counter));
                if (counter == frames.size()){
                    counter = 0;
                }
                counter++;

            }

        });
        panel.add(gifButton);
    }


    public void makeGifList(List<Icon> list){
        for (int i = 0; i < 10; i++) {
            list.add(new ImageIcon("Assets/frame_0"+i+"_delay-0.2s.gif"));
        }
        for (int i = 10; i < 20; i++) {
            list.add(new ImageIcon("Assets/frame_"+i+"_delay-0.2s.gif"));
        }
    }
}
