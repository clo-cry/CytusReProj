package CytusRhythm.delta.screen;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.StackPane;

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
