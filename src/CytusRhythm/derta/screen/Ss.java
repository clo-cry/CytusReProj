package CytusRhythm.derta.screen;

import CytusRhythm.derta.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import java.awt.*;
import java.io.IOException;

public class Ss extends StackPane {
    public static int frameIndex;
    public static int frameInterval = 16;
    public static int sleepTime;
    public static int framePerSecond;
    public static long lastDraw;
    public static double thisTime, lastTime;

    private static final Ss instance = new Ss();

    public static Ss getInstance() {
        return instance;
    }

    private Ss() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ss.fxml"));
        try {
            getChildren().add(fxmlLoader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
