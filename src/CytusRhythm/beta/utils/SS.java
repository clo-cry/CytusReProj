package CytusRhythm.beta.utils;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;


public class SS extends StackPane {
    private Canvas canvas;
    private GraphicsContext gc;
    public SS() {
        canvas = new Canvas(1600,900);
        gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.LIGHTBLUE);
        gc.fillRect(50,50,100,100);
        getChildren().add(canvas);
    }
}
