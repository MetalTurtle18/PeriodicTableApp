package io.github.metalturtle18.periodictableapp.frames;

import io.github.metalturtle18.periodictableapp.Element;
import io.github.metalturtle18.periodictableapp.panels.ElementCard;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame() {
        super("Periodic Table App");
        setLayout(new FlowLayout());
        int i = 0;
        for (Element e : Element.values()) {
            add(new ElementCard(e));
            i++;
            if (i > 35) break;
        }
        setSize(600, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
