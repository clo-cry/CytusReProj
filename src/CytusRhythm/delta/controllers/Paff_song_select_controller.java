package CytusRhythm.delta.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.io.File;

public class Paff_song_select_controller {

    public static boolean readyChange = false;
    public MediaView paff_mediaview;
    public AnchorPane root;

    ImageView imageView;
    ImageView imageView1;
    MediaPlayer mediaPlayer;

    public static String name = null;
    @FXML
    void easyClicked(ActionEvent event) {
        readyChange = true;
        mediaPlayer.dispose();
    }

    @FXML
    void previousBtnClicked(ActionEvent event) {
      if (name.equals("0")){
        root.getChildren().remove(imageView1);
        root.getChildren().add(imageView);
        name = "1";
      }else {
          root.getChildren().remove(imageView);
          root.getChildren().add(imageView1);
          name = "0";
      }
    }
    public void initialize() {
        String videoPath = "video/paff001_song_select.mp4";
        Media media = new Media(new File(videoPath).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        paff_mediaview.setMediaPlayer(mediaPlayer);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
        paff_mediaview.setFitHeight(1600);
        imageView = new ImageView(new File("img/song_1.png").toURI().toString());
        imageView1 = new ImageView(new File("img/song_0.png").toURI().toString());

        root.getChildren().addAll(imageView1);
        name = "0";
        imageView.setLayoutX(0);
        imageView.setLayoutY(120);
        imageView.setBlendMode(BlendMode.MULTIPLY);
        imageView.setOpacity(0.7);

        imageView1.setLayoutX(0);
        imageView1.setLayoutY(120);
        imageView1.setBlendMode(BlendMode.MULTIPLY);
        imageView1.setOpacity(0.7);

    }
}
