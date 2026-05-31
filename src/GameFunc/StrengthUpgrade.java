package GameFunc;

import javax.swing.*;

/**
 * upgrade which increases the click Strength
 */
public class StrengthUpgrade extends Upgrade{
    private int strengthOfClicks;

    public StrengthUpgrade(int priceOfUpgrade, String nameOfUpgrade, int strengthOfClick) {
        super(priceOfUpgrade, nameOfUpgrade);
        this.strengthOfClicks = strengthOfClick;
    }

    @Override
    public void applyEffect(Player player) {
        player.setStrengthOfClicks(player.getStrengthOfClicks() + strengthOfClicks);
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
        return "-Strength: " + strengthOfClicks;
    }

    @Override
    public UpgradeType getType() {
        return UpgradeType.STRENGTH;
    }

    @Override
    public void notEnoughMoney() {
        JOptionPane.showMessageDialog(null, " Not enough Clicks you need: " + getPriceOfUpgrade()+ " clicks");
    }
}
