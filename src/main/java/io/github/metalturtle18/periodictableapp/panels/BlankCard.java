package io.github.metalturtle18.periodictableapp.panels;

import io.github.metalturtle18.periodictableapp.PeriodicTableApp;

import javax.swing.*;
import java.awt.*;

public class BlankCard extends JPanel {

    public BlankCard() {
        setBackground(PeriodicTableApp.BACKGROUND_COLOR);
        setPreferredSize(new Dimension(65, 65));
    }
}
