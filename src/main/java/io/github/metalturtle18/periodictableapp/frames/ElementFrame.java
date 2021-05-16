package io.github.metalturtle18.periodictableapp.frames;

import io.github.metalturtle18.periodictableapp.Element;
import io.github.metalturtle18.periodictableapp.panels.ElementCard;

import javax.swing.*;

public class ElementFrame extends JFrame {

    public Element element;

    public ElementFrame(Element element) {
        super("Properties of " + element.name);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(new ElementCard(element, 200, false));
        pack();
        setVisible(true);
    }
}
