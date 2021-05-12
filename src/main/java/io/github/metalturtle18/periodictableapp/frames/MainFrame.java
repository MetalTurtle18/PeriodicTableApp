package io.github.metalturtle18.periodictableapp.frames;

import javax.swing.*;

public class MainFrame extends JFrame {

    public MainFrame() {
        super("Periodic Table App");
        add(new JTextField("test"));
        setSize(600, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
