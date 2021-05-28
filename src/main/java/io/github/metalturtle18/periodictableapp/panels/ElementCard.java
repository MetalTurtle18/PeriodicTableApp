package io.github.metalturtle18.periodictableapp.panels;

import io.github.metalturtle18.periodictableapp.Element;
import io.github.metalturtle18.periodictableapp.Main;
import io.github.metalturtle18.periodictableapp.PeriodicTableApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * This class is for making the elements squares on the main page and on information panels
 */
public class ElementCard extends JPanel implements MouseListener {

    private final Element element;
    private final boolean isInTable;
    private final JLabel numberLabel;
    private Color color;

    /**
     * The constructor sets up the panel with default properties
     *
     * @param element the type of element this card is
     * @param size    the size of this specific element card
     * @param inTable whether the card is in the table or somewhere else
     */
    public ElementCard(Element element, int size, boolean inTable) {
        super(new GridBagLayout()); // Set the layout to GridBagLayout
        this.element = element;
        isInTable = inTable;

        // Since the user can click on elements in any display mode, they should display in the correct mode even in the info panel. This switch puts them into the correct mode
        switch (PeriodicTableApp.displayMode) {
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

        // Add all of the labels for the tile
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

        // This long statement sets either the atomic mass or the electronegativity of the element depending on its display mode
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

    /**
     * Set the color of the panel
     *
     * @param color the color to set the panel to
     */
    public void setColor(Color color) {
        setBackground(color);
        this.color = color;
    }

    /**
     * Set the panel to display its electronegativity instead of its atomic mass
     */
    public void setElectronegativityLabel() {
        if (element.electronegativity == -1)
            numberLabel.setText("n/a");
        else
            numberLabel.setText(String.valueOf(element.electronegativity));
    }

    /**
     * Set the panel to display its atomic mass instead of its electronegativity
     */
    public void setAtomicMassLabel() {
        numberLabel.setText(String.valueOf(element.atomicMass));
    }

    /**
     * Getter for the element panel's element type
     *
     * @return the element type of the panel
     */
    public Element getElement() {
        return element;
    }

    /**
     * Event for when the tile is clicked.
     *
     * @param e event
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        // If the element is in the main table, it should open the info page; if it is in an info page, it should return to the periodic table
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

    /**
     * Hover effect to highlight the panel
     *
     * @param e event
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        setBackground(color.brighter());
    }

    /**
     * Hover effect to un-highlight the panel
     *
     * @param e event
     */
    @Override
    public void mouseExited(MouseEvent e) {
        setBackground(color);
    }
}
