package CytusRhythm.delta.obj;

import javafx.animation.Animation;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Tap {
    public static int count = 0;
    public Tap() {

    }

    public static void drawSelf(AnchorPane anchorPane, double x, double y) {
        Circle circle = new Circle(x, y, 1, Color.WHITE);
        Circle circle1 = new Circle(x, y, 1, Color.rgb(62, 229, 174));
        Circle circle2 = new Circle(x, y, 1, Color.rgb(183, 238, 211));
        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(1600), circle);
        scaleTransition.setFromX(1);
        scaleTransition.setFromY(1);
        scaleTransition.setToX(50);
        scaleTransition.setToY(50);
//        scaleTransition.setCycleCount(Animation.INDEFINITE);
//        scaleTransition.setAutoReverse(true);
        scaleTransition.play();
        ScaleTransition scaleTransition1 = new ScaleTransition(Duration.millis(1800), circle1);
        scaleTransition1.setFromX(1);
        scaleTransition1.setFromY(1);
        scaleTransition1.setToX(45);
        scaleTransition1.setToY(45);
//        scaleTransition1.setCycleCount(Animation.INDEFINITE);
//        scaleTransition1.setAutoReverse(true);
        scaleTransition1.play();
        ScaleTransition scaleTransition2 = new ScaleTransition(Duration.millis(2000), circle2);
        scaleTransition2.setFromX(1);
        scaleTransition2.setFromY(1);
        scaleTransition2.setToX(34);
        scaleTransition2.setToY(34);
//        scaleTransition2.setCycleCount(Animation.INDEFINITE);
//        scaleTransition2.setAutoReverse(true);
        scaleTransition2.play();
        anchorPane.getChildren().addAll(scaleTransition.getNode(), scaleTransition1.getNode(), scaleTransition2.getNode());

        long start = System.currentTimeMillis();
        new Thread(() -> {
            boolean state = true;
            while (state) {
                long end = System.currentTimeMillis();
                if ((end - start) > 2200) {
                    Platform.runLater(() -> {
                        scaleTransition.stop();
                        scaleTransition2.stop();
                        scaleTransition1.stop();
                        circle.setFill(Color.TRANSPARENT);
                        circle1.setFill(Color.TRANSPARENT);
                        circle2.setFill(Color.TRANSPARENT);
                    });
                    state = false;
                }
            }
        }).start();

        circle.setOnMouseClicked(e -> {
            count++;
            scaleTransition.stop();
            scaleTransition2.stop();
            scaleTransition1.stop();
            circle.setFill(Color.TRANSPARENT);
            circle1.setFill(Color.TRANSPARENT);
            circle2.setFill(Color.TRANSPARENT);
        });
        circle1.setOnMouseClicked(e -> {
            count++;
            scaleTransition.stop();
            scaleTransition2.stop();
            scaleTransition1.stop();
            circle.setFill(Color.TRANSPARENT);
            circle1.setFill(Color.TRANSPARENT);
            circle2.setFill(Color.TRANSPARENT);
        });
        circle2.setOnMouseClicked(e -> {
            count++;
            scaleTransition.stop();
            scaleTransition2.stop();
            scaleTransition1.stop();
            circle.setFill(Color.TRANSPARENT);
            circle1.setFill(Color.TRANSPARENT);
            circle2.setFill(Color.TRANSPARENT);
        });
    }
}
