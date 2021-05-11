package io.github.metalturtle18.periodictableapp.frames;

import javax.swing.*;

public class MainFrame extends JFrame {

    public MainFrame() {
        super("Periodic Table App");
        add(new JTextField("test"));
        setSize(1000, 1000);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
