package io.github.metalturtle18.periodictableapp.frames;

import io.github.metalturtle18.periodictableapp.Element;
import io.github.metalturtle18.periodictableapp.PeriodicTableApp;
import io.github.metalturtle18.periodictableapp.listeners.ElectronegativityColorListener;
import io.github.metalturtle18.periodictableapp.listeners.FamilyColorListener;
import io.github.metalturtle18.periodictableapp.listeners.MetalColorListener;
import io.github.metalturtle18.periodictableapp.listeners.SongButtonListener;
import io.github.metalturtle18.periodictableapp.panels.BlankCard;
import io.github.metalturtle18.periodictableapp.panels.ElementCard;
import io.github.metalturtle18.periodictableapp.panels.NumberCard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * This class is for the main window frame with the periodic table
 */
public class MainFrame extends JFrame {

    /**
     * An ArrayList of every element in the table to simplify some other methods
     */
    public final ArrayList<ElementCard> allElements;
    public final JPanel buttonPanel, metalLegendPanel, familyLegendPanel, electronegativityLegendPanel;

    private final ActionListener metalColorListener, familyColorListener, electronegativityColorListener, songListener;

    public MainFrame() {
        super("Periodic Table App");
        setLayout(new GridBagLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(PeriodicTableApp.BACKGROUND_COLOR);
        setResizable(false);

        JPanel elementPanel, lanActPanel;

        JPanel[][] elements = new JPanel[8][19];
        JPanel[][] lanActs = new JPanel[2][15];

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
        int[] rowsList = new int[]{0, 1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 1, 1, 1, 1, 1, 0}; // This is an arbitrary list of the rows for the group numbers
        for (int i = 1; i <= 18; i++) // Fill group numbers
            elements[rowsList[i - 1]][i] = new NumberCard(65, String.valueOf(i), NumberCard.BOTTOM);
        for (int i = 1; i <= 7; i++) // Fill period numbers
            elements[i][0] = new NumberCard(65, String.valueOf(i), NumberCard.RIGHT);

        // Fill the list of elements to use in various other methods
        allElements = new ArrayList<>();
        for (JPanel[] r : elements) {
            for (JPanel p : r) {
                if (p instanceof ElementCard) {
                    allElements.add((ElementCard) p);
                }
            }
        }
        for (JPanel[] r : lanActs) {
            for (JPanel p : r) {
                if (p instanceof ElementCard) {
                    allElements.add((ElementCard) p);
                }
            }
        }

        // Create the main element panel
        elementPanel = new JPanel(new GridLayout(8, 19, 4, 4));
        elementPanel.setBackground(PeriodicTableApp.BACKGROUND_COLOR);
        for (JPanel[] row : elements) {
            for (JPanel p : row) {
                elementPanel.add(p);
            }
        }

        // Create the lanthanide and actinide panel
        lanActPanel = new JPanel(new GridLayout(2, 15, 4, 4));
        lanActPanel.setBackground(PeriodicTableApp.BACKGROUND_COLOR);
        lanActPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0)); // Add a border to this panel so it doesn't touch the main element panel
        for (JPanel[] row : lanActs) {
            for (JPanel p : row) {
                lanActPanel.add(p);
            }
        }

        metalColorListener = new MetalColorListener();
        familyColorListener = new FamilyColorListener();
        electronegativityColorListener = new ElectronegativityColorListener();
        songListener = new SongButtonListener();

        metalLegendPanel = new MetalLegendPanel();
        familyLegendPanel = new FamilyLegendPanel();
        electronegativityLegendPanel = new ElectronegativityLegendPanel();
        buttonPanel = new ButtonPanel();

        GridBagConstraints constraints = new GridBagConstraints();

        // Adding a row of invisible panels to initialize the GridBag column size
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        for (int i = 0; i <= 19; i++) {
            constraints.gridx = i;
            add(new BlankCard(69, 1), constraints);
        }
        // Adding a column of invisible panels to initialize the GridBag row size
        constraints.gridx = 19;
        for (int i = 1; i <= 13; i++) {
            constraints.gridy = i;
            add(new BlankCard(1, 69), constraints);
        }

        // Configure constraints and add panels to the frame
        // Main elements panel
        constraints.gridy = 1;
        constraints.gridx = 0;
        constraints.gridwidth = 19;
        constraints.gridheight = 8;
        add(elementPanel, constraints);

        // Lanthanides and actinides panel
        constraints.gridy = 9;
        constraints.gridx = 3;
        constraints.gridwidth = 15;
        constraints.gridheight = 2;
        add(lanActPanel, constraints);

        // Button panel
        constraints.gridy = 12;
        constraints.gridx = 0;
        constraints.gridwidth = 4;
        add(buttonPanel, constraints);

        // Legend panel
        constraints.gridx = 14;
        add(metalLegendPanel, constraints);

