package io.github.metalturtle18.periodictableapp.panels;

import io.github.metalturtle18.periodictableapp.PeriodicTableApp;

import javax.swing.*;
import java.awt.*;

public class BlankCard extends JPanel {

    public BlankCard(int width, int height) {
        setBackground(PeriodicTableApp.BACKGROUND_COLOR);
        setPreferredSize(new Dimension(width, height));
    }

    /**
     * You don't need to specify a width AND height if it is a square
     *
     * @param size the size of the width and height of the panel
     */
    public BlankCard(int size) {
        this(size, size);
    }
}
