package io.github.metalturtle18.periodictableapp.panels;

import io.github.metalturtle18.periodictableapp.PeriodicTableApp;

import javax.swing.*;
import java.awt.*;

/**
 * This class creates a blank card to put in place in the grid of elements
 */
public class BlankCard extends JPanel {

    public BlankCard(int width, int height) {
        setBackground(PeriodicTableApp.BACKGROUND_COLOR);
        setPreferredSize(new Dimension(width, height));
    }

    /**
     * So that you don't need to specify a width AND height if it is a square
     *
     * @param size the size of the width and height of the panel
     */
    public BlankCard(int size) {
        this(size, size);
    }
}
