package io.github.metalturtle18.periodictableapp.panels;

import io.github.metalturtle18.periodictableapp.PeriodicTableApp;

import javax.swing.*;
import java.awt.*;

/**
 * This class creates a panel that contains only a number
 */
public class NumberCard extends JPanel {

    /**
     * Place the text on the right of the panel
     */
    public static final String RIGHT = "right";
    /**
     * Place the text on the bottom of the panel
     */
    public static final String BOTTOM = "bottom";

    /**
     * Construct a new number panel
     *
     * @param width    the width of the panel
     * @param height   the height of the panel
     * @param text     the number on the panel
     * @param location if the panel should be on the right of left
     */
    public NumberCard(int width, int height, String text, String location) {
        setBackground(PeriodicTableApp.BACKGROUND_COLOR);
        setPreferredSize(new Dimension(width, height));

        JLabel label = new JLabel(text);
        label.setFont(new Font("SFProRounded-Regular", Font.PLAIN, height / 2));
        label.setForeground(Color.WHITE);

        // The number can be on the right side of the panel or on the bottom depending on the input in the constructor
        if (location.equals("right"))
            setLayout(new FlowLayout(FlowLayout.RIGHT));
        else
            label.setBorder(BorderFactory.createEmptyBorder(22, 0, 0, 0));

        add(label);
    }

    /**
     * So that you don't need to specify a width AND height if it is a square
     *
     * @param size the size of the width and height of the panel
     */
    public NumberCard(int size, String text, String location) {
        this(size, size, text, location);
    }
}
