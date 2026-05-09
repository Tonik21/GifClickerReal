import javax.swing.*;
import java.awt.*;

public class UpgradeCard extends JPanel {
    public UpgradeCard(Upgrades upgrade, Player player, JLabel scoreLabel, boolean isMultiplier) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setMaximumSize(new Dimension(180, 100));
        setBorder(BorderFactory.createLineBorder(Color.GRAY));

        JLabel nameLabel = new JLabel(upgrade.getNameOfUpgrade());
        nameLabel.setFont(new Font("Serif", Font.BOLD, 13));

        JLabel priceLabel = new JLabel("- Price: " + upgrade.getPriceOfUpgrade());
        JLabel descLabel = new JLabel(isMultiplier
                ? "- Multiplier: x" + upgrade.getMultiplier()
                : "- Strength: +" + upgrade.getStrengthOfClicks());

        JButton buyButton = new JButton("BUY");
        buyButton.setAlignmentX(Component.RIGHT_ALIGNMENT);
        buyButton.addActionListener(e -> {
            if (isMultiplier){
                if (upgrade.buyMultBasedUpgrade(player)){
                    buyButton.setText("OWNED");
                    buyButton.setEnabled(false);
                }
            }else{
               if (upgrade.buyClickStrengthBasedUpgrade(player)){
                   buyButton.setText("OWNED");
                   buyButton.setEnabled(false);
            }}
        });
}}
