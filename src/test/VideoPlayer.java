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
        // 创建Media对象，指定视频文件路径
        String videoPath = "video/opening2.mp4";
        Media media = new Media(new File(videoPath).toURI().toString());

        // 创建MediaPlayer对象
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);

        // 创建MediaView对象
        MediaView mediaView = new MediaView(mediaPlayer);

        // 创建StackPane对象，将MediaView添加到其中
        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(mediaView);

        // 创建Scene对象，将StackPane添加到其中
        Scene scene = new Scene(stackPane, 640, 480);

        // 设置Stage的Scene，并显示窗口
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}