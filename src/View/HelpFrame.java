package View;

import javax.swing.*;

public class HelpFrame extends JFrame {

    public HelpFrame() {

    }

    public void start() {
        this.setSize(400, 400);
        JOptionPane.showMessageDialog(null, "The goal of this game is to move through " +
                "the maze and answer which pokemon you encounter");
        JOptionPane.showMessageDialog(null, "Use the directions to decide where you want to move " +
                "within the maze");
        JOptionPane.showMessageDialog(null, "Once you successfully answer a question, new doors will " +
                "become available in the new room ");
        JOptionPane.showMessageDialog(null, "Be warned though, missing a question will result in " +
                "that door being permanently locked. If all doors in your path are permanently locked, you lose!");
    }

//    public void helpPanel() {
//        JPanel panel  = new JPanel();
//
//
//    }

    public static void main(String[] args) {
        HelpFrame frame = new HelpFrame();
        frame.start();
    }


}
