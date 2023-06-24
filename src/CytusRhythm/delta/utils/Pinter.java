package CytusRhythm.delta.utils;

import CytusRhythm.delta.Main;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Pinter {


    private Pinter() {
    }

    private static final Pinter instance = new Pinter();

    public static Pinter getInstance() {
        return instance;
    }

    static double y = 126;
    double x1 = 0;
    double x2 = 0;
    private int w = 3, h = 6;
    boolean face = true;

    public void init(GraphicsContext graphicsContext, int framePerSecond, int sleepTime) {
        graphicsContext.setFill(Color.BLACK);
        graphicsContext.fillRect(0, 0, Main.WIDTH, Main.HEIGHT);
        graphicsContext.setStroke(Color.YELLOW);
        graphicsContext.strokeText("FPS: " + framePerSecond + "  " + "Thread Sleep: " + sleepTime + "ms ", 5, 15);
        graphicsContext.setLineWidth(1.6);
        graphicsContext.setStroke(Color.WHITE);
        graphicsContext.strokeLine(0, y, 1600, y);
        if (face) {
            if (y > 750) {
                y = 750;
                face = false;
            }
            y += 5;
        } else {
            if (y < 126) {
                y = 126;
                face = true;
            }
            y -= 5;
        }


        // Draw borderlines.
        graphicsContext.setFill(Color.rgb(255,255,255,0.5));
        for (int i = 0; i < 2000; i += 120) {
            graphicsContext.fillRect(x1 + i, 120, w, h);
        }
        for (int i = 0; i < 2000; i += 120) {
            graphicsContext.fillRect(x2 + i, 750, w, h);
        }
        x1--;
        if (x1 < -120) x1 = 0;
        x2++;
        if (x2 > 120) x2 = 0;

    }
}

