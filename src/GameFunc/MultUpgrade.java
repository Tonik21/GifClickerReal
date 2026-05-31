package GameFunc;

import javax.swing.*;

/**
 * upgrade which increases the click multiplier
 */
public class MultUpgrade extends Upgrade{
    private double multiplier;
    public MultUpgrade(int priceOfUpgrade,String nameOfUpgrade, double multiplier ) {
        super(priceOfUpgrade, nameOfUpgrade);
        this.multiplier = multiplier;
    }

    @Override
    public void applyEffect(Player player) {
        player.setClicksMultiplier(player.getClicksMultiplier() + multiplier);
    }

    @Override
    public boolean buy(Player player) {
        if (player.getClicks() < getPriceOfUpgrade()) {
            notEnoughMoney();
            return false;
        } else {
            player.setClicks(player.getClicks() - getPriceOfUpgrade());
            applyEffect(player);
            setOwned(true);
            return true;
        }
    }


    @Override
    public String description() {
        return "- Multiplier: " + multiplier;
    }

    @Override
    public UpgradeType getType() {
        return UpgradeType.MULTIPLIER;
    }

    @Override
    public void notEnoughMoney() {
        JOptionPane.showMessageDialog(null,"Not enough Clicks you need: " + getPriceOfUpgrade()+ " clicks");
    }
}
