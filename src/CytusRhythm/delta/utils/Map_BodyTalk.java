package CytusRhythm.delta.utils;

import CytusRhythm.delta.obj.Tap;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Map_BodyTalk {
    double[] x;
    double[] y;
    double[] time;

    private Map_BodyTalk() {

    }

    private static final Map_BodyTalk instance = new Map_BodyTalk();

    public static Map_BodyTalk getInstance() {
        return instance;
    }

    public static void init(AnchorPane anchorPane) {
//        Tap.drawSelf(anchorPane, 100, 600);
        new TapCreator(100, 600, 0, anchorPane).start();
        new TapCreator(300, 300, 2000, anchorPane).start();
//        new TapCreator(700, 300, 2700, anchorPane).start();
//        new TapCreator(800, 400, 3700, anchorPane).start();
//        new TapCreator(900, 300, 4000, anchorPane).start();
        new TapCreator(1000, 600, 3800, anchorPane).start();
        new TapCreator(1300, 300, 5800, anchorPane).start();
        new TapCreator(100, 600, 8000, anchorPane).start();
        new TapCreator(300, 300, 10000, anchorPane).start();


        editor();
    }

    private static void editor() {

    }
}
