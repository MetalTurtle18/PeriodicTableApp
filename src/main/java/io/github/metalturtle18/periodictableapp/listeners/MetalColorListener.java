package io.github.metalturtle18.periodictableapp.listeners;

import io.github.metalturtle18.periodictableapp.Main;
import io.github.metalturtle18.periodictableapp.PeriodicTableApp;
import io.github.metalturtle18.periodictableapp.frames.MainFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MetalColorListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame mainFrame = Main.mainClass.mainPage;

        mainFrame.allElements.forEach(element -> {
            element.setColor(element.getElement().metalType.color);
            element.setAtomicMassLabel();
        });

        PeriodicTableApp.displayMode = PeriodicTableApp.DisplayMode.METAL;

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
