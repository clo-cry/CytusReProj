package test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class JavafxTest extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Label label = new Label("Hello Kitty");

        Button button = new Button("link");
        BorderPane pane = new BorderPane(button);

        button.setOnAction(e -> {
            getHostServices().showDocument("www.bilibili.com");
        });

        Scene scene = new Scene(pane, 640,480);

        stage.setScene(scene);
        stage.setTitle("Example");
        stage.show();
//        System.out.println(stage.getWidth()+" "+stage.getHeight());
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
