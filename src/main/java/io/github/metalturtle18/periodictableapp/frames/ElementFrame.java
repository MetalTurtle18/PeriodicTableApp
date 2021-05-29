package io.github.metalturtle18.periodictableapp.frames;

import io.github.metalturtle18.periodictableapp.Element;
import io.github.metalturtle18.periodictableapp.Main;
import io.github.metalturtle18.periodictableapp.PeriodicTableApp;
import io.github.metalturtle18.periodictableapp.panels.ElementCard;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;

/**
 * This class shows the individual element frames for clicking on each element
 */
public class ElementFrame extends JFrame {

    private final JPanel elementTilePanel, clipboardButtonContainer;
    private final JLabel metalTypeLabel, electronegativityLabel, groupPeriodLabel;
    private ElementCard elementCard;

    public ElementFrame(Element element) {
        super("Properties of " + capitalize(element.name));
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(PeriodicTableApp.BACKGROUND_COLOR);
        setResizable(false);

        JPanel infoPanel;

        // Create the element tile panel for the window
        elementTilePanel = new JPanel();
        elementCard = new ElementCard(element, 200, false);
        elementTilePanel.add(elementCard);
        elementTilePanel.setBackground(PeriodicTableApp.BACKGROUND_COLOR);
        elementTilePanel.setBorder(BorderFactory.createEmptyBorder());

        // Create the element information panel for the window
        infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setBackground(PeriodicTableApp.BACKGROUND_COLOR);

        // Add the actual information to the panel
        metalTypeLabel = new JLabel("• Metal Type: " + capitalize(element.metalType.name()));
        metalTypeLabel.setFont(new Font("SFProRounded-Regular", Font.PLAIN, 30));
        metalTypeLabel.setForeground(Color.WHITE);
        metalTypeLabel.setHorizontalAlignment(JLabel.LEFT);
        metalTypeLabel.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        infoPanel.add(metalTypeLabel);

        electronegativityLabel = new JLabel("• Electronegativity: " + (element.electronegativity >= 0 ? element.electronegativity : "not applicable"));
        electronegativityLabel.setFont(new Font("SFProRounded-Regular", Font.PLAIN, 30));
        electronegativityLabel.setForeground(Color.WHITE);
        electronegativityLabel.setHorizontalAlignment(JLabel.LEFT);
        electronegativityLabel.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        infoPanel.add(electronegativityLabel);

        groupPeriodLabel = new JLabel("• Group: " + (element.group >= 0 ? element.group : (element.period == 6 ? "lanthanides" : "actinides")) + "; Period: " + element.period);
        groupPeriodLabel.setFont(new Font("SFProRounded-Regular", Font.PLAIN, 30));
        groupPeriodLabel.setForeground(Color.WHITE);
        groupPeriodLabel.setHorizontalAlignment(JLabel.LEFT);
        groupPeriodLabel.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        infoPanel.add(groupPeriodLabel);

        JButton clipboardButton = new JButton("Copy to clipboard");
        clipboardButton.setFont(new Font("SFProRounded-Regular", Font.PLAIN, 25));
        clipboardButton.setForeground(Color.WHITE);
        clipboardButton.setBorderPainted(false);
        clipboardButton.addActionListener(e -> copyDataToClipboard());
        clipboardButtonContainer = new JPanel();
        clipboardButtonContainer.setLayout(new BorderLayout());
        clipboardButtonContainer.setBackground(elementCard.getBackground());
        clipboardButtonContainer.add(clipboardButton, BorderLayout.CENTER);
        clipboardButtonContainer.setPreferredSize(new Dimension(infoPanel.getWidth(), 80));
        clipboardButtonContainer.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        clipboardButtonContainer.setAlignmentY(JComponent.BOTTOM_ALIGNMENT);
        infoPanel.add(clipboardButtonContainer);

        add(elementTilePanel);
        add(infoPanel);
        registerShortcuts();
        pack();
        setLocationRelativeTo(null); // This centers the window on the screen
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

    /**
     * This method registers the keyboard shortcuts for the app
     */
    private void registerShortcuts() {
        InputMap map = rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        map.put(KeyStroke.getKeyStroke("B"), "back");
        map.put(KeyStroke.getKeyStroke("C"), "copy");
        map.put(KeyStroke.getKeyStroke("LEFT"), "previous");
        map.put(KeyStroke.getKeyStroke("RIGHT"), "next");

        // Register actions to the commands
        rootPane.getActionMap().put("back", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elementCard.mouseClicked(null);
            }
        });
        rootPane.getActionMap().put("copy", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                copyDataToClipboard();
            }
        });
        rootPane.getActionMap().put("previous", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.mainClass.decElementPage(elementCard.getElement());
            }
        });
        rootPane.getActionMap().put("next", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.mainClass.incElementPage(elementCard.getElement());
            }
        });
    }

    /**
     * Change the currently displayed element on the page to a new one
     *
     * @param element the element to change it to
     */
    public void changeElement(Element element) {
        elementCard = new ElementCard(element, 200, false);
        elementTilePanel.remove(0);
        elementTilePanel.add(elementCard);
        setTitle("Properties of " + capitalize(element.name));
        metalTypeLabel.setText("• Metal Type: " + capitalize(element.metalType.name()));
        electronegativityLabel.setText("• Electronegativity: " + (element.electronegativity >= 0 ? element.electronegativity : "not applicable"));
        groupPeriodLabel.setText("• Group: " + (element.group >= 0 ? element.group : (element.period == 6 ? "lanthanides" : "actinides")) + "; Period: " + element.period);
        clipboardButtonContainer.setBackground(elementCard.getBackground());
        pack();
        repaint();
    }

    /**
     * This method creates a string with the element properties and saves it to the clipboard
     */
    public void copyDataToClipboard() {
        StringBuilder text = new StringBuilder();
        Element element = elementCard.getElement();
        // Create the text string
        text.append(capitalize(element.name))
                .append(" (")
                .append(capitalize(element.symbol)) // Element symbol
                .append("); ")
                .append("atomic number ")
                .append(element.atomicNumber) // Atomic number
                .append("; ")
                .append("atomic mass ")
                .append(element.atomicMass) // Atomic mass
                .append("; ")
                .append(element.metalType.toString().toLowerCase()) // Metal type
                .append("; ")
                .append("electronegativity ")
                .append(element.electronegativity == -1 ? "not applicable" : element.electronegativity) // Electronegativity
                .append("; ")
                .append("group ")
                .append((element.group >= 0 ? element.group : (element.period == 6 ? "lanthanides" : "actinides"))) // Element group
                .append("; ")
                .append("period ")
                .append(element.period); // Element period

        // Add the string to the clipboard
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(text.toString()), null);
    }
}
