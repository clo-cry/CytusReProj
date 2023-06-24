package CytusRhythm.delta.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class SsController {
    @FXML
    public ScrollPane sScroller;
    @FXML
    public AnchorPane aAnchor;
    @FXML
    public Canvas canvas;
    @FXML
    public Button btn_4;
    @FXML
    private Button btn0;

    @FXML
    private Button btn1;
    @FXML
    public Button btn2;

    public static boolean changeScenePaff = false;

    public void drawInit() {
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.setStroke(Color.LIGHTGRAY);
        graphicsContext.setFill(Color.WHITE);
        graphicsContext.setFont(new Font("Impact", 15));

        graphicsContext.drawImage(new Image("file:img/paff_r.png"), 100, 177);
        graphicsContext.drawImage(new Image("file:img/neko_r.png"), 400, 177);
        graphicsContext.drawImage(new Image("file:img/robo_r.png"), 700, 177);
        graphicsContext.drawImage(new Image("file:img/www.png"), 1000, 177);

        for (int i = 0; i < 24; i++) {
            graphicsContext.strokeRoundRect(100 + i * 300, 70, 230, 650, 20, 20);
            graphicsContext.fillText(Integer.toString(i), 120 + i * 300, 100);
        }
    }

    @FXML
    void btnClicked(ActionEvent event) {
        System.out.println("Button Clicked");
    }
    @FXML
    void changeScene(ActionEvent event) {
        changeScenePaff = true;
//        Color color = new java.awt.Color(240, 234, 201);
    }
    public void initialize() {

        sScroller.setPannable(true);
        sScroller.setMinViewportHeight(900);
        sScroller.setMinViewportWidth(1600);
        aAnchor.setStyle("-fx-background-color:black");
        drawInit();

    }

    @FXML
    void btn_www(ActionEvent event) {

    }
}
