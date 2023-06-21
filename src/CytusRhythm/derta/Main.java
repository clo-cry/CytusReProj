package CytusRhythm.derta;

import CytusRhythm.derta.controllers.Paff_song_select_controller;
import CytusRhythm.derta.controllers.SsController;
import CytusRhythm.derta.screen.*;
import CytusRhythm.derta.utils.Pinter;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {
    public static final double WIDTH = 1600, HEIGHT = 900;
    private Canvas canvas = new Canvas(WIDTH, HEIGHT);
    //    private GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
//    private AnimationTimer animationTimer;
//    public static int frameIndex;
//    public static int frameInterval = 16;
//    public static int sleepTime;
//    public static int framePerSecond;
//    public static long lastDraw;
//    public static double thisTime, lastTime;
    private final Scene opening = new Scene(Op.getInstance(), WIDTH, HEIGHT);
    private final Scene waitingScreen = new Scene(Ws.getInstance(), 1600, 900);
    private final Scene selectionScreen = new Scene(Ss.getInstance(), 1600, 900);
    private final Scene paff_song_select = new Scene(Paff_song_select.getInstance(), WIDTH, HEIGHT);
    private final Scene room_BodyTalk = new Scene(Paff_room_BodyTalk.getInstance(), WIDTH, HEIGHT);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
//        update();
//        AnchorPane root = new AnchorPane(canvas);
//        Scene scene = new Scene(root);
//        scene.setOnKeyPressed(e -> {
//            KeyCode keyCode = e.getCode();
//
//            switch (keyCode) {
//                case ESCAPE -> Platform.exit();
//            }
//        });
        String iconPath = "img/app_icon.png";
        stage.getIcons().add(new Image(new File(iconPath).toURI().toString()));
        stage.setTitle("Cytus II remake");

        stage.setScene(opening);
        opening.setOnMouseClicked(e -> {
            Op.mediaPlayer.dispose();
            stage.setScene(waitingScreen);
            Ws.readyPlay = true;
        });

        new Thread(() -> {      //  Get changed state: Ws to Ss.
            boolean state = true;
            while (state) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if (Ws.changeReady) {
                    Platform.runLater(() -> {
                        stage.setScene(selectionScreen);
                        new Thread(() -> {      // Get changed state: Ss to Pss;
                            boolean state2 = true;
                            while (state2) {
                                try {
                                    Thread.sleep(10);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                if (SsController.changeScenePaff) {
                                    Platform.runLater(() -> {
                                        stage.setScene(paff_song_select);
                                        Ws.soundLoop_mediaplayer.dispose();

                                        new Thread(() -> {      // play waiting music
                                            Media media1 = new Media(new File("sound/song_0_clip.wav").toURI().toString());
                                            Media media2 = new Media(new File("sound/song_1_clip.wav").toURI().toString());
                                            MediaPlayer mediaPlayer1 = new MediaPlayer(media1);
                                            MediaPlayer mediaPlayer2 = new MediaPlayer(media2);
                                            mediaPlayer1.setCycleCount(MediaPlayer.INDEFINITE);
                                            mediaPlayer2.setCycleCount(MediaPlayer.INDEFINITE);
                                            while (true) {
                                                if (Paff_song_select_controller.name.equals("0")) {
                                                    mediaPlayer1.play();
                                                    mediaPlayer2.stop();
                                                } else if (Paff_song_select_controller.name.equals("1")) {
                                                    mediaPlayer2.play();
                                                    mediaPlayer1.stop();
                                                }
                                            }

                                        }).start();
                                    });
                                    state2 = false;
                                }
                            }
                        }).start();
                    });
                    state = false;
                }
            }
        }).start();

        stage.setOnCloseRequest(e -> {      // Make sure everything disposed.
            System.exit(0);
        });
        stage.setResizable(false);
        stage.show();
    }

//    private void update() {
//        animationTimer = new AnimationTimer() {
//            @Override
//            public void handle(long l) {
//                Pinter.getInstance().init(graphicsContext, framePerSecond, sleepTime);
//                fpsCalc();
//            }
//        };
//        animationTimer.start();
//    }
//
//    private void fpsCalc() {
//        frameIndex++;
//        if (frameIndex % 60 == 0) {
//            thisTime = System.currentTimeMillis();
//            framePerSecond = (int) (1000 / ((thisTime - lastTime) / 60));
//            lastTime = thisTime;
//        }
//        sleepTime = 0;
//        while (System.currentTimeMillis() - lastDraw < frameInterval) {
//            try {
//                Thread.sleep(1);
//                sleepTime++;
//            } catch (InterruptedException ie) {
//                ie.printStackTrace();
//            }
//        }
//        lastDraw = System.currentTimeMillis();
//    }
}
