import javax.swing.*;
import java.awt.*;

public class UpgradeCard extends JPanel {
    public UpgradeCard(Upgrade upgrade, Player player, MainWindow mainWindow) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setMaximumSize(new Dimension(150, 100));
        setMinimumSize(new Dimension(150, 100));
        setPreferredSize(new Dimension(150, 100));
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY),
                BorderFactory.createEmptyBorder(5, 8, 5, 8)
        ));
        JLabel nameLabel = new JLabel(upgrade.getNameOfUpgrade());
        nameLabel.setFont(new Font("Serif", Font.BOLD, 16));

        JLabel priceLabel = new JLabel("- Price: " + upgrade.getPriceOfUpgrade());
        JLabel descLabel = new JLabel(upgrade.description());


        JButton buyButton = new JButton();
        buyButton.setMaximumSize(new Dimension(80, 25));
        buyButton.setFont(new Font("Serif", Font.PLAIN, 10));
        buyButton.setAlignmentX(Component.LEFT_ALIGNMENT);


        if (upgrade.isOwned()) {
            buyButton.setText("OWNED");
            buyButton.setEnabled(false);
        } else {
            buyButton.setText("BUY");
            buyButton.addActionListener(e -> {
                if (upgrade.buy(player)) {
                    buyButton.setText("OWNED");
                    buyButton.setEnabled(false);
                    mainWindow.updateScoreLabel();

                }
            });
        }
        add(nameLabel);
        add(priceLabel);
        add(descLabel);
        add(buyButton);
}


}
