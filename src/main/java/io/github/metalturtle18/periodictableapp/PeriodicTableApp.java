package io.github.metalturtle18.periodictableapp;


import io.github.metalturtle18.periodictableapp.frames.ElementFrame;
import io.github.metalturtle18.periodictableapp.frames.MainFrame;

import java.awt.*;

/**
 * This class does the basic functionality of the app
 */
public class PeriodicTableApp {

    /**
     * The global background color for all panels
     */
    public static final Color BACKGROUND_COLOR = new Color(41, 42, 50);
    public static DisplayMode displayMode = DisplayMode.METAL;
    public MainFrame mainPage;
    public ElementFrame elementPage;

    public PeriodicTableApp() {
        mainPage = new MainFrame();
    }

    /**
     * Display an element info panel on the screen
     *
     * @param element the element type to display
     */
    public void openElementPage(Element element) {
        mainPage.setVisible(false);
        // If the page is already initialized, it should just change the element instead of re-initializing it
        if (elementPage == null)
            elementPage = new ElementFrame(element);
        else
            elementPage.changeElement(element);
        elementPage.setVisible(true);
    }

    /**
     * Change the element page to show the next element in the table
     *
     * @param element the current element type
     */
    public void incElementPage(Element element) {
        elementPage.changeElement(Element.values()[element.atomicNumber == 118 ? 0 : element.atomicNumber]);
    }

    /**
     * Change the element page to show the previous element in the table
     *
     * @param element the current element type
     */
    public void decElementPage(Element element) {
        elementPage.changeElement(Element.values()[element.atomicNumber == 1 ? 117 : element.atomicNumber - 2]);
    }

    /**
     * Close the currently open element page and re-open the main periodic table
     */
    public void closeElementPage() {
        mainPage.setVisible(true);
        elementPage.setVisible(false);
    }

    /**
     * The different display modes the app can be in
     */
    public enum DisplayMode {
        METAL,
        GROUP,
        ELECTRONEGATIVITY
    }
}
