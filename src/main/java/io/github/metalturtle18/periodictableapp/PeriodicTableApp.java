package io.github.metalturtle18.periodictableapp;


import io.github.metalturtle18.periodictableapp.frames.ElementFrame;
import io.github.metalturtle18.periodictableapp.frames.MainFrame;

import javax.swing.*;
import java.awt.*;

public class PeriodicTableApp {

    public static final Color BACKGROUND_COLOR = new Color(41, 42, 50);

    public JFrame mainPage, elementPage;

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
