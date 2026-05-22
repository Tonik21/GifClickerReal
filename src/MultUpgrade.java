public class MultUpgrade extends Upgrade{
    private double multiplier;
    public MultUpgrade(int priceOfUpgrade,double multiplier ,String nameOfUpgrade) {
        super(priceOfUpgrade, nameOfUpgrade);
        this.multiplier = multiplier;
    }

    @Override
    public boolean buy(Player player) {
        if (player.getClicks() < getPriceOfUpgrade()) {
            return false;
        } else {
            player.setClicks(player.getClicks() - getPriceOfUpgrade());
            player.setClicksMultiplier(player.getClicksMultiplier() + multiplier);
            setOwned(true);
            return true;
        }
    }

    @Override
    public String description() {
        return "- Multiplier: " + multiplier;
    }
}
