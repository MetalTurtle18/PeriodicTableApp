package io.github.metalturtle18.periodictableapp.frames;

import io.github.metalturtle18.periodictableapp.Element;
import io.github.metalturtle18.periodictableapp.PeriodicTableApp;
import io.github.metalturtle18.periodictableapp.panels.ElementCard;

import javax.swing.*;
import java.awt.*;

/**
 * This class shows the individual element frames for clicking on each element
 */
public class ElementFrame extends JFrame {

    public ElementFrame(Element element) {
        super("Properties of " + capitalize(element.name));
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(PeriodicTableApp.BACKGROUND_COLOR);
        setResizable(false);

        JPanel elementTilePanel, infoPanel;
        JLabel label;

        // Create the element tile panel for the window
        elementTilePanel = new JPanel();
        elementTilePanel.add(new ElementCard(element, 200, false));
        elementTilePanel.setBackground(PeriodicTableApp.BACKGROUND_COLOR);
        elementTilePanel.setBorder(BorderFactory.createEmptyBorder());

        // Create the element information panel for the window
        infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setBackground(PeriodicTableApp.BACKGROUND_COLOR);

        // Add the actual information to the panel
        label = new JLabel("• Metal Type: " + capitalize(element.metalType.name()));
        label.setFont(new Font("SFProRounded-Regular", Font.PLAIN, 30));
        label.setForeground(Color.WHITE);
        infoPanel.add(label);

        label = new JLabel("• Electronegativity: " + (element.electronegativity >= 0 ? element.electronegativity : "not applicable"));
        label.setFont(new Font("SFProRounded-Regular", Font.PLAIN, 30));
        label.setForeground(Color.WHITE);
        infoPanel.add(label);

        label = new JLabel("• Group: " + (element.group >= 0 ? element.group : (element.period == 6 ? "lanthanides" : "actinides")) + "; Period: " + element.period);
        label.setFont(new Font("SFProRounded-Regular", Font.PLAIN, 30));
        label.setForeground(Color.WHITE);
        infoPanel.add(label);

        add(elementTilePanel);
        add(infoPanel);
        pack();
        setLocationRelativeTo(null); // This centers the window on the screen
        setVisible(true);
    }

    /**
     * Simple static method to capitalize the first character of a string
     *
     * @param str the string to capitalize
     * @return the capitalized string
     */
    private static String capitalize(String str) {
        return str.substring(0, 1).toUpperCase() + str.toLowerCase().substring(1);
    }
}
