package io.github.metalturtle18.periodictableapp.frames;

import io.github.metalturtle18.periodictableapp.Element;
import io.github.metalturtle18.periodictableapp.PeriodicTableApp;
import io.github.metalturtle18.periodictableapp.listeners.TableListener;
import io.github.metalturtle18.periodictableapp.panels.BlankCard;
import io.github.metalturtle18.periodictableapp.panels.ElementCard;
import io.github.metalturtle18.periodictableapp.panels.NumberCard;

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

        elements = new JPanel[8][19];
        lanActs = new JPanel[2][15];

        // Fill the arrays with blank tiles
        for (int r = 0; r < elements.length; r++) {
            for (int c = 0; c < elements[0].length; c++) {
                elements[r][c] = new BlankCard(65);
            }
        }
        for (int r = 0; r < lanActs.length; r++) {
            for (int c = 0; c < lanActs[0].length; c++) {
                lanActs[r][c] = new BlankCard(65);
            }
        }

        // Fill the arrays with the proper element tiles
        int col6 = 0;
        int col7 = 0;
        for (Element e : Element.values()) {
            if (e.group != -1) {
                elements[e.period][e.group] = new ElementCard(e, 65, true);
            } else if (e.period == 6) {
                lanActs[0][col6] = new ElementCard(e, 65, true);
                col6++;
            } else {
                lanActs[1][col7] = new ElementCard(e, 65, true);
                col7++;
            }
        }

        // Manually add group and period labels to the main element array
        elements[0][1] = new NumberCard(65, "1");
        elements[1][2] = new NumberCard(65, "2");
        elements[3][3] = new NumberCard(65, "3");
        elements[3][4] = new NumberCard(65, "4");
        elements[3][5] = new NumberCard(65, "5");
        elements[3][6] = new NumberCard(65, "6");
        elements[3][7] = new NumberCard(65, "7");
        elements[3][8] = new NumberCard(65, "8");
        elements[3][9] = new NumberCard(65, "9");
        elements[3][10] = new NumberCard(65, "10");
        elements[3][11] = new NumberCard(65, "11");
        elements[3][12] = new NumberCard(65, "12");
        elements[1][13] = new NumberCard(65, "13");
        elements[1][14] = new NumberCard(65, "14");
        elements[1][15] = new NumberCard(65, "15");
        elements[1][16] = new NumberCard(65, "16");
        elements[1][17] = new NumberCard(65, "17");
        elements[0][18] = new NumberCard(65, "18");

        elements[1][0] = new NumberCard(65, "1");
        elements[2][0] = new NumberCard(65, "2");
        elements[3][0] = new NumberCard(65, "3");
        elements[4][0] = new NumberCard(65, "4");
        elements[5][0] = new NumberCard(65, "5");
        elements[6][0] = new NumberCard(65, "6");
        elements[7][0] = new NumberCard(65, "7");


        // Create main element panel
        elementPanel = new JPanel(new GridLayout(8, 19, 4, 4));
        elementPanel.setBackground(PeriodicTableApp.BACKGROUND_COLOR);
//        elementPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));
        for (JPanel[] row : elements) {
            for (JPanel p : row) {
                elementPanel.add(p);
            }
        }

        // Create lanthanide and actinide panel
        lanActPanel = new JPanel(new GridLayout(2, 15, 4, 4));
        lanActPanel.setBackground(PeriodicTableApp.BACKGROUND_COLOR);
//        lanActPanel.setBorder(BorderFactory.createEmptyBorder(10, 158, 20, 20));
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
//        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        buttonPanel.addMouseListener(listener);
        buttonPanel.add(redLabel);

        LegendPanel legendPanel = new LegendPanel();

        JPanel spacerPanel = new JPanel(new GridLayout(1, 19));


        GridBagConstraints constraints = new GridBagConstraints();

        // Adding a row of invisible panels to initialize the GridBag grid size
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        for (int i = 0; i < 19; i++) {
            constraints.gridx = i;
            add(new BlankCard(69, 20), constraints);
        }

        constraints.gridy = 1;
        constraints.gridx = 0;
        constraints.gridwidth = 19;
        constraints.gridheight = 8;
        add(elementPanel, constraints);

        constraints.gridy = 9;
        constraints.gridx = 3;
        constraints.gridwidth = 15;
        constraints.gridheight = 2;
        add(lanActPanel, constraints);

        constraints.gridy = 11;
        constraints.gridx = 0;
        constraints.gridwidth = 3;
        add(buttonPanel, constraints);

        constraints.gridx = 14;
        constraints.gridwidth = 5;
        add(legendPanel, constraints);

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
