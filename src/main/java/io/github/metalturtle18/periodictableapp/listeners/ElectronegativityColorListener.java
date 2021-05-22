package io.github.metalturtle18.periodictableapp.listeners;

import io.github.metalturtle18.periodictableapp.Main;
import io.github.metalturtle18.periodictableapp.PeriodicTableApp;
import io.github.metalturtle18.periodictableapp.frames.MainFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ElectronegativityColorListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame mainFrame = Main.mainClass.mainPage;

        mainFrame.allElements.forEach(element -> {
            if (element.getElement().electronegativity == -1)
                element.setColor(PeriodicTableApp.BACKGROUND_COLOR);
            else
                element.setColor(Color.getHSBColor(0.58f, 1.0f, (float) (element.getElement().electronegativity / 4)));
            element.setElectronegativityLabel();
        });

        PeriodicTableApp.displayMode = PeriodicTableApp.DisplayMode.ELECTRONEGATIVITY;

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
