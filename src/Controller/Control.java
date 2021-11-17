package Controller;

import View.PokemonGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Control {

    private JButton myHelp;
    private JButton myNorth;

    public Control() {
        PokemonGUI pokemonGUI = new PokemonGUI();
        myHelp = pokemonGUI.getHelpButton();
    }

    public void setupButtons() {
        myHelp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("help is pressed");
            }
        });
    }




}
