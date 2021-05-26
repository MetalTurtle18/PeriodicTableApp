package io.github.metalturtle18.periodictableapp.listeners;

import io.github.metalturtle18.periodictableapp.Main;
import io.github.metalturtle18.periodictableapp.PeriodicTableApp;
import io.github.metalturtle18.periodictableapp.frames.MainFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is a listener for the button to set the main page color scheme to an electronegativity gradient
 */
public class ElectronegativityColorListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame mainFrame = Main.mainClass.mainPage;

        // Set each element to its corresponding color based on its electronegativity
        mainFrame.allElements.forEach(element -> {
            if (element.getElement().electronegativity == -1) // If it doesn't have a specified electronegativity, make it transparent
                element.setColor(PeriodicTableApp.BACKGROUND_COLOR);
            else
                element.setColor(Color.getHSBColor(0.58f, 1.0f, (float) (element.getElement().electronegativity / 4))); // Sets a color based on its electronegativity
            element.setElectronegativityLabel();
        });

        // This helps element panels set a color
        PeriodicTableApp.displayMode = PeriodicTableApp.DisplayMode.ELECTRONEGATIVITY;

        // Change the legend panel on the main page
        mainFrame.remove(mainFrame.metalLegendPanel);
        mainFrame.remove(mainFrame.familyLegendPanel);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridwidth = 10;
        constraints.gridheight = 2;
        constraints.gridx = 9;
        constraints.gridy = 12;
        mainFrame.add(mainFrame.electronegativityLegendPanel, constraints);
        mainFrame.repaint();
    }
}
