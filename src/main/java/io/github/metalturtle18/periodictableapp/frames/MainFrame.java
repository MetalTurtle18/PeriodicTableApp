package io.github.metalturtle18.periodictableapp.frames;

import io.github.metalturtle18.periodictableapp.Element;
import io.github.metalturtle18.periodictableapp.PeriodicTableApp;
import io.github.metalturtle18.periodictableapp.panels.BlankCard;
import io.github.metalturtle18.periodictableapp.panels.ElementCard;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame() {
        super("Periodic Table App");
        setLayout(new GridBagLayout());

        JPanel elementPanel, lanActPanel;
        JPanel[][] elements = new JPanel[7][18];
        JPanel[][] lanActs = new JPanel[2][15];

        // Filling arrays with blank tiles
        for (int r = 0; r < elements.length; r++) {
            for (int c = 0; c < elements[0].length; c++) {
                elements[r][c] = new BlankCard();
            }
        }
        for (int r = 0; r < lanActs.length; r++) {
            for (int c = 0; c < lanActs[0].length; c++) {
                lanActs[r][c] = new BlankCard();
            }
        }

        // Fill arrays with proper element tiles
        int col6 = 0;
        int col7 = 0;
        for (Element e : Element.values()) {
            if (e.group != -1) {
                elements[e.period - 1][e.group - 1] = new ElementCard(e);
            } else if (e.period == 6) {
                lanActs[0][col6] = new ElementCard(e);
                col6++;
            } else {
                lanActs[1][col7] = new ElementCard(e);
                col7++;
            }
        }

        // Create main element panel
        elementPanel = new JPanel(new GridLayout(7, 18, 4, 4));
        elementPanel.setBackground(PeriodicTableApp.BACKGROUND_COLOR);
        for (JPanel[] row : elements) {
            for (JPanel p : row) {
                elementPanel.add(p);
            }
        }
        elementPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));

        // Create lanthanide and actinide panel
        lanActPanel = new JPanel(new GridLayout(2, 15, 4, 4));
        lanActPanel.setBackground(PeriodicTableApp.BACKGROUND_COLOR);
        for (JPanel[] row : lanActs) {
            for (JPanel p : row) {
                lanActPanel.add(p);
            }
        }
        lanActPanel.setBorder(BorderFactory.createEmptyBorder(10, 158, 20, 20));


        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 18;
        constraints.gridheight = 7;
        add(elementPanel, constraints);

        constraints.gridx = 2;
        constraints.gridy = 7;
        constraints.gridwidth = 15;
        constraints.gridheight = 2;
        add(lanActPanel, constraints);

        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(true);
        getContentPane().setBackground(PeriodicTableApp.BACKGROUND_COLOR);
        setVisible(true);
    }
}
