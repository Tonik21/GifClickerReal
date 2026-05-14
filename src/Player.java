import java.time.LocalDate;
import java.time.LocalDateTime;

public class Player {
    private double clicks;
    private int strengthOfClicks;
    private double clicksMultiplier;
    private LocalDateTime timeOfExit;
    private LocalDateTime timeOfEntrance;

    public Player() {
        this.clicks = 101010010;
        this.clicksMultiplier = 1.0;
        this.strengthOfClicks = 1;
        this.timeOfExit = null;
        this.timeOfEntrance = LocalDateTime.now();
    }
    public void addClicks(){
        clicks += strengthOfClicks * clicksMultiplier;
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
}
