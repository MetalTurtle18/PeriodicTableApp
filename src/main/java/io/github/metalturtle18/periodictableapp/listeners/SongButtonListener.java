package io.github.metalturtle18.periodictableapp.listeners;

import javax.sound.sampled.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class SongButtonListener implements ActionListener, LineListener {

    private boolean isPlaying = false;
    private AudioInputStream inputStream;
    private Clip clip;

    public SongButtonListener() {
        initializeAudioPlayer();
    }

    private void initializeAudioPlayer() {
        try {
            inputStream = AudioSystem.getAudioInputStream(new File("song.wav").getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(inputStream);
            clip.addLineListener(this);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void actionPerformed(ActionEvent ae) {
        if (isPlaying) {
            clip.close();
            initializeAudioPlayer();
            isPlaying = false;
        }
        else {
            clip.start();
            isPlaying = true;
        }
    }

    /**
     * This makes the button play the music again after it ends even if it hadn't been stopped
     */
    @Override
    public void update(LineEvent event) {
        if (event.getType() == LineEvent.Type.STOP && isPlaying) actionPerformed(null);
    }
}
