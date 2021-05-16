package io.github.metalturtle18.periodictableapp.frames;

import io.github.metalturtle18.periodictableapp.Element;
import io.github.metalturtle18.periodictableapp.PeriodicTableApp;
import io.github.metalturtle18.periodictableapp.panels.BlankCard;
import io.github.metalturtle18.periodictableapp.panels.ElementCard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainFrame extends JFrame implements MouseListener {

    JPanel[][] elements, lanActs;

    public MainFrame() {
        super("Periodic Table App");
        setLayout(new GridBagLayout());

        JPanel elementPanel, lanActPanel, buttonPanel;
        JLabel redLabel;

         elements = new JPanel[7][18];
         lanActs = new JPanel[2][15];

         // Fill the arrays with blank tiles
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

        // Fill the arrays with the proper element tiles
        int col6 = 0;
        int col7 = 0;
        for (Element e : Element.values()) {
            if (e.group != -1) {
                elements[e.period - 1][e.group - 1] = new ElementCard(e, 65, true);
            } else if (e.period == 6) {
                lanActs[0][col6] = new ElementCard(e, 65, true);
                col6++;
            } else {
                lanActs[1][col7] = new ElementCard(e, 65, true);
                col7++;
            }
        }

        // Create main element panel
        elementPanel = new JPanel(new GridLayout(7, 18, 4, 4));
        elementPanel.setBackground(PeriodicTableApp.BACKGROUND_COLOR);
        elementPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));
        for (JPanel[] row : elements) {
            for (JPanel p : row) {
                elementPanel.add(p);
            }
        }

        // Create lanthanide and actinide panel
        lanActPanel = new JPanel(new GridLayout(2, 15, 4, 4));
        lanActPanel.setBackground(PeriodicTableApp.BACKGROUND_COLOR);
        lanActPanel.setBorder(BorderFactory.createEmptyBorder(10, 158, 20, 20));
        for (JPanel[] row : lanActs) {
            for (JPanel p : row) {
                lanActPanel.add(p);
            }
        }

        // The red button is for testing changing the table colors
        redLabel = new JLabel("Make Red");
        redLabel.addMouseListener(this);
        buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.RED);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        buttonPanel.addMouseListener(this);
        buttonPanel.add(redLabel);


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

        constraints.gridx = 0;
        constraints.gridy = 9;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        add(buttonPanel, constraints);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(PeriodicTableApp.BACKGROUND_COLOR);
        pack();
        setResizable(false);
        setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        for (JPanel[] r : elements) {
            for (JPanel p : r) {
                if (p instanceof ElementCard) {
                    ((ElementCard) p).setColor(new Color(127, 60, 60));
                }
            }
        }

        for (JPanel[] r : lanActs) {
            for (JPanel p : r) {
                if (p instanceof ElementCard) {
                    ((ElementCard) p).setColor(new Color(127, 60, 60));
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) { }

    @Override
    public void mouseReleased(MouseEvent e) { }

    @Override
    public void mouseEntered(MouseEvent e) { }

    @Override
    public void mouseExited(MouseEvent e) { }
}
