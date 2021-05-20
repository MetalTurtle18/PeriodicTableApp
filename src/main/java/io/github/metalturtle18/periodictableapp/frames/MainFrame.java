package io.github.metalturtle18.periodictableapp.frames;

import io.github.metalturtle18.periodictableapp.Element;
import io.github.metalturtle18.periodictableapp.PeriodicTableApp;
import io.github.metalturtle18.periodictableapp.listeners.TableListener;
import io.github.metalturtle18.periodictableapp.panels.BlankCard;
import io.github.metalturtle18.periodictableapp.panels.ElementCard;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public JPanel[][] elements, lanActs;

    public MainFrame() {
        super("Periodic Table App");
        setLayout(new GridBagLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(PeriodicTableApp.BACKGROUND_COLOR);
        setResizable(false);

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

        TableListener listener = new TableListener(elements, lanActs);
        // The red button is for testing changing the table colors
        redLabel = new JLabel("Make Red");
        redLabel.addMouseListener(listener);
        buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.RED);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        buttonPanel.addMouseListener(listener);
        buttonPanel.add(redLabel);


        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 18;
        constraints.gridheight = 7;
        add(elementPanel, constraints);

        constraints.gridy = 7;
        constraints.gridwidth = 15;
        constraints.gridheight = 2;
        add(lanActPanel, constraints);

        constraints.gridx = 0;
        constraints.gridy = 9;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        add(buttonPanel, constraints);

        // TODO: Fix the alignment with this panel
        constraints.gridx = 5;
        add(new LegendPanel(), constraints);

        pack();
        setLocationRelativeTo(null); // This centers the window on the screen
        setVisible(true);
    }

    /**
     * This class will create a panel that goes on the main page that contains the key for the coloring of the element tiles
     */
    private static class LegendPanel extends JPanel {

        public LegendPanel() {
            super(new GridLayout(3, 3));
            setBackground(PeriodicTableApp.BACKGROUND_COLOR);
            setPreferredSize(new Dimension(300, 90));

            // These are the six items in the legend panel
            add(new ColoredLabel(Element.MetalType.METAL.color, "Metal"));
            add(new ColoredLabel(Element.MatterState.SOLID.color, "Solid"));
            add(new ColoredLabel(Element.MetalType.METALLOID.color, "Metalloid"));
            add(new ColoredLabel(Element.MatterState.LIQUID.color, "Liquid"));
            add(new ColoredLabel(Element.MetalType.NONMETAL.color, "Nonmetal"));
            add(new ColoredLabel(Element.MatterState.GAS.color, "Gas"));
        }

        /**
         * A class within a class within a class
         * This just makes it easy to draw the colored square and text for the legend
         */
        private static class ColoredLabel extends JPanel {

            private final Color color;
            private final String label;

            public ColoredLabel(Color color, String label) {
                this.color = color;
                this.label = label;

                setPreferredSize(new Dimension(getWidth(), 30));
                setBackground(PeriodicTableApp.BACKGROUND_COLOR);
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(color);
                g.fillRect(5, 5, 20, 20);
                g.setColor(Color.WHITE);
                g.setFont(new Font("SFProRounded-Regular", Font.PLAIN, 15));
                g.drawString(label, 30, 21);
            }
        }
    }
}
