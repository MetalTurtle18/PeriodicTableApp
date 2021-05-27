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
     * Close the current element page and display the page for the next element in the table
     * @param element the current element type
     */
    public void incElementPage(Element element) {
        elementPage.dispose(); // TODO: Change these to edit the existing frame instead of creating a new one
        elementPage = new ElementFrame(Element.values()[element.atomicNumber == 118 ? 0 : element.atomicNumber]);
    }

    /**
     * Close the current element page and display the page for the previous element in the table
     * @param element the current element type
     */
    public void decElementPage(Element element) {
        elementPage.dispose();
        elementPage = new ElementFrame(Element.values()[element.atomicNumber == 1 ? 117 : element.atomicNumber - 2]);
    }

    /**
     * Close the currently open element page and re-open the main periodic table
     */
    public void closeElementPage() {
        mainPage.setVisible(true);
        elementPage.dispose();
    }
}
