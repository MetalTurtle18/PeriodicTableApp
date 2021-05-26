package io.github.metalturtle18.periodictableapp.listeners;

import io.github.metalturtle18.periodictableapp.Main;
import io.github.metalturtle18.periodictableapp.PeriodicTableApp;
import io.github.metalturtle18.periodictableapp.frames.MainFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is a listener for the button to set the main page color scheme to the element metal type colors
 */
public class MetalColorListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame mainFrame = Main.mainClass.mainPage;

        // // Set each element to its corresponding color based on its metal type
        mainFrame.allElements.forEach(element -> {
            element.setColor(element.getElement().metalType.color);
            element.setAtomicMassLabel();
        });

        // This helps element panels set a color
        PeriodicTableApp.displayMode = PeriodicTableApp.DisplayMode.METAL;

        // Change the legend panel on the main page
        mainFrame.remove(mainFrame.familyLegendPanel);
        mainFrame.remove(mainFrame.electronegativityLegendPanel);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridwidth = 5;
        constraints.gridheight = 2;
        constraints.gridx = 14;
        constraints.gridy = 12;
        mainFrame.add(mainFrame.metalLegendPanel, constraints);
        mainFrame.repaint();
    }
}
