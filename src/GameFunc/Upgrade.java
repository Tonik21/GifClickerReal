package GameFunc;

import java.io.Serializable;

/**
 * This class is a pattern for all of the other upgrades
 */
public abstract class Upgrade implements Serializable {
    private String nameOfUpgrade;
    private int priceOfUpgrade;
    private boolean isOwned;
    private static final long serialVersionUID = 2L;
    public abstract void applyEffect(Player player);
    public Upgrade(int priceOfUpgrade, String nameOfUpgrade) {
        this.priceOfUpgrade = priceOfUpgrade;
        this.isOwned = false;
        this.nameOfUpgrade = nameOfUpgrade;
    }

    /**
     * For buying upgrades for player
     * @param player player buying the upgrade
     * @return true if enough money(clicks)
     */
    public abstract boolean buy(Player player);
    public abstract String description();
    public abstract UpgradeType getType();
    public abstract void notEnoughMoney();

    public String getNameOfUpgrade() {
        return nameOfUpgrade;
    }

    public int getPriceOfUpgrade() {
        return priceOfUpgrade;
    }


    public boolean isOwned() {
        return isOwned;
    }

    public void setOwned(boolean owned) {
        isOwned = owned;
    }
}
