package io.github.metalturtle18.periodictableapp.panels;

import io.github.metalturtle18.periodictableapp.PeriodicTableApp;

import javax.swing.*;
import java.awt.*;

public class NumberCard extends JPanel {

    public NumberCard(int width, int height, String text) {
        setBackground(PeriodicTableApp.BACKGROUND_COLOR.brighter());
        setPreferredSize(new Dimension(width, height));

        JLabel label = new JLabel(text);
        label.setFont(new Font("SFProRounded-Regular", Font.PLAIN, height / 2));
        label.setForeground(Color.WHITE);
        label.setBorder(BorderFactory.createEmptyBorder(22, 0, 0, 0));
        add(label);
    }

    /**
     * You don't need to specify a width AND height if it is a square
     * @param size the size of the width and height of the panel
     */
    public NumberCard(int size, String text) {
        this(size, size, text);
    }
}
