package View;

import Model.Door;
import Model.Maze;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ColorConvertOp;
import java.io.File;
import java.io.IOException;

/**
 * @author Andrew & Nhat
 * @version 2.0
 * This is the class that creates the GUI for our players
 * to view and interact with.
 */
public class PokemonGUI extends JFrame {

    /**
     * Button to access the help tab.
     */
    private static final JButton HELP_BUTTON = new JButton("Help");

    /**
     * Button to move left.
     */
    private static final JButton leftBtn = new JButton("move left");

    /**
     * Button to move right.
     */
    private static final JButton rightBtn = new JButton("move right");

    /**
     * Button to move up.
     */
    private static final JButton upBtn = new JButton("move up");

    /**
     * Button to move down.
     */
    private static final JButton downBtn = new JButton("move down");

    /**
     * Pokemon image.
     */
    public JLabel pokeImage;
    /**
     * JFrame used for the GUI.
     */
    private final JFrame myFrame;

    /**
     * Panel for the GUI.
     */
    private final JPanel myPanel;

    /**
     * JLabel for any images.
     */
    private final JLabel myLabel;

    /**
     * Size of JFrame.
     */
    private final Dimension mySize;

    /**
     * Maze Object for building the maze.
     */
    private final Maze myMaze;

    /**
     * Constructor for instantiating fields.
     */
    public PokemonGUI() {
        //super();
        myPanel = new JPanel();
        myFrame = new JFrame();
        myLabel = new JLabel();
        mySize = new Dimension();
        myMaze = new Maze();
    }

    /**
     * Getter for the help button.
     * @return HELP_BUTTON
     */
    public JButton getHelpButton() {
        return HELP_BUTTON;
    }

    /**
     * Getter for the up button.
     * @return upBtn
     */
    public JButton getUpBtn() {
        return upBtn;
    }

    /**
     * Getter for the down button.
     * @return downBtn
     */
    public JButton getDownBtn() {
        return downBtn;
    }

    /**
     * Getter for the left button.
     * @return leftBtn
     */
    public JButton getLeftBtn() {
        return leftBtn;
    }

    /**
     * Getter for the right button.
     * @return rightBtn
     */
    public JButton getRightBtn() {
        return rightBtn;
    }


    /**
     * Start method used when compiling the GUI class.
     */
    public void start() throws IOException {

        myFrame.setTitle("Pokemon Trivia Maze");
        myFrame.setLayout(new BorderLayout());
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final Image icon = Toolkit.getDefaultToolkit().getImage("src\\Model\\PokeImages\\pikachu.jpg");
        myFrame.setIconImage(icon);



        mazePanel();

        buttonsPanel();
        questionAndAns();
        directionsPanel();

        pokeImage = getNewPicture("zubat");
        revalidate();
        repaint();
        myFrame.pack();
        myFrame.setResizable(true);
        myFrame.setVisible(true);
        myFrame.setLocationRelativeTo(null);

    }

    /**
     * JPanel for the maze.
     */
    private void mazePanel() {
        final JPanel panel = new JPanel();
        DrawMaze maze = new DrawMaze();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(maze);
        myFrame.add(panel, BorderLayout.WEST);
    }

    /**
     * JPanel for the help buttons.
     */
    private void buttonsPanel() {
        final JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        panel.add(HELP_BUTTON);

        HELP_BUTTON.setEnabled(true);
        myFrame.add(panel, BorderLayout.NORTH);
    }

    /**
     * create directional button and put it on a
     * panel.
     */
    private JPanel directionsPanelHelper() {
        final JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        leftBtn.setEnabled(true);

        rightBtn.setEnabled(true);

        upBtn.setEnabled(true);

        downBtn.setEnabled(true);
        JButton test = new JButton("test");
        panel.add(upBtn, BorderLayout.NORTH);
        panel.add(downBtn, BorderLayout.SOUTH);
        panel.add(leftBtn, BorderLayout.WEST);
        panel.add(rightBtn, BorderLayout.EAST);
        return panel;
    }

    /**
     * create a panel to hold the directional keys,
     * it is put on the "east" side of the frame
     */
    private void directionsPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JPanel direction = directionsPanelHelper();
        panel.add(direction,BorderLayout.SOUTH);
        myFrame.add(panel, BorderLayout.EAST);
    }

    /**
     * create the question and answer panels and put in
     * on the frame at "center"
     * @throws IOException for reading a jpg file
     */
    private void questionAndAns() throws IOException {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JLabel question = new JLabel("whos that pokemon?");
        //String pokeName = theDoor.getTheCorrectAnswer();
        pokeImage = getNewPicture("weepinbell");

        JLabel answer = new JLabel("the answer ...");
        panel.add(question, BorderLayout.NORTH);
        panel.add(pokeImage, BorderLayout.CENTER);

        panel.repaint();
        panel.revalidate();
        panel.add(answer, BorderLayout.SOUTH);
        myFrame.add(panel, BorderLayout.CENTER);
        myFrame.repaint();
        myFrame.revalidate();
    }

    /**
     * gets a picture of a pokemon.
     */
    public JLabel getNewPicture(String thePokeName) throws IOException {
        BufferedImage myPicture = ImageIO.read(new File(
                "src\\Model\\PokeImages\\" + thePokeName + ".jpg"));

        myPicture = blackOutPokemon(myPicture);

        JLabel img = new JLabel(new ImageIcon(myPicture));

        return img;
    }

    public BufferedImage blackOutPokemon(final BufferedImage theImg) {
        BufferedImage img = theImg;
        int colorOffset = 15;
        int height = img.getHeight();
        int width = img.getWidth();
        //int innerWhite[][] = new int[width][height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color color = new Color(img.getRGB(x,y));
                if (!isSameColor(color, Color.white, colorOffset)) {
                    img.setRGB(x, y, Color.black.getRGB());
                    //colored[x][y] = 1;
                }
            }
        }

        for (int y = 0; y <height; y++) {
            for (int x = 0; x < width; x++) {
                int visited[][] = new int[width][height];
                if (!outerWhite(img,x,y, visited)) {
                    img.setRGB(x,y, Color.black.getRGB());
                }
            }
        }

        return img;
    }


    private boolean outerWhite(BufferedImage theImg, int x, int y, int[][] visited) {
        int height = theImg.getHeight();
        int width = theImg.getWidth();
        int blackRgb = Color.black.getRGB();
        if (x == width || y == height || x == 0 || y == 0) {
            return true;
        } else if (theImg.getRGB(x,y) == blackRgb || visited[x][y] == 1) {
            return false;
        } else {
            visited[x][y] = 1;
            return outerWhite(theImg, x + 1, y, visited) ||
                    outerWhite(theImg, x - 1, y, visited) ||
                    outerWhite(theImg, x, y + 1, visited) ||
                    outerWhite(theImg, x, y - 1, visited);
        }
    }

    private boolean isSameColor(final Color theTarget, final Color theCurr, int offset) {
        int rT = theTarget.getRed();
        int gT = theTarget.getGreen();
        int bT = theTarget.getBlue();
        int rC = theCurr.getRed();
        int gC = theCurr.getGreen();
        int bC = theCurr.getBlue();
        return(
                (rC-offset<=rT) && (rT<=rC+offset) &&
                        (gC-offset<=gT) && (gT<=bC+offset) &&
                        (bC-offset<=bT) && (bT<=bC+offset) );
    }


    public void setPokeImage(String theImg) throws IOException {
        pokeImage = getNewPicture(theImg);
        myFrame.repaint();
        myFrame.revalidate();
    }
}
