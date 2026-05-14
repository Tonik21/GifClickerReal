import javax.swing.*;
import java.awt.*;

public class AreYouSureWindow {
    JFrame jFrame;
    JLabel text;
    MainWindow m2;
    JButton OK;
    JButton getBack;

    public AreYouSureWindow(MainWindow mainWindow) {
        m2 = mainWindow;
        jFrame = new JFrame("Return to TitleScreen");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(new Dimension(900, 500));
        jFrame.setResizable(false);
        jFrame.setLayout(new BorderLayout());
        jFrame.setLocationRelativeTo(null);
        init();
        jFrame.setVisible(true);
    }

    public void init() {
        text = new JLabel("are you SURE you want to leave the game?");
        text.setOpaque(true);
        text.setFont(new Font("Comic Sans", Font.BOLD, 50));
        text.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        jFrame.add(text, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(45, 45, 45));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(40, 20, 40, 20));


        OK = new JButton("Proceed");
        OK.setFont(new Font("Arial", Font.BOLD, 24));
        OK.setFocusPainted(false);
        OK.setBackground(new Color(200, 50, 50));
        OK.setForeground(Color.WHITE);
        OK.setPreferredSize(new Dimension(200, 70));
        OK.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));


        getBack = new JButton("Return");
        getBack.setFont(new Font("Arial", Font.BOLD, 24));
        getBack.setFocusPainted(false);
        getBack.setBackground(new Color(70, 130, 180));
        getBack.setForeground(Color.WHITE);
        getBack.setPreferredSize(new Dimension(200, 70));
        getBack.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));

        buttonPanel.add(OK);
        buttonPanel.add(Box.createHorizontalStrut(30));
        buttonPanel.add(getBack);

        jFrame.add(buttonPanel, BorderLayout.CENTER);
        OK.addActionListener(e -> {
            m2.closeWindow();
            FirstWindow firstWindow = new FirstWindow();
            jFrame.dispose();
        });
        getBack.addActionListener(e -> {
            jFrame.dispose();
        });
    }
}
