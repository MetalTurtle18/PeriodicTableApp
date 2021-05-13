package io.github.metalturtle18.periodictableapp;


import io.github.metalturtle18.periodictableapp.frames.MainFrame;
import org.pushingpixels.substance.api.skin.SubstanceNightShadeLookAndFeel;

import javax.swing.*;

public class PeriodicTableApp {

    public static final boolean DARK = false; // debugging

    public JFrame mainPage;

    public PeriodicTableApp() {
        if (DARK) {
            SwingUtilities.invokeLater(() -> {
                try {
                    UIManager.setLookAndFeel(new SubstanceNightShadeLookAndFeel()); // Set the skin for the whole window
                } catch (Exception e) {
                    System.out.println("Substance Night Shade failed to initialize");
                    e.printStackTrace();
                    System.exit(1);
                }
                mainPage = new MainFrame();
                mainPage.setVisible(true);
            });
        } else {
            mainPage = new MainFrame();
            mainPage.setVisible(true);
        }
    }
}
