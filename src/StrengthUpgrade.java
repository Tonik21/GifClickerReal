public class StrengthUpgrade extends Upgrade{
    private int strengthOfClicks;

    public StrengthUpgrade(int priceOfUpgrade, int strengthOfClicks, String nameOfUpgrade) {
        super(priceOfUpgrade, nameOfUpgrade);
        this.strengthOfClicks = strengthOfClicks;
    }

    @Override
    public boolean buy(Player player) {

            if (player.getClicks() < getPriceOfUpgrade()) {
                System.out.println("Not enough Clicks you need: " + getPriceOfUpgrade()+ " clicks");
                return false;
            } else {
                player.setClicks(player.getClicks() - getPriceOfUpgrade());
                player.setStrengthOfClicks(player.getStrengthOfClicks() + strengthOfClicks);
                setOwned(true);
                return true;
            }

    }

    @Override
    public String description() {
        return "-Strength: " + strengthOfClicks;
    }
}
