public class IdleUpgrade extends Upgrade{
    public int fraction;
    public IdleUpgrade(int priceOfUpgrade, String nameOfUpgrade, int fraction) {
        super(priceOfUpgrade,  nameOfUpgrade);
        this.fraction = fraction;
    }

    @Override
    public boolean buy(Player player) {
        if (isOwned() || player.getClicks() < getPriceOfUpgrade()) return false;
        player.setClicks(player.getClicks() - getPriceOfUpgrade());
        setOwned(true);
        return true;
    }

    @Override
    public String description() {
        return "- Idle: " + (fraction * 100) + "% performance\n works while offline";
    }
}