package CytusRhythm.derta.screen;

import javafx.scene.layout.StackPane;

public class Paff_room_BodyTalk extends StackPane {
    private Paff_room_BodyTalk(){}

    private static final Paff_room_BodyTalk instance = new Paff_room_BodyTalk();

    public static Paff_room_BodyTalk getInstance(){
        return instance;
    }
}
