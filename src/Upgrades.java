public class Upgrades {
    private String nameOfUpgrade;
    private int priceOfUpgrade;
    private double multiplier;
    private int strengthOfClicks;
    private boolean isOwned;


    public void buyMultBasedUpgrade(Player player){
        if (player.getClicks()<priceOfUpgrade){
            System.out.println("Not enough Clicks you need: "+priceOfUpgrade+" clicks");
        }else{
        player.setClicks(player.getClicks() - priceOfUpgrade);
        player.setClicksMultiplier(player.getClicksMultiplier() + multiplier);
        isOwned = true;
    }}
    public void buyClickStrengthBasedUpgrade(Player player){
        if (player.getClicks()<priceOfUpgrade){
            System.out.println("Not enough Clicks you need: "+priceOfUpgrade+" clicks");
        }else{
        player.setClicks(player.getClicks() - priceOfUpgrade);
        player.setStrengthOfClicks(player.getStrengthOfClicks() + strengthOfClicks);
        isOwned = true;
    }}


}
