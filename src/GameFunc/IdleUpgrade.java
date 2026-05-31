package GameFunc;

import javax.swing.*;

/**
 * upgrade which enables idle earning and also increases the rate
 */
public class IdleUpgrade extends Upgrade{
    public double fraction;
    public IdleUpgrade(int priceOfUpgrade, String nameOfUpgrade, double fraction) {
        super(priceOfUpgrade,  nameOfUpgrade);
        this.fraction = fraction;
    }

    @Override
    public void applyEffect(Player player) {
        player.setIdleUpgrade(this);
    }

    @Override
    public boolean buy(Player player) {
        if (isOwned() || player.getClicks() < getPriceOfUpgrade()){
            JOptionPane.showMessageDialog(null, "Not enough Clicks you need: " + getPriceOfUpgrade() + " clicks");
            return false;
    }
        player.setClicks(player.getClicks() - getPriceOfUpgrade());
        applyEffect(player);
        setOwned(true);
        return true;
    }

    @Override
    public String description() {
        return "- Idle: " + (fraction * 100) + "% performance\n works while offline";
    }

    @Override
    public UpgradeType getType() {
        return UpgradeType.IDLE;
    }

    @Override
    public void notEnoughMoney() {
        JOptionPane.showMessageDialog(null,"Not enough Clicks you need: " + getPriceOfUpgrade()+ " clicks");
    }
}