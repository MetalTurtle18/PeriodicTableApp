package io.github.metalturtle18.periodictableapp.panels;

import io.github.metalturtle18.periodictableapp.Element;

import javax.swing.*;
import java.awt.*;

public class ElementCard extends JPanel {

    private final Element element;
    private final JLabel atomicNumber, atomicSymbol, name, atomicMass;
    private final JPanel atomicNumberPanel, atomicSymbolPanel, namePanel, atomicMassPanel;
    private final int height, width;

    public ElementCard(Element element, int height, int width) {
        this.element = element;
        this.height = height;
        this.width = width;

        atomicNumber = new JLabel(String.valueOf(element.atomicNumber));
        atomicNumber.setFont(new Font("number", Font.PLAIN, 10));
        atomicNumber.setBorder(BorderFactory.createEmptyBorder());
        atomicNumberPanel = new JPanel();
        ((FlowLayout) atomicNumberPanel.getLayout()).setVgap(0);
        ((FlowLayout) atomicNumberPanel.getLayout()).setHgap(0);
        atomicNumberPanel.add(atomicNumber);
        atomicNumberPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
        atomicNumberPanel.setBackground(element.metalType.color);

        atomicSymbol = new JLabel(element.symbol);
        atomicSymbol.setFont(new Font("symbol", Font.BOLD, 20));
        atomicSymbol.setBorder(BorderFactory.createEmptyBorder());
        atomicSymbolPanel = new JPanel();
        ((FlowLayout) atomicSymbolPanel.getLayout()).setVgap(0);
        ((FlowLayout) atomicSymbolPanel.getLayout()).setHgap(0);
        atomicSymbolPanel.add(atomicSymbol);
        atomicSymbolPanel.setBackground(element.metalType.color);

        atomicMass = new JLabel(String.valueOf(element.atomicMass));
        atomicMass.setFont(new Font("mass", Font.BOLD, 12));
        atomicMass.setBorder(BorderFactory.createEmptyBorder());
        atomicMassPanel = new JPanel();
        ((FlowLayout) atomicMassPanel.getLayout()).setVgap(0);
        ((FlowLayout) atomicMassPanel.getLayout()).setHgap(0);
        atomicMassPanel.add(atomicMass);
        atomicMassPanel.setBackground(element.metalType.color);

        name = new JLabel(element.name);
        name.setFont(new Font("name", Font.BOLD, 10));
        name.setBorder(BorderFactory.createEmptyBorder());
        namePanel = new JPanel();
        ((FlowLayout) namePanel.getLayout()).setVgap(0);
        ((FlowLayout) namePanel.getLayout()).setHgap(0);
        namePanel.add(name);
        namePanel.setBackground(element.metalType.color);

        add(atomicNumberPanel);
        add(atomicSymbolPanel);
        add(atomicMassPanel);
        add(namePanel);

        BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(layout);
        setBackground(element.metalType.color);
        setPreferredSize(new Dimension(width, height));
    }
}
