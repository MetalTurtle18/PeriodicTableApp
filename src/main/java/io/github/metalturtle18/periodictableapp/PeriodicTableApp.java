package io.github.metalturtle18.periodictableapp;


import io.github.metalturtle18.periodictableapp.frames.ElementFrame;
import io.github.metalturtle18.periodictableapp.frames.MainFrame;

import java.awt.*;

public class PeriodicTableApp {

    public enum DisplayMode {
        METAL,
        GROUP,
        ELECTRONEGATIVITY
    }

    public static final Color BACKGROUND_COLOR = new Color(41, 42, 50);

    public MainFrame mainPage;
    public ElementFrame elementPage;

    public static DisplayMode displayMode = DisplayMode.METAL;

    public PeriodicTableApp() {
        mainPage = new MainFrame();
    }

    public void openElementPage(Element element) {
        mainPage.setVisible(false);
        elementPage = new ElementFrame(element);
    }

    public void closeElementPage() {
        mainPage.setVisible(true);
        elementPage.dispose();
    }
}
