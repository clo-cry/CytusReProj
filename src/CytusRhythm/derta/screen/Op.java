package CytusRhythm.derta.screen;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.io.File;

public class Op extends StackPane {

    private static final Op instance = new Op();

    public static Op getInstance() {
        return instance;
    }
    public static MediaPlayer mediaPlayer;
    MediaView mediaView;
    boolean readyPlay = false;
    private Op() {
        Platform.runLater(() -> {       // scene 1

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    String videoPath = "video/opening2.mp4";
                    Media media = new Media(new File(videoPath).toURI().toString());

                    // Create MediaPlayer
                    mediaPlayer = new MediaPlayer(media);
                    mediaPlayer.setAutoPlay(true);

                    // Create MediaView
                    mediaView = new MediaView(mediaPlayer);
                }
            });
            thread.start();
            synchronized (this) {
                while (mediaView == null || mediaPlayer == null) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            // Create StackPane, add MediaView
            getChildren().add(mediaView);
            /* ---Create Scene, add StackPane--- */
//            scene.setOnMouseClicked(e -> {
//                mediaPlayer.dispose();
//                readyPlay = true;
//                stage.setScene(scene1);
//            });
            mediaView.setFitWidth(1600);

        });
    }
}
