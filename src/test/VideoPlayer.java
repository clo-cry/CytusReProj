package test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import java.io.File;

public class VideoPlayer extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // ����Media����ָ����Ƶ�ļ�·��
        String videoPath = "video/opening2.mp4";
        Media media = new Media(new File(videoPath).toURI().toString());

        // ����MediaPlayer����
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);

        // ����MediaView����
        MediaView mediaView = new MediaView(mediaPlayer);

        // ����StackPane���󣬽�MediaView��ӵ�����
        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(mediaView);

        // ����Scene���󣬽�StackPane��ӵ�����
        Scene scene = new Scene(stackPane, 640, 480);

        // ����Stage��Scene������ʾ����
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}