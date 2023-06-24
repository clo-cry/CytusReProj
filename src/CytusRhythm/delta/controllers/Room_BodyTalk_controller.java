package CytusRhythm.delta.controllers;

import CytusRhythm.delta.Main;
import CytusRhythm.delta.obj.Tap;
import CytusRhythm.delta.utils.Map_BodyTalk;
import CytusRhythm.delta.utils.Pinter;
import javafx.animation.AnimationTimer;
import javafx.animation.ScaleTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.io.File;

public class Room_BodyTalk_controller {
    @FXML
    public AnchorPane anchorPane;
    @FXML
    public Label combo;
    private AnimationTimer animationTimer;
    public static int frameIndex;
    public static int frameInterval = 16;
    public static int sleepTime;
    public static int framePerSecond;
    public static long lastDraw;
    public static double thisTime, lastTime;
    @FXML
    public Canvas canvas;
    MediaPlayer mediaPlayer;
    GraphicsContext graphicsContext;

    boolean start = false;

    public void initialize() {
        graphicsContext = canvas.getGraphicsContext2D();
        update();
        new Thread(() -> {
            boolean state = true;
            while (state) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if (Paff_song_select_controller.readyChange) {
                    Platform.runLater(this::init);
                    state = false;
                }
            }
        }).start();
    }

    ScaleTransition scaleTransition;

    private void init() {
        Map_BodyTalk.init(anchorPane);
        scaleTransition = new ScaleTransition(Duration.millis(200), combo);
        scaleTransition.setToX(1.3);
        scaleTransition.setToY(1.3);
        scaleTransition.setCycleCount(2);
        scaleTransition.setAutoReverse(true);

    }
    int changed = 0;
    private void update() {
        animationTimer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                if (start)
                    Pinter.getInstance().init(graphicsContext, framePerSecond, sleepTime);
                fpsCalc();
                int save = Tap.count;
                combo.setText("0" + save);

//                graphicsContext.fillRect(760,30,2,60);      //  Î´¶¨Çø»®
                for (int i = 0; i < 8; i++) {
                    graphicsContext.fillRect(750-Main.view[i],i*8+30,Main.view[i]-10,2);
                    graphicsContext.fillRect(860,i*8+30,Main.view[i],2);
                }

                if (Paff_song_select_controller.readyChange) {
                    if (save>changed){
                        scaleTransition.play();
                        combo.setTextFill(Color.YELLOW);
                        changed = save;
                    }

                }

                if (Paff_song_select_controller.readyChange) {
                    start = true;
                }

            }
        };
        animationTimer.start();
    }

    private void fpsCalc() {
        frameIndex++;
        if (frameIndex % 60 == 0) {
            thisTime = System.currentTimeMillis();
            framePerSecond = (int) (1000 / ((thisTime - lastTime) / 60));
            lastTime = thisTime;
        }
        sleepTime = 0;
        while (System.currentTimeMillis() - lastDraw < frameInterval) {
            try {
                Thread.sleep(1);
                sleepTime++;
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
        lastDraw = System.currentTimeMillis();
    }
}