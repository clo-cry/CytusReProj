package CytusRhythm.delta.screen;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class Paff_room_BodyTalk extends StackPane {
    private Paff_room_BodyTalk(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("BodyTalk.fxml"));
        try {
            getChildren().add(fxmlLoader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static final Paff_room_BodyTalk instance = new Paff_room_BodyTalk();

    public static Paff_room_BodyTalk getInstance(){
        return instance;
    }
}
