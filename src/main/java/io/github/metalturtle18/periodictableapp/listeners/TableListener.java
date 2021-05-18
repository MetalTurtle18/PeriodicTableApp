package io.github.metalturtle18.periodictableapp.listeners;

import io.github.metalturtle18.periodictableapp.panels.ElementCard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TableListener implements MouseListener {

    JPanel[][] elements, lanActs;

    public TableListener(JPanel[][] elements, JPanel[][] lanActs) {
        this.elements = elements;
        this.lanActs = lanActs;
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
