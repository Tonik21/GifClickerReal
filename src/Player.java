import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Player implements Serializable {
    private double clicks;
    private int strengthOfClicks;
    private double clicksMultiplier;
    private IdleUpgrade idleUpgrade ;
    private LocalDateTime timeOfExit;
    private LocalDateTime timeOfEntrance;
    private List<Upgrade> upgrades = new ArrayList<>();
    private static final long serialVersionUID = 2L;

    public Player() {
        this.clicks = 0;
        this.clicksMultiplier = 1.0;
        this.strengthOfClicks = 1;
        this.timeOfExit = null;
        this.idleUpgrade = null;
        this.timeOfEntrance = LocalDateTime.now();

        upgrades.add(new MultUpgrade(150, "RychloKlikI", 1.5));
        upgrades.add(new MultUpgrade(1500, "RychloKlikII", 3.0));
        upgrades.add(new MultUpgrade(15000, "RychloKlikIII", 6.0));
        upgrades.add(new StrengthUpgrade(100, "SilnoPrstI", 3));
        upgrades.add(new StrengthUpgrade(1000, "SilnoPrstII", 7));
        upgrades.add(new StrengthUpgrade(10000, "SilnoPrstIII", 10));
        upgrades.add(new IdleUpgrade(500, "AssistentCtvrtPrst", 0.25));
        upgrades.add(new IdleUpgrade(2000, "AssistentPulPrst", 0.5));
        upgrades.add(new IdleUpgrade(8000, "AssistentTriCtvrtPrst", 0.75));


    }

    public void addClicks(){
        clicks += strengthOfClicks * clicksMultiplier;
    }
    public void calculateOffTime() {
        if (timeOfExit == null||idleUpgrade == null) return;
        long secondsAway = Duration.between(timeOfEntrance, timeOfExit).getSeconds();
        clicks += secondsAway * (strengthOfClicks * clicksMultiplier)*idleUpgrade.fraction;
    }
    public void recordExit(){
        this.timeOfExit = LocalDateTime.now();
    }

    public double getClicks() {
        return clicks;
    }

    public void setClicks(double clicks) {
        this.clicks = clicks;
    }

    public int getStrengthOfClicks() {
        return strengthOfClicks;
    }

    public void setStrengthOfClicks(int strengthOfClicks) {
        this.strengthOfClicks = strengthOfClicks;
    }

    public double getClicksMultiplier() {
        return clicksMultiplier;
    }

    public void setClicksMultiplier(double clicksMultiplier) {
        this.clicksMultiplier = clicksMultiplier;
    }

    public List<Upgrade> getUpgrades() {
        return upgrades;
    }

    public IdleUpgrade getIdleUpgrade() {
        return idleUpgrade;
    }

    public void setIdleUpgrade(IdleUpgrade idleUpgrade) {
        this.idleUpgrade = idleUpgrade;
    }
}
