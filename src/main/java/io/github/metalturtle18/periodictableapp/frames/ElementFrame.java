package io.github.metalturtle18.periodictableapp.frames;

import io.github.metalturtle18.periodictableapp.Element;
import io.github.metalturtle18.periodictableapp.PeriodicTableApp;
import io.github.metalturtle18.periodictableapp.panels.ElementCard;

import javax.swing.*;
import java.awt.*;

public class ElementFrame extends JFrame {

    public Element element;

    public ElementFrame(Element element) {
        super("Properties of " + element.name);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(PeriodicTableApp.BACKGROUND_COLOR);
        setResizable(false);

        JPanel elementTilePanel, infoPanel;
        JLabel label;

        elementTilePanel = new JPanel();
        elementTilePanel.add(new ElementCard(element, 200, false));
        elementTilePanel.setPreferredSize(new Dimension(200, 200));

        infoPanel = new JPanel();

        label = new JLabel("•Metal Type: " + capitalize(element.metalType.name()));
        infoPanel.add(label);

        label = new JLabel("•Electronegativity: " + (element.electronegativity >= 0 ? element.electronegativity : "not applicable"));
        infoPanel.add(label);

        label = new JLabel("•Group: " + (element.group >= 0 ? element.group : (element.period == 6 ? "lanthanides" : "actinides")) + "; Period: " + element.period);
        infoPanel.add(label);

        infoPanel.setPreferredSize(new Dimension(230, 300));

        add(elementTilePanel);
        add(infoPanel);
        pack();
        setVisible(true);
    }

    private String capitalize(String str) {
        return str.substring(0, 1).toUpperCase() + str.toLowerCase().substring(1);
    }
}
