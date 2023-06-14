package test;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SceneSwitcher extends Application {

    private Scene scene1;
    private Scene scene2;
    private Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        // ��������1
        VBox layout1 = new VBox(10);
        layout1.setAlignment(Pos.CENTER);
        TextField textField = new TextField();
        Button button = new Button("Say Hello");
        button.setOnAction(event -> textField.setText("Hello, World!"));
        layout1.getChildren().addAll(textField, button);
        scene1 = new Scene(layout1, 300, 200);

        // ��������2
        VBox layout2 = new VBox(10);
        layout2.setAlignment(Pos.CENTER);
        Label label = new Label("This is Scene 2");
        Button backButton = new Button("Back to Scene 1");
        backButton.setOnAction(event -> stage.setScene(scene1));
        layout2.getChildren().addAll(label, backButton);
        scene2 = new Scene(layout2, 300, 200);

        // ����Stageʵ��
        stage = primaryStage;
        stage.setScene(scene1);
        stage.show();

        // ���������¼�������
        EventHandler<KeyEvent> switchSceneEventHandler = event -> {
            if (event.getCode() == KeyCode.ENTER) {
                stage.setScene(scene2);
            }
        };

        // ���¼��������볡��1����
        scene1.setOnKeyPressed(switchSceneEventHandler);
    }

    public static void main(String[] args) {
        launch(args);
    }
}