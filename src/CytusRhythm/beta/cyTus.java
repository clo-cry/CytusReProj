package CytusRhythm.beta;

import CytusRhythm.beta.utils.FrameC;
import CytusRhythm.beta.utils.SS;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;

public class cyTus extends Application {
    private Scene scene1;
    private Scene scene2;
    private Scene scene3;
    private SS SS;
    MediaPlayer mediaPlayer;
    MediaPlayer soundLoop_mediaplayer;
    MediaView mediaView;
    int count = 0;
    boolean readyPlay = false;

    @Override
    public void start(Stage stage) throws Exception {

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
            StackPane stackPane = new StackPane();
            stackPane.getChildren().add(mediaView);

            // Create Scene, add StackPane
            scene1 = new Scene(stackPane, 1600, 900);

            scene1.setOnMouseClicked(e -> {
                if (count == 0) {
                    mediaPlayer.dispose();
                    stackPane.getChildren().remove(mediaView);
                    mediaPlayer1.setAutoPlay(true);
                    stackPane.getChildren().add(mediaView1);
                    startSE.play();
                    mediaPlayer1.setOnEndOfMedia(() -> {
                        mediaPlayer1.dispose();
                        Platform.runLater(() -> {
                            stage.setScene(scene3);
                            SwingUtilities.invokeLater((() -> {
//                                FrameC.getInstance().init(stage);

                            }));
                        });
//                        soundLoop_mediaplayer.dispose();
//                        Platform.runLater(stage::close);
                    });
                }
                count++;
            });
            mediaView.setFitWidth(1600);
            mediaView1.setFitWidth(1600);
        });

        // ´´½¨³¡¾°2
        VBox layout2 = new VBox(10);
        layout2.setAlignment(Pos.CENTER);
        Label label = new Label("This is Scene 2");
        Button backButton = new Button("Back to Scene 1");
        backButton.setOnAction(event -> stage.setScene(scene1));
        layout2.getChildren().addAll(label, backButton);
        scene2 = new Scene(layout2, 1600, 900);

        Platform.runLater(() -> {       // scene 3
            SS = new SS();
            scene3 = new Scene(SS,1600,900);
            stage.setScene(scene3);
        });

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
            StackPane stackPane = new StackPane();
            stackPane.getChildren().add(mediaView);

            /* ---Create Scene, add StackPane--- */
            Scene scene = new Scene(stackPane, 1600, 900);
            scene.setOnMouseClicked(e -> {
                mediaPlayer.dispose();
                readyPlay = true;
                stage.setScene(scene1);
            });
            mediaView.fitWidthProperty().bind(scene.widthProperty());
            mediaView.fitHeightProperty().bind(scene.heightProperty());

            /* ------Stage setting------ */
            stage.setOnCloseRequest(e -> {      // Make sure everything disposed.
                System.exit(0);
            });
            String iconPath = "img/app_icon.png";
            stage.getIcons().add(new Image(new File(iconPath).toURI().toString()));
            stage.setTitle("Cytus II remake");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        });
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