        registerShortcuts();
        pack();
        setLocationRelativeTo(null); // This centers the window on the screen
        setVisible(true);
    }

    /**
     * This method registers the keyboard shortcuts for the app
     */
    private void registerShortcuts() {
        InputMap map = rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        map.put(KeyStroke.getKeyStroke("M"), "metal_color");
        map.put(KeyStroke.getKeyStroke("G"), "group_color");
        map.put(KeyStroke.getKeyStroke("E"), "electronegativity");
        map.put(KeyStroke.getKeyStroke("S"), "song");

        // This action object does the right action when a key is pressed
        Action action = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch(e.getActionCommand()) {
                    case "m" -> metalColorListener.actionPerformed(null);
                    case "g" -> familyColorListener.actionPerformed(null);
                    case "e" -> electronegativityColorListener.actionPerformed(null);
                    case "s" -> songListener.actionPerformed(null);
                }
            }
        };
        rootPane.getActionMap().put("metal_color", action);
        rootPane.getActionMap().put("group_color", action);
        rootPane.getActionMap().put("electronegativity", action);
        rootPane.getActionMap().put("song", action);
    }

    /**
     * This class will create a panel that goes on the main page that contains the key for the coloring of the element tiles in the metal mode
     */
    private static class MetalLegendPanel extends JPanel {
        public MetalLegendPanel() {
            super(new BorderLayout());
            setBackground(PeriodicTableApp.BACKGROUND_COLOR);
            setPreferredSize(new Dimension(220, 120));
            setBorder(BorderFactory.createLineBorder(Color.WHITE, 3, true));

            // These are the six items in the legend panel
            JPanel legendPanel = new JPanel(new GridLayout(3, 2));
            legendPanel.add(new ColoredLabel(Element.MetalType.METAL.color, "Metal"));
            legendPanel.add(new ColoredLabel(Element.MatterState.SOLID.color, "Solid", true));
            legendPanel.add(new ColoredLabel(Element.MetalType.METALLOID.color, "Metalloid"));
            legendPanel.add(new ColoredLabel(Element.MatterState.LIQUID.color, "Liquid", true));
            legendPanel.add(new ColoredLabel(Element.MetalType.NONMETAL.color, "Nonmetal"));
            legendPanel.add(new ColoredLabel(Element.MatterState.GAS.color, "Gas", true));

            // Add the label at the top of the panel
            JLabel label = new JLabel("Metal Type Legend");
            label.setFont(new Font("SFProRounded-Regular", Font.PLAIN, 15));
            label.setForeground(Color.WHITE);
            label.setHorizontalAlignment(JLabel.CENTER);

            add(label, BorderLayout.NORTH);
            add(legendPanel, BorderLayout.SOUTH);
        }
    }

    /**
     * This class will create a panel that goes on the main page that contains the key for the coloring of the element tiles in the group mode
     */
    private static class FamilyLegendPanel extends JPanel {
        public FamilyLegendPanel() {
            super(new BorderLayout());
            setBackground(PeriodicTableApp.BACKGROUND_COLOR);
            setPreferredSize(new Dimension(690, 120));
            setBorder(BorderFactory.createLineBorder(Color.WHITE, 3, true));

            // These are the twelve items in the legend panel
            JPanel legendPanel = new JPanel(new GridLayout(3, 4));
            legendPanel.add(new ColoredLabel(Element.ElementFamily.ALKALI_METALS.color, "Alkali metals"));
            legendPanel.add(new ColoredLabel(Element.ElementFamily.ALKALINE_EARTH_METALS.color, "Alkaline earth metals"));
            legendPanel.add(new ColoredLabel(Element.ElementFamily.TRANSITION_METALS.color, "Transition metals"));
            legendPanel.add(new ColoredLabel(Element.ElementFamily.NONMETALS.color, "Nonmetals"));
            legendPanel.add(new ColoredLabel(Element.ElementFamily.OTHER_METALS.color, "Other Metals"));
            legendPanel.add(new ColoredLabel(Element.ElementFamily.METALLOIDS.color, "Metalloids"));
            legendPanel.add(new ColoredLabel(Element.ElementFamily.HALOGENS.color, "Halogens"));
            legendPanel.add(new ColoredLabel(Element.MatterState.LIQUID.color, "Liquid", true));
            legendPanel.add(new ColoredLabel(Element.ElementFamily.NOBLE_GASES.color, "Noble gases"));
            legendPanel.add(new ColoredLabel(Element.ElementFamily.LANTHANIDES.color, "Lanthanides"));
            legendPanel.add(new ColoredLabel(Element.ElementFamily.ACTINIDES.color, "Actinides"));
            legendPanel.add(new ColoredLabel(Element.MatterState.GAS.color, "Gas", true));

            // Add the label at the top of the panel
            JLabel label = new JLabel("Element Group Legend");
            label.setFont(new Font("SFProRounded-Regular", Font.PLAIN, 15));
            label.setForeground(Color.WHITE);
            label.setHorizontalAlignment(JLabel.CENTER);

            add(label, BorderLayout.NORTH);
            add(legendPanel, BorderLayout.SOUTH);
        }
    }

    /**
     * This class will create a panel that goes on the main page that contains the key for the coloring of the element tiles in the electronegativity mode
     */
    private static class ElectronegativityLegendPanel extends JPanel {
        public ElectronegativityLegendPanel() {
            super(new BorderLayout());
            setBackground(PeriodicTableApp.BACKGROUND_COLOR);
            setPreferredSize(new Dimension(690, 120));
            setBorder(BorderFactory.createLineBorder(Color.WHITE, 3, true));

            // Create a new JPanel and initialize it with an anonymous class that draws a gradient rectangle in the middle
            JPanel gradientPanel = new JPanel() {

                @Override
                public Dimension getPreferredSize() {
                    return new Dimension(590, 80);
                }

                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    Graphics2D g2 = (Graphics2D) g;
                    g2.setPaint(new GradientPaint(0, 40, Color.BLACK, 590, 40, new Color(0, 137, 255)));
                    g2.fillRect(0, 0, 590, 80);
                }
            };
            gradientPanel.setBackground(PeriodicTableApp.BACKGROUND_COLOR);
            gradientPanel.setAlignmentX(JPanel.CENTER_ALIGNMENT);
            JPanel gradientPanelContainer = new JPanel();
            gradientPanelContainer.setBackground(PeriodicTableApp.BACKGROUND_COLOR);
            gradientPanelContainer.add(gradientPanel);

            // Add the three labels to this panel
            JLabel lowLabel = new JLabel(" Low");
            lowLabel.setFont(new Font("SFProRounded-Regular", Font.PLAIN, 15));
            lowLabel.setForeground(Color.WHITE);
            lowLabel.setVerticalAlignment(JLabel.CENTER);

            JLabel highLabel = new JLabel("High ");
            highLabel.setFont(new Font("SFProRounded-Regular", Font.PLAIN, 15));
            highLabel.setForeground(Color.WHITE);
            highLabel.setVerticalAlignment(JLabel.CENTER);

            JLabel titleLabel = new JLabel("Electronegativity Legend");
            titleLabel.setFont(new Font("SFProRounded-Regular", Font.PLAIN, 15));
            titleLabel.setForeground(Color.WHITE);
            titleLabel.setHorizontalAlignment(JLabel.CENTER);

            add(titleLabel, BorderLayout.NORTH);
            add(lowLabel, BorderLayout.WEST);
            add(gradientPanelContainer, BorderLayout.CENTER);
            add(highLabel, BorderLayout.EAST);

        }

    }

    /**
     * This class will create a panel that goes on the main page that contains the buttons to change the view of the main page. It can't be static because it accesses instance variables of the outer class
     */
    private class ButtonPanel extends JPanel {
        public ButtonPanel() {
            super(new GridLayout(2, 2));
            setBackground(PeriodicTableApp.BACKGROUND_COLOR);
            setPreferredSize(new Dimension(250, 90));
            setBorder(BorderFactory.createLineBorder(Color.WHITE, 3, true));

            JButton metalButton, familyButton, electronegativityButton, songButton;

            metalButton = new JButton("Metal Types");
            metalButton.addActionListener(metalColorListener);
            add(metalButton);

            familyButton = new JButton("Element Groups");
            familyButton.addActionListener(familyColorListener);
            add(familyButton);

            electronegativityButton = new JButton("Electronegativity");
            electronegativityButton.addActionListener(electronegativityColorListener);
            add(electronegativityButton);

            songButton = new JButton("Play Song");
            songButton.addActionListener(songListener);
            add(songButton);
        }
    }

    /**
     * This class makes it easy to draw the colored square and text for the legend panels
     */
    private static class ColoredLabel extends JPanel {

        private final Color color;
        private final String label;
        private final boolean colorText;

        /**
         * Constructor for a label
         * @param color the color of the label box
         * @param label the text of the label
         * @param colorText whether to color the text the same color as the box
         */
        public ColoredLabel(Color color, String label, boolean colorText) {
            this.color = color;
            this.label = label;
            this.colorText = colorText;

            setPreferredSize(new Dimension(getWidth(), 30));
            setBackground(PeriodicTableApp.BACKGROUND_COLOR);
        }

        /**
         * This constructor doesn't require to know if the text should be colored because it defaults to false
         * @param color the color of the label box
         * @param label the text of the label
         */
        public ColoredLabel(Color color, String label) {
            this(color, label, false);
        }

        /**
         * This method paints the box and text for the label
         * @param g graphics
         */
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(color);
            g.fillRect(5, 5, 20, 20);
            if (!colorText) g.setColor(Color.WHITE);
            g.setFont(new Font("SFProRounded-Regular", Font.PLAIN, 15));
            g.drawString(label, 30, 21);
        }
    }
}
