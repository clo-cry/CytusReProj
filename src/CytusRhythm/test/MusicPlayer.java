package CytusRhythm.test;

import java.io.File;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Background;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioSpectrumListener;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class MusicPlayer extends Application {

    private MediaPlayer mediaPlayer;
    private Canvas canvas = new Canvas(640, 480);
    private GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
    double[] y = new double[128];

    @Override
    public void start(Stage primaryStage) throws Exception {
        // 创建媒体对象
        String filePath = "sound/Body Talk.wav";
        Media media = new Media(new File(filePath).toURI().toString());

        // 创建媒体播放器
        mediaPlayer = new MediaPlayer(media);

        mediaPlayer.play();

        mediaPlayer.setAudioSpectrumListener(new AudioSpectrumListener() {
            @Override
            public void spectrumDataUpdate(double v, double v1, float[] floats, float[] floats1) {
                for (int i = 0; i < y.length; i++) {
                    y[i] = Math.abs(floats[i]);
                }
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(canvas);
        update();

        root.setStyle("-fx-background-color:black");

        // 创建场景并显示窗口
        Scene scene = new Scene(root, 640, 480);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void update() {

        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                graphicsContext.setFill(Color.BLACK);
                graphicsContext.fillRect(0,0,640,480);
                graphicsContext.setFill(Color.CYAN);
                for (int i = 0; i < 128; i++) {
                    graphicsContext.fillRect(i * 4, y[i]+300, 3, 80-y[i]);
                }
            }
        };
        animationTimer.start();
    }

    @Override
    public void stop() throws Exception {
        mediaPlayer.dispose();
    }

    public static void main(String[] args) {
        launch(args);
    }
}