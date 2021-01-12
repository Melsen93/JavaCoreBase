package lesson7.online;


import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Settings extends JFrame {
    private static final int WIN_WIDTH = 350;
    private static final int WIN_HEIGHT = 270;

    private static final int MIN_WIN_LENGTH = 3;
    private static final int MIN_FIELD_LENGTH = 3;
    private static final int MAX_FIELD_LENGTH = 10;

    private static final String FIELD_SIZE_TEXT_PREFIX = "Размер поля: ";
    private static final String WINH_LENGTH_TEXT_PREFIX = "Выигрышная серия: ";

    private MainWindow mainWindow;
    private JRadioButton humVsAi;
    private JRadioButton humVsHum;
    private JSlider sliderWinLen;
    private JSlider sliderFieldSize;



    Settings(MainWindow mainWindow){
        this.mainWindow = mainWindow;
        setSize(WIN_WIDTH,WIN_HEIGHT);

        Rectangle gameWindowBounds = mainWindow.getBounds();
        int posX = (int)gameWindowBounds.getCenterX() - WIN_WIDTH/2;
        int posY = (int)gameWindowBounds.getCenterY() - WIN_HEIGHT/2;
        setLocation(posX,posY);
        setResizable(false);
        setTitle("Настройки");
        setLayout(new GridLayout(10,1));
        addGameModeSettings();
        addFieldSizeControl();

        JButton btnStartGame = new JButton("Начать");

        btnStartGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnStartClick();
            }
        });
        add(btnStartGame);
    }

    private void addGameModeSettings(){
    add(new JLabel("Выберите режим игры"));
    humVsAi = new JRadioButton("Human vs. Ai", true);
    humVsHum = new JRadioButton("Human vs. Human");
    ButtonGroup gameMode = new ButtonGroup();
    gameMode.add(humVsAi);
    gameMode.add(humVsHum);
    add(humVsAi);
    add(humVsHum);

    }

    private void addFieldSizeControl(){
        JLabel lbFieldSize = new JLabel(FIELD_SIZE_TEXT_PREFIX + MIN_FIELD_LENGTH);
        JLabel lbWinLength = new JLabel(WINH_LENGTH_TEXT_PREFIX + MIN_WIN_LENGTH);

        sliderFieldSize = new JSlider(MIN_FIELD_LENGTH,MAX_FIELD_LENGTH,MIN_FIELD_LENGTH);
        sliderFieldSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int currentValue = sliderFieldSize.getValue();
                lbFieldSize.setText(FIELD_SIZE_TEXT_PREFIX + currentValue);
                sliderWinLen.setMaximum(currentValue);
            }
        });
        sliderWinLen = new JSlider(MIN_WIN_LENGTH, MIN_FIELD_LENGTH,MIN_FIELD_LENGTH);
        sliderWinLen.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                lbWinLength.setText(WINH_LENGTH_TEXT_PREFIX + sliderWinLen.getValue());
            }
        });
        add(new JLabel("Выберите размер поля"));
        add(lbFieldSize);
        add(sliderFieldSize);
        add(new JLabel("Выберите выигрышную серию"));
        add(lbWinLength);
        add(sliderWinLen);

    }

    private void btnStartClick(){
        int gameMode;

        if(humVsAi.isSelected()){
            gameMode = GameMap.GAME_MODE_HVA;
        }else if(humVsHum.isSelected()){
            gameMode = GameMap.GAME_MODE_HVH;
        }else {
            throw new RuntimeException("Неизвестный режим игры");
        }
        int fieldSize = sliderFieldSize.getValue();
        int winLength = sliderWinLen.getValue();
        mainWindow.startNewGame(gameMode,fieldSize,fieldSize,winLength);
        setVisible(false);

    }

}
