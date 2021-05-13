package io.github.metalturtle18.periodictableapp.panels;

import io.github.metalturtle18.periodictableapp.Element;

import javax.swing.*;
import java.awt.*;

public class ElementCard extends JPanel {

    private final Element element;
    private final JTextField atomicSymbol, name, atomicNumber, atomicMass;

    public ElementCard(Element element) {
        this.element = element;

        atomicNumber = new JTextField(String.valueOf(element.atomicNumber));
        atomicNumber.setFont(new Font("number", Font.PLAIN, 7));
        atomicNumber.setBorder(BorderFactory.createEmptyBorder());
        atomicNumber.setAlignmentX(Component.LEFT_ALIGNMENT);
        atomicNumber.setEditable(false);

        atomicSymbol = new JTextField(element.symbol);
        atomicSymbol.setFont(new Font("symbol", Font.BOLD, 15));
        atomicSymbol.setBorder(BorderFactory.createEmptyBorder());
        atomicSymbol.setAlignmentX(Component.CENTER_ALIGNMENT);
        atomicSymbol.setEditable(false);

        atomicMass = new JTextField(String.valueOf(element.atomicMass));
        atomicMass.setFont(new Font("mass", Font.BOLD, 10));
        atomicMass.setBorder(BorderFactory.createEmptyBorder());
        atomicMass.setAlignmentX(Component.CENTER_ALIGNMENT);
        atomicMass.setEditable(false);

        name = new JTextField(element.name);
        name.setFont(new Font("name", Font.BOLD, 10));
        name.setBorder(BorderFactory.createEmptyBorder());
        name.setAlignmentX(Component.CENTER_ALIGNMENT);
        name.setEditable(false);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(element.metalType.color);
        setOpaque(true);
        setSize(50, 50);

        add(atomicNumber);
        add(atomicSymbol);
        add(atomicMass);
        add(name);
    }
}
