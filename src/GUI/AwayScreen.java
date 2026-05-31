package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Dialog shown after loading game save, it displays the amount of clicks gotten while offline
 */
public class AwayScreen extends JDialog {

    public AwayScreen(JFrame parent, double earnedClicks) {
        super(parent, "Welcome Back!", true);

        setSize(400, 250);
        setLocationRelativeTo(parent);
        setResizable(false);
        setLayout(new BorderLayout());


        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(new Color(245, 245, 245));


        JLabel titleLabel = new JLabel("While you were away...");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 22));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);


        JLabel moneyLabel = new JLabel("+" + (int) earnedClicks + " Clicks");
        moneyLabel.setFont(new Font("Serif", Font.BOLD, 28));
        moneyLabel.setForeground(new Color(46, 139, 87));
        moneyLabel.setAlignmentX(Component.CENTER_ALIGNMENT);


        JButton collectButton = new JButton("OK");
        collectButton.setFont(new Font("Serif", Font.BOLD, 16));
        collectButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        collectButton.setPreferredSize(new Dimension(150, 40));
        collectButton.setMaximumSize(new Dimension(150, 40));
        collectButton.addActionListener(e -> dispose());


        mainPanel.add(titleLabel);
        mainPanel.add(Box.createVerticalStrut(25));
        mainPanel.add(moneyLabel);
        mainPanel.add(Box.createVerticalStrut(30));
        mainPanel.add(collectButton);

        add(mainPanel, BorderLayout.CENTER);
        setVisible(true);
    }
}