package CytusRhythm.derta.screen;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;

public class Ws extends StackPane {
    public static MediaPlayer soundLoop_mediaplayer;
    public static boolean readyPlay;
    int count = 0;

    public static boolean changeReady = false;

    private static final Ws instance = new Ws();

    public static Ws getInstance() {
        return instance;
    }

    private Ws() {
        Platform.runLater(() -> {       // scene 2
            String videoPath_1 = "video/title05_1.mp4";
            String videoPath_2 = "video/title05_2.mp4";
            String soundLoop = "sound/op_loop_01.wav";
            String audioPath_2 = "sound/start.wav";
            Media media_1 = new Media(new File(videoPath_1).toURI().toString());
            Media media_2 = new Media(new File(videoPath_2).toURI().toString());
            Media soundLoop_media = new Media(new File(soundLoop).toURI().toString());
            AudioClip startSE = new AudioClip(new File(audioPath_2).toURI().toString());

            // Create MediaPlayer
            MediaPlayer mediaPlayer = new MediaPlayer(media_1);
            MediaPlayer mediaPlayer1 = new MediaPlayer(media_2);
            soundLoop_mediaplayer = new MediaPlayer(soundLoop_media);

            // MediaPlayer setting
            mediaPlayer.setAutoPlay(true);
            startSE.setVolume(6.0);
            soundLoop_mediaplayer.setCycleCount(MediaPlayer.INDEFINITE);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        if (readyPlay) {
                            soundLoop_mediaplayer.play();
                        }
                    }
                }
            }).start();

            // Create MediaView
            MediaView mediaView = new MediaView(mediaPlayer);
            MediaView mediaView1 = new MediaView(mediaPlayer1);

            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE); // video no.1 loop

            // Create StackPane, add MediaView
            this.getChildren().add(mediaView);

            // Create Scene, add StackPane
            setOnMouseClicked(e -> {
                if (count == 0) {
                    mediaPlayer.dispose();
                    getChildren().remove(mediaView);
                    mediaPlayer1.setAutoPlay(true);
                    getChildren().add(mediaView1);
                    startSE.play();
                    mediaPlayer1.setOnEndOfMedia(() -> {
                        mediaPlayer1.dispose();
                        changeReady = true;
//                        soundLoop_mediaplayer.dispose();
//                        Platform.runLater(stage::close);
                    });
                }
                count++;
            });
            mediaView.setFitWidth(1600);
            mediaView1.setFitWidth(1600);
        });
    }
}
