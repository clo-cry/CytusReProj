package CytusRhythm.Gamma.utils;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;


public class SS_d extends StackPane {
    private Canvas canvas;
    private GraphicsContext gc;
    public SS_d() {

        canvas = new Canvas(1600,900);
        gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.LIGHTBLUE);
        gc.fillRect(0,0,1600,900);
        getChildren().add(canvas);

    }
}
