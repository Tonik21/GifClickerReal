public class Upgrades {
    private String nameOfUpgrade;
    private int priceOfUpgrade;
    private double multiplier;
    private int strengthOfClicks;
    private boolean isOwned;

    public Upgrades(int priceOfUpgrade, double multiplier, int strengthOfClicks, String nameOfUpgrade) {
        this.priceOfUpgrade = priceOfUpgrade;
        this.multiplier = multiplier;
        this.strengthOfClicks = strengthOfClicks;
        this.isOwned = false;
        this.nameOfUpgrade = nameOfUpgrade;
    }

    public boolean buyMultBasedUpgrade(Player player) {
        if (player.getClicks() < priceOfUpgrade) {
            System.out.println("Not enough Clicks you need: " + priceOfUpgrade + " clicks");
            return false;
        } else {
            player.setClicks(player.getClicks() - priceOfUpgrade);
            player.setClicksMultiplier(player.getClicksMultiplier() + multiplier);
            isOwned = true;
            return true;
        }
    }

    public boolean buyClickStrengthBasedUpgrade(Player player) {
        if (player.getClicks() < priceOfUpgrade) {
            System.out.println("Not enough Clicks you need: " + priceOfUpgrade + " clicks");
            return false;
        } else {
            player.setClicks(player.getClicks() - priceOfUpgrade);
            player.setStrengthOfClicks(player.getStrengthOfClicks() + strengthOfClicks);
            isOwned = true;
            return true;
        }
    }

    public String getNameOfUpgrade() {
        return nameOfUpgrade;
    }

    public int getPriceOfUpgrade() {
        return priceOfUpgrade;
    }

    public double getMultiplier() {
        return multiplier;
    }

    public int getStrengthOfClicks() {
        return strengthOfClicks;
    }

    public boolean isOwned() {
        return isOwned;
    }
}
