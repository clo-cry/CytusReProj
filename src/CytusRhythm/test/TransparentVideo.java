package CytusRhythm.test;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Transform;
import javafx.stage.Stage;

import java.io.File;
import java.net.URISyntaxException;

public class TransparentVideo extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Load the video
        Image videoImage = null;
        try {
            videoImage = new Image(getClass().getResource("paff001_song_select.mp4").toURI().toString());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        // Create a Rectangle to specify the transparent area of the video
        Rectangle2D transparentArea = new Rectangle2D(100, 100, 200, 200);
        Shape transparentShape = new Rectangle(transparentArea.getMinX(), transparentArea.getMinY(),
                transparentArea.getWidth(), transparentArea.getHeight());

        // Create a Group to hold the video and transparent area
        Group group = new Group();
        group.getChildren().addAll(createTransparentVideo(videoImage, transparentShape), createBackgroundImage());

        // Create the Scene
        Scene scene = new Scene(group, 800, 600);

        // Set the Scene and show the Stage
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private ImageView createTransparentVideo(Image videoImage, Shape transparentArea) {
        // Create a WritableImage for the transparent video
        WritableImage transparentImage = new WritableImage((int) videoImage.getWidth(), (int) videoImage.getHeight());

        // Get the PixelReader for the video image
        PixelReader pixelReader = videoImage.getPixelReader();

        // Get the PixelWriter for the transparent image
        PixelWriter pixelWriter = transparentImage.getPixelWriter();

        // Copy the pixels from the video to the transparent image, making the transparent area transparent
        for (int x = 0; x < videoImage.getWidth(); x++) {
            for (int y = 0; y < videoImage.getHeight(); y++) {
                Color color = pixelReader.getColor(x, y);

                if (transparentArea.contains(Transform.translate(x, y).transform(0, 0))) {
                    color = new Color(color.getRed(), color.getGreen(), color.getBlue(), 0);
                }

                pixelWriter.setColor(x, y, color);
            }
        }

        // Create an ImageView to display the transparent video
        ImageView imageView = new ImageView(transparentImage);

        return imageView;
    }

    private ImageView createBackgroundImage() {
        // Load the background image
        Image backgroundImage = null;
        try {
            backgroundImage = new Image(getClass().getResource("song_1.jpeg").toURI().toString());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        // Create an ImageView to display the background image
        ImageView imageView = new ImageView(backgroundImage);

        return imageView;
    }

    public static void main(String[] args) {
        launch(args);
    }
}