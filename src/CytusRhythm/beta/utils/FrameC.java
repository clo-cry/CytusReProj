package CytusRhythm.beta.utils;

import CytusRhythm.alpha.utils.SelectionScreen;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class FrameC {
    public int WIDTH = 1600, HEIGHT = 900;
    public int X,Y;
    private static FrameC instance = new FrameC();

    public static FrameC getInstance() {
        return instance;
    }

    private FrameC(){}

    public void init(Stage stage){
        WIDTH = (int) stage.getWidth();
        HEIGHT = (int) stage.getHeight();
        X = (int) stage.getX();
        Y = (int) stage.getY();
        JFrame frame = new JFrame();
        frame.setSize(WIDTH,HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        try {
            frame.setIconImage(ImageIO.read(new File("img/app_icon.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        frame.setTitle("Cytus II remake");

        frame.getContentPane().add(new SelectionScreen());

    }
}
