package CytusRhythm.alpha.utils;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class StartScreen extends JFXPanel {
    int count = 0;

    public StartScreen() {
        Platform.runLater(() -> {
            String videoPath_1 = "video/title05_1.mp4";
            String videoPath_2 = "video/title05_2.mp4";
            Media media_1 = new Media(new File(videoPath_1).toURI().toString());
            Media media_2 = new Media(new File(videoPath_2).toURI().toString());
            // 创建MediaPlayer对象
            MediaPlayer mediaPlayer = new MediaPlayer(media_1);
            mediaPlayer.setAutoPlay(true);
            MediaPlayer mediaPlayer1 = new MediaPlayer(media_2);

            // 创建MediaView对象
            MediaView mediaView = new MediaView(mediaPlayer);
            MediaView mediaView1 = new MediaView(mediaPlayer1);

            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);

            // 创建StackPane对象，将MediaView添加到其中
            StackPane stackPane = new StackPane();
            stackPane.getChildren().add(mediaView);

            // 创建Scene对象，将StackPane添加到其中
            Scene scene = new Scene(stackPane, 640, 480);
            scene.setFill(Color.BLACK);

            scene.setOnMouseClicked(e -> {
                if (count == 0) {
                    mediaPlayer.dispose();
                    stackPane.getChildren().remove(mediaView);
                    mediaPlayer1.setAutoPlay(true);
                    stackPane.getChildren().add(mediaView1);
                }
                count++;
            });
            mediaView.fitWidthProperty().bind(scene.widthProperty());
            mediaView.fitHeightProperty().bind(scene.heightProperty());

            setScene(scene);
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
