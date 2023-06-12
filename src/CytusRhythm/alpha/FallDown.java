package CytusRhythm.alpha;

import CytusRhythm.alpha.utils.MP;
import CytusRhythm.alpha.utils.SelectionScreen;
import CytusRhythm.alpha.utils.SoundPlayer;
import test.FibonacciCalculator;

import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class FallDown extends JFrame {
    public int w = 1600, h = 900;
    public SoundPlayer soundPlayer;
    private int state = 0;

    public FallDown() {
        setSize(w, h);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        try {
            setIconImage(ImageIO.read(new File("./img/app_icon.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        setTitle("Cytus II remake");
        JPanel cardPanel = new JPanel(new CardLayout());
        MP mp = new MP();
        cardPanel.add(mp, "mp");
        SelectionScreen selectionScreen = new SelectionScreen();
        cardPanel.add(selectionScreen, "selScreen");
        getContentPane().add(cardPanel, BorderLayout.CENTER);
        CardLayout cardLayout = (CardLayout) cardPanel.getLayout();
        cardLayout.show(cardPanel, "selScreen");
        setVisible(true);
        setResizable(false);

        addMouseListener(mp);
        addMouseMotionListener(mp);
        addKeyListener(mp);

        int trunOn = 0;
        while (true) {
            if (selectionScreen.startPrepared) {
                cardLayout.show(cardPanel, "mp");
                state = 1;

            }
            if (state == 1) {
                if (trunOn == 0) {
                    SwingUtilities.invokeLater(() -> {
                        try {

                            soundPlayer = new SoundPlayer();

                        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
                            throw new RuntimeException(e);
                        }
                        soundPlayer.play();
                    });
                    trunOn++;
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public static void main(String[] args) {
        new FallDown();
    }
}
