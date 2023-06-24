package CytusRhythm.test;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class AudioGenerator {
    public static void main(String[] args) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        AudioFormat format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 44100, 16, 2, 4, 44100, false);
        DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
        TargetDataLine line = (TargetDataLine) AudioSystem.getLine(info);
        line.open(format);
        line.start();

        AudioInputStream ais = new AudioInputStream(line);
        AudioSystem.write(ais, AudioFileFormat.Type.WAVE, new File("test.wav"));

        line.stop();
        line.close();
    }
}