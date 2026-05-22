import javax.swing.*;
import java.awt.*;

public class UpgradeCard extends JPanel {
    public UpgradeCard(Upgrade upgrade, Player player, boolean isMultiplier, JLabel scorelabel) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setMaximumSize(new Dimension(180, 150));
        setMinimumSize(new Dimension(180, 150));
        setPreferredSize(new Dimension(180, 150));
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY),
                BorderFactory.createEmptyBorder(5, 8, 5, 8)
        ));
        JLabel nameLabel = new JLabel(upgrade.getNameOfUpgrade());
        nameLabel.setFont(new Font("Serif", Font.BOLD, 16));

        JLabel priceLabel = new JLabel("- Price: " + upgrade.getPriceOfUpgrade());
        JLabel descLabel = new JLabel(isMultiplier ? "- Multiplier: x" + upgrade.getMultiplier(): "- Strength: +" + upgrade.getStrengthOfClicks());

        JButton buyButton = new JButton("BUY");
        buyButton.setMaximumSize(new Dimension(80, 25));
        buyButton.setFont(new Font("Serif", Font.PLAIN, 10));
        buyButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        buyButton.addActionListener(e -> {
            if (isMultiplier){
                if (upgrade.buyMultBasedUpgrade(player)){
                    buyButton.setText("OWNED");
                    scorelabel.setText("Clicks: " + (int) player.getClicks()
                            + " | Strength: " + player.getStrengthOfClicks()
                            + " | Multiplier: x" + player.getClicksMultiplier());
                    buyButton.setEnabled(false);
                }
            }else{
               if (upgrade.buyClickStrengthBasedUpgrade(player)){
                   buyButton.setText("OWNED");
                   scorelabel.setText("Clicks: " + ((int) player.getClicks())
                           + " | Strength: " + player.getStrengthOfClicks()
                           + " | Multiplier: x" + player.getClicksMultiplier());
                   buyButton.setEnabled(false);
            }}
        });
        add(nameLabel);
        add(priceLabel);
        add(descLabel);
        add(buyButton);
}}
