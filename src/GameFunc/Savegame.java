package GameFunc;

import javax.swing.*;
import java.awt.*;
import java.io.*;

/**
 *  JButton that handles Save and Load Methods
 */
public class Savegame extends JButton{
    private static String SavePath;
    private Player player;

    public Savegame(Player player){
        this.player = player;
        setText("Save Game");
        setFont(new Font("Serif", Font.BOLD, 16));
        setMaximumSize(new Dimension(200, 75));
        setBorder(BorderFactory.createLineBorder(Color.GRAY));
        addActionListener(e -> {
            String name;
            do {
                name = JOptionPane.showInputDialog("Write your name to access your save:");
            } while (name != null && name.isEmpty());

            if (name != null) {
                SavePath = new File("data/" + name + ".dat").getPath();
                saveGame();}

        });
    }

    /**
     * Saves Player to a .dat file, records time of exit for later calculations
     */
    public void saveGame(){
        player.recordExit();

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SavePath))) {
            oos.writeObject(player);
            JOptionPane.showMessageDialog(this, "game saved");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * loads the .dat file that was saved with the saveGame() method by name.
     * @param name for verification
     * @return State of Player in the save file
     */
    public static Player load(String name) {
        SavePath = new File("data/" + name + ".dat").getPath();
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(SavePath))) {

            return (Player) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("no saved game");
            return new Player();
        }
    }
}
