package CytusRhythm.delta.utils;

import CytusRhythm.delta.obj.Tap;
import javafx.application.Platform;
import javafx.scene.layout.AnchorPane;

public class TapCreator extends Thread {
    long time;
    double x;
    double y;
    AnchorPane anchorPane;

    public TapCreator(double x, double y, long time, AnchorPane anchorPane) {
        this.x = x;
        this.y = y;
        this.time = time;
        this.anchorPane = anchorPane;

    }

    @Override
    public void run() {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Platform.runLater(()->{
            Tap.drawSelf(anchorPane,x,y);
        });

    }
}
