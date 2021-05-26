package io.github.metalturtle18.periodictableapp;


import io.github.metalturtle18.periodictableapp.frames.ElementFrame;
import io.github.metalturtle18.periodictableapp.frames.MainFrame;

import java.awt.*;

/**
 * This class does the basic functionality of the app
 */
public class PeriodicTableApp {

    /**
     * The different display modes the app can be in
     */
    public enum DisplayMode {
        METAL,
        GROUP,
        ELECTRONEGATIVITY
    }

    /**
     * The global background color for all panels
     */
    public static final Color BACKGROUND_COLOR = new Color(41, 42, 50);

    public MainFrame mainPage;
    public ElementFrame elementPage;

    public static DisplayMode displayMode = DisplayMode.METAL;

    public PeriodicTableApp() {
        mainPage = new MainFrame();
    }

    /**
     * Display an element info panel on the screen
     * @param element the element type to display
     */
    public void openElementPage(Element element) {
        mainPage.setVisible(false);
        elementPage = new ElementFrame(element);
    }

    /**
     * Close the currently open element page and re-open the main periodic table
     */
    public void closeElementPage() {
        mainPage.setVisible(true);
        elementPage.dispose();
    }
}
