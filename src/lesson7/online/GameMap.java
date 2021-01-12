package lesson7.online;

import javax.swing.*;
import java.awt.*;

public class GameMap extends JPanel {

    public static final int GAME_MODE_HVA  = 0;
    public static final int GAME_MODE_HVH  = 1;

    GameMap(){
        setBackground(Color.BLACK);
    }

    void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLength){
        System.out.println("mode = " + mode + " fieldSizeX = " + fieldSizeX + " fieldSizeY = " + fieldSizeY + " winLength " + winLength);
    }

}
