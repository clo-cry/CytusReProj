module CytusReProj {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.media;
    requires javafx.swing;

//    opens test to javafx.fxml;
    exports CytusRhythm.beta;
    exports CytusRhythm.derta;
}