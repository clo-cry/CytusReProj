package test;

import CytusRhythm.alpha.utils.StartScreen;

import javax.swing.*;

public class JFrameTest extends JFrame {
    public JFrameTest(){
        setSize(1600,900);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        StartScreen startScreen = new StartScreen();
        add(startScreen);
        setVisible(true);
    }

    public static void main(String[] args) {
        new JFrameTest();
    }
}
