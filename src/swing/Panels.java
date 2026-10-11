package swing;

import javax.swing.*;
import java.awt.*;

// JPanel is an invisible container (like a <div> in HTML). It is used to group components
// and to give each group its own layout manager. Default layout of a JPanel is FlowLayout.
public class Panels extends JFrame {
    public Panels() {
        super("Panels");

        // a panel with a background color
        JPanel redPanel = new JPanel();
        redPanel.setBackground(Color.PINK);
        redPanel.add(new JButton("in red panel"));

        // a panel with a titled border
        JPanel borderPanel = new JPanel();
        borderPanel.setBorder(BorderFactory.createTitledBorder("Titled border"));
        borderPanel.add(new JButton("A"));
        borderPanel.add(new JButton("B"));

        // other borders from BorderFactory
        JPanel linePanel = new JPanel();
        linePanel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 3));
        linePanel.add(new JLabel("Line border"));

        JPanel emptyBorderPanel = new JPanel();
        emptyBorderPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // padding: top, left, bottom, right
        emptyBorderPanel.add(new JLabel("Empty border = padding"));

        JPanel etchedPanel = new JPanel();
        etchedPanel.setBorder(BorderFactory.createEtchedBorder());
        etchedPanel.add(new JLabel("Etched border"));

        // panels can be nested: one main panel containing the others
        JPanel mainPanel = new JPanel(new GridLayout(0, 1, 5, 5)); // layout can be passed in the constructor
        mainPanel.add(redPanel);
        mainPanel.add(borderPanel);
        mainPanel.add(linePanel);
        mainPanel.add(emptyBorderPanel);
        mainPanel.add(etchedPanel);

        // a panel can also be used as the whole content pane
        this.setContentPane(mainPanel);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main() {
        SwingUtilities.invokeLater(Panels::new);
    }
}
