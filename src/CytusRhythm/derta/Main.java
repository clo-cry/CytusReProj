package CytusRhythm.derta;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
       Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Director.getInstance().init(primaryStage);
    }
}
