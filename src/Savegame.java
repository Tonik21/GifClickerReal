import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Savegame extends JButton{
    public static final String SavePath = "GifClickerReal/src/save.dat";
    private Player player;
    private IdleUpgrade upgrade;

    public Savegame(Player player){
        this.player = player;
        setText("Save Game");
        setFont(new Font("Serif", Font.BOLD, 16));
        setMaximumSize(new Dimension(200, 75));
        setBorder(BorderFactory.createLineBorder(Color.GRAY));

        addActionListener(e -> saveGame());
    }

    public void saveGame(){
        player.recordExit();
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SavePath))) {
            oos.writeObject(player);
            JOptionPane.showMessageDialog(this, "Hra uložena!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Player load() {
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(SavePath))) {

            return (Player) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Žádná uložená hra, začínám novou.");
            return new Player();
        }
    }
}
