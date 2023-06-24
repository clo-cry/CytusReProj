package CytusRhythm.delta.screen;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class Paff_song_select extends StackPane {
    private Paff_song_select() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("paff_song_select.fxml"));
        try {
            getChildren().add(fxmlLoader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static final Paff_song_select instance = new Paff_song_select();

    public static Paff_song_select getInstance() {
        return instance;
    }
}
