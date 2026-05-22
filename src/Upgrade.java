public abstract class Upgrade {
    private String nameOfUpgrade;
    private int priceOfUpgrade;
    private boolean isOwned;

    public Upgrade(int priceOfUpgrade, String nameOfUpgrade) {
        this.priceOfUpgrade = priceOfUpgrade;
        this.isOwned = false;
        this.nameOfUpgrade = nameOfUpgrade;
    }
    public abstract boolean buy(Player player);
    public abstract String description();


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
