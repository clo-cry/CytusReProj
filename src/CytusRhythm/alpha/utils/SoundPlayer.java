package CytusRhythm.alpha.utils;

import java.io.File;
import java.util.Scanner;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SoundPlayer {

    // define storage for start position
    Long nowFrame;
    Clip clip;

    // get the clip status
    String theStatus;

    AudioInputStream audioStream;
    static String thePath = thePath = ".\\sound\\CHAOS_01.wav";

    // initialize both the clip and streams
    public SoundPlayer()
            throws UnsupportedAudioFileException,
            IOException, LineUnavailableException {
        // the input stream object
        audioStream =
                AudioSystem.getAudioInputStream(
                        new File(thePath)
                                .getAbsoluteFile());

        // the reference to the clip
        clip = AudioSystem.getClip();

        clip.open(audioStream);

        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public static void main(String[] args) {
        try {
            //add the path to the audio file
//            thePath = "add the path to the audio file here";

            SoundPlayer simpleSoundPlayer =
                    new SoundPlayer();

            simpleSoundPlayer.play();
            Scanner scanned = new Scanner(System.in);

            //show the options
            while (true) {
                System.out.println("1. pause");
                System.out.println("2. resume");
                System.out.println("3. restart");
                System.out.println("4. stop");
                System.out.println("5. Jump to specific time");
                int a = scanned.nextInt();
                simpleSoundPlayer.gotoChoice(a);
                if (a == 4)
                    break;
            }
            scanned.close();
        } catch (Exception e) {
            System.out.println("Experienced an error while playing sound.");
            e.printStackTrace();

        }
    }

    // operation is now as per the user's choice

    private void gotoChoice(int a)
            throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        switch (a) {
            case 1:
                pause();
                break;
            case 2:
                resumeAudio();
                break;
            case 3:
                restart();
                break;
            case 4:
                stop();
                break;
            case 5:
                System.out.println("Selected time (" + 0 +
                        ", " + clip.getMicrosecondLength() + ")");
                Scanner scan = new Scanner(System.in);
                long cc = scan.nextLong();
                jump(cc);
                break;

        }

    }

    // play
    public void play() {
        //start the clip
        clip.start();

        theStatus = "play";
    }

    // Pause audio
    public void pause() {
        if (theStatus.equals("paused")) {
            System.out.println("audio is already paused");
            return;
        }
        this.nowFrame =
                this.clip.getMicrosecondPosition();
        clip.stop();
        theStatus = "paused";
    }

    // resume audio
    public void resumeAudio() throws UnsupportedAudioFileException,
            IOException, LineUnavailableException {
        if (theStatus.equals("play")) {
            System.out.println("The audio is" +
                    "being played");
            return;
        }
        clip.close();
        resetAudioStream();
        clip.setMicrosecondPosition(nowFrame);
        this.play();
    }

    // restart audio
    public void restart() throws IOException, LineUnavailableException,
            UnsupportedAudioFileException {
        clip.stop();
        clip.close();
        resetAudioStream();
        nowFrame = 0L;
        clip.setMicrosecondPosition(0);
        this.play();
    }

    // stop audio
    public void stop() throws UnsupportedAudioFileException,
            IOException, LineUnavailableException {
        nowFrame = 0L;
        clip.stop();
        clip.close();
    }

    // jump to a selected point
    public void jump(long a) throws UnsupportedAudioFileException, IOException,
            LineUnavailableException {
        if (a > 0 && a < clip.getMicrosecondLength()) {
            clip.stop();
            clip.close();
            resetAudioStream();
            nowFrame = a;
            clip.setMicrosecondPosition(a);
            this.play();
        }
    }

    // reset the audio stream
    public void resetAudioStream() throws UnsupportedAudioFileException, IOException,
            LineUnavailableException {
        audioStream = AudioSystem.getAudioInputStream(
                new File(thePath).getAbsoluteFile());
        clip.open(audioStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

}

