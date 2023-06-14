package CytusRhythm.alpha;

import CytusRhythm.alpha.utils.MP;
import CytusRhythm.alpha.utils.MapEditor;
import CytusRhythm.alpha.utils.SelectionScreen;
import CytusRhythm.alpha.utils.SoundPlayer;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

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
    public MapEditor mapEditor;
    public CardLayout cardLayout = new CardLayout();

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
        JPanel cardPanel = new JPanel(cardLayout);

        MP mp = new MP();
        cardPanel.add(mp, "mp");

        SelectionScreen selectionScreen = new SelectionScreen(this);
        cardPanel.add(selectionScreen, "selScreen");

        mapEditor = new MapEditor();
        cardPanel.add(mapEditor, "mapEditor");

        JFXPanel jfxPanel = new JFXPanel();
        cardPanel.add(jfxPanel, "opening");
        Platform.runLater(() -> {
            setUndecorated(true);
            String videoPath = "video/opening2.mp4";
            Media media = new Media(new File(videoPath).toURI().toString());

            // 创建MediaPlayer对象
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            mediaPlayer.setAutoPlay(true);

            // 创建MediaView对象
            MediaView mediaView = new MediaView(mediaPlayer);

            // 创建StackPane对象，将MediaView添加到其中
            StackPane stackPane = new StackPane();
            stackPane.getChildren().add(mediaView);

            // 创建Scene对象，将StackPane添加到其中
            Scene scene = new Scene(stackPane, 640,480);
//            scene.setFill(Color.BLACK);
            scene.setOnMouseClicked(e -> {
                mediaPlayer.stop();
                dispose();
                setUndecorated(false);
                setVisible(true);
                cardLayout.show(cardPanel,"selScreen");
            });
            mediaView.fitWidthProperty().bind(scene.widthProperty());
            mediaView.fitHeightProperty().bind(scene.heightProperty());

            jfxPanel.setScene(scene);
        });

        getContentPane().add(cardPanel, BorderLayout.CENTER);

        cardLayout.show(cardPanel, "opening");
//        cardLayout.previous(cardPanel);

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
            } else if (selectionScreen.editPrepared) {
                cardLayout.show(cardPanel, "mapEditor");
            }
            switch (state) {
                case 1 -> {
                    if (trunOn == 0) {
                        SwingUtilities.invokeLater(() -> {
                            try {

                                soundPlayer = new SoundPlayer("sound/CHAOS_01.wav");

                            } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
                                throw new RuntimeException(e);
                            }
                            soundPlayer.play();
                        });
                        trunOn++;
                    }
                }
                case 2 -> {
                    if (trunOn == 0) {
                        SwingUtilities.invokeLater(() -> {
                            try {

                                soundPlayer = new SoundPlayer("");

                            } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
                                throw new RuntimeException(e);
                            }
                            soundPlayer.play();
                        });
                        trunOn++;
                    }
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
