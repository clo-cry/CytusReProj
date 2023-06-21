package CytusRhythm.derta.utils;

import CytusRhythm.derta.Main;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Pinter {


    private Pinter() {}

    private static final Pinter instance = new Pinter();

    public static Pinter getInstance() {
        return instance;
    }

    public void init(GraphicsContext graphicsContext, int framePerSecond, int sleepTime){
        graphicsContext.setFill(Color.BLACK);
        graphicsContext.fillRect(0, 0, Main.WIDTH, Main.HEIGHT);
        graphicsContext.setStroke(Color.YELLOW);
        graphicsContext.strokeText("FPS: " + framePerSecond + "  " + "Thread Sleep: " + sleepTime + "ms ", 5, 15);
    }
}

