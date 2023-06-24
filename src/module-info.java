module CytusReProj {
    requires javafx.swing;
    requires javafx.media;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens CytusRhythm.test to javafx.fxml;
    opens CytusRhythm.delta.controllers to javafx.fxml;

    exports CytusRhythm.beta;
    exports CytusRhythm.test;
    exports CytusRhythm.Gamma;
    exports CytusRhythm.delta;
}