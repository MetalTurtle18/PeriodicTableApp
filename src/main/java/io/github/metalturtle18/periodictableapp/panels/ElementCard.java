package io.github.metalturtle18.periodictableapp.panels;

import io.github.metalturtle18.periodictableapp.Element;
import io.github.metalturtle18.periodictableapp.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ElementCard extends JPanel implements MouseListener {

    private final Element element;
    private final boolean isInTable;

    private Color color;

    public ElementCard(Element element, int size, boolean inTable) {
        super(new GridBagLayout()); // Set the layout to GridBagLayout
        this.element = element;
        isInTable = inTable;
        color = element.metalType.color;

        JLabel label;
        GridBagConstraints constraints = new GridBagConstraints();

        label = new JLabel(String.valueOf(element.atomicNumber));
        label.setFont(new Font("SFProRounded-Regular", Font.PLAIN, (int) (size / 4.64)));
        label.addMouseListener(this);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        add(label, constraints);

        label = new JLabel(element.symbol);
        label.setFont(new Font("SFProRounded-Bold", Font.PLAIN, (int) (size / 3.25)));
        label.addMouseListener(this);
        constraints.gridy = 1;
        constraints.gridwidth = 5;
        constraints.gridheight = 2;
        add(label, constraints);

        label = new JLabel(String.valueOf(element.atomicMass));
        label.setFont(new Font("SFProRounded-Regular", Font.PLAIN, (int) (size / 6.5)));
        label.addMouseListener(this);
        constraints.gridy = 3;
        constraints.gridheight = 1;
        add(label, constraints);

        label = new JLabel(element.name);
        label.setFont(new Font("SFProRounded-Regular", Font.PLAIN, (int) (size / 6.5)));
        label.addMouseListener(this);
        constraints.gridy = 4;
        add(label, constraints);

        setBackground(element.metalType.color);
        setPreferredSize(new Dimension(size, size));
        addMouseListener(this);
    }

    public void setColor(Color color) {
        setBackground(color);
        this.color = color;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(element.name);
        if (isInTable)
            Main.mainClass.openElementPage(element);
        else
            Main.mainClass.closeElementPage();
    }

    @Override
    public void mousePressed(MouseEvent e) { }

    @Override
    public void mouseReleased(MouseEvent e) { }

    @Override
    public void mouseEntered(MouseEvent e) {
        setBackground(color.brighter());
    }

    @Override
    public void mouseExited(MouseEvent e) {
        setBackground(color);
    }
}
