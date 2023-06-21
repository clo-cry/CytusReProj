package CytusRhythm.beta.utils;
import CytusRhythm.alpha.utils.SelectionScreen;
import javafx.application.Platform;
import javafx.embed.swing.SwingNode;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import javax.swing.*;
import java.io.File;


public class SS extends StackPane {
    private Canvas canvas;
    private GraphicsContext gc;
    public SS() {
        SelectionScreen selectionScreen = new SelectionScreen();
        JButton button = new JButton();
        button.setBounds(10,850,10,10);
        selectionScreen.add(button);
        SwingNode swingNode = new SwingNode();
        swingNode.setContent(selectionScreen);
        getChildren().add(swingNode);
        SwingUtilities.invokeLater(selectionScreen::revalidate);
//        canvas = new Canvas(1600,900);
//        gc = canvas.getGraphicsContext2D();
//        gc.setFill(Color.LIGHTBLUE);
//        gc.fillRect(0,0,1600,900);
//        getChildren().add(canvas);

    }
}
