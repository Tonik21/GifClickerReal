import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;

public class Player implements Serializable {
    private double clicks;
    private int strengthOfClicks;
    private double clicksMultiplier;
    private IdleUpgrade idleUpgrade ;
    private LocalDateTime timeOfExit;
    private LocalDateTime timeOfEntrance;

    public Player() {
        this.clicks = 25000;
        this.clicksMultiplier = 1.0;
        this.strengthOfClicks = 1;
        this.timeOfExit = null;
        this.idleUpgrade = null;
        this.timeOfEntrance = LocalDateTime.now();
    }
    public void addClicks(){
        clicks += strengthOfClicks * clicksMultiplier;
    }
    public void calculateOffTime() {
        if (timeOfExit == null) return;
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

    public IdleUpgrade getIdleUpgrade() {
        return idleUpgrade;
    }

    public void setIdleUpgrade(IdleUpgrade idleUpgrade) {
        this.idleUpgrade = idleUpgrade;
    }
}
