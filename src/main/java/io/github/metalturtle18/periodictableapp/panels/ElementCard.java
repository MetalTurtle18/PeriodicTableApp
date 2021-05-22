package io.github.metalturtle18.periodictableapp.panels;

import io.github.metalturtle18.periodictableapp.Element;
import io.github.metalturtle18.periodictableapp.Main;
import io.github.metalturtle18.periodictableapp.PeriodicTableApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ElementCard extends JPanel implements MouseListener {

    private final Element element;
    private final boolean isInTable;

    private Color color;
    private final JLabel numberLabel;

    public ElementCard(Element element, int size, boolean inTable) {
        super(new GridBagLayout()); // Set the layout to GridBagLayout
        this.element = element;
        isInTable = inTable;

        switch(PeriodicTableApp.displayMode) {
            case GROUP -> color = element.elementFamily.color;
            case ELECTRONEGATIVITY -> {
                if (element.electronegativity != -1)
                    color = Color.getHSBColor(0.58f, 1.0f, (float) (element.electronegativity / 4));
                else
                    color = PeriodicTableApp.BACKGROUND_COLOR;
            }
            default -> color = element.metalType.color;
        }

        JLabel label;
        GridBagConstraints constraints = new GridBagConstraints();

        label = new JLabel(String.valueOf(element.atomicNumber));
        label.setFont(new Font("SFProRounded-Regular", Font.PLAIN, (int) (size / 4.64)));
        label.setForeground(Color.WHITE);
        label.addMouseListener(this);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(label, constraints);

        label = new JLabel(element.symbol);
        label.setFont(new Font("SFProRounded-Bold", Font.PLAIN, (int) (size / 3.25)));
        label.setForeground(element.stateAtRoomTemperature.color);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.addMouseListener(this);
        constraints.gridy = 1;
        constraints.gridwidth = 5;
        constraints.gridheight = 2;
        add(label, constraints);

        numberLabel = new JLabel(String.valueOf(PeriodicTableApp.displayMode == PeriodicTableApp.DisplayMode.ELECTRONEGATIVITY ? (element.electronegativity != -1 ? element.electronegativity : "n/a") : element.atomicMass));
        numberLabel.setFont(new Font("SFProRounded-Regular", Font.PLAIN, (int) (size / 6.5)));
        numberLabel.setForeground(Color.WHITE);
        numberLabel.setHorizontalAlignment(JLabel.CENTER);
        numberLabel.addMouseListener(this);
        constraints.gridy = 3;
        constraints.gridheight = 1;
        add(numberLabel, constraints);

        label = new JLabel(element.name);
        label.setFont(new Font("SFProRounded-Regular", Font.PLAIN, (int) (size / 6.5)));
        label.setForeground(Color.WHITE);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.addMouseListener(this);
        constraints.gridy = 4;
        add(label, constraints);

        setBackground(color);
        setPreferredSize(new Dimension(size, size));
        addMouseListener(this);
    }

    public void setColor(Color color) {
        setBackground(color);
        this.color = color;
    }

    public void setElectronegativityLabel() {
        if (element.electronegativity == -1)
            numberLabel.setText("n/a");
        else
            numberLabel.setText(String.valueOf(element.electronegativity));
    }

    public void setAtomicMassLabel() {
        numberLabel.setText(String.valueOf(element.atomicMass));
    }

    public Element getElement() {
        return element;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (isInTable)
            Main.mainClass.openElementPage(element);
        else
            Main.mainClass.closeElementPage();
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        setBackground(color.brighter());
    }

    @Override
    public void mouseExited(MouseEvent e) {
        setBackground(color);
    }
}
