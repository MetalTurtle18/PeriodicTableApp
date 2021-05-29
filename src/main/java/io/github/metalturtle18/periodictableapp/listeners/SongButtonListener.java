package io.github.metalturtle18.periodictableapp.listeners;

import javax.sound.sampled.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * This class is a listener for the button to play the periodic table of elements song
 */
public class SongButtonListener implements ActionListener, LineListener {

    private boolean isPlaying = false;
    private Clip clip;

    public SongButtonListener() {
        initializeAudioPlayer();
    }

    /**
     * This method creates the audio player from scratch without starting it
     */
    private void initializeAudioPlayer() {
        try {
            @SuppressWarnings("ConstantConditions") AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(getClass().getResource("/song.wav").getFile()).getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(inputStream);
            clip.addLineListener(this); // Add a listener for when the track finishes playing
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }


    /**
     * When the button is pressed on the main page, call this method
     *
     * @param ae action event
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        // If it is playing, stop playing; if not, start playing
        if (isPlaying) {
            clip.close();
            initializeAudioPlayer();
            isPlaying = false;
        } else {
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
