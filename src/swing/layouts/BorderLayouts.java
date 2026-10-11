package swing.layouts;

import javax.swing.*;
import java.awt.*;

// BorderLayout: 5 regions NORTH, SOUTH, EAST, WEST, CENTER. Default layout of JFrame (content pane)!
// - each region holds ONE component (adding a second replaces the first -> use a JPanel for more)
// - NORTH/SOUTH get their preferred height but full width
// - EAST/WEST get their preferred width but the remaining height
// - CENTER gets all the remaining space
// - add(component) without a region = CENTER
//
//  +-----------------------+
//  |         NORTH         |
//  +------+--------+-------+
//  | WEST | CENTER |  EAST |
//  +------+--------+-------+
//  |         SOUTH         |
//  +-----------------------+
public class BorderLayouts extends JFrame {
    public BorderLayouts() {
        super("BorderLayout");

        this.setLayout(new BorderLayout(5, 5)); // horizontal and vertical gap

        JButton center = new JButton("CENTER (click to remove EAST)");
        JButton east = new JButton("EAST");

        this.add(new JButton("NORTH"), BorderLayout.NORTH);
        this.add(new JButton("SOUTH"), BorderLayout.SOUTH);
        this.add(new JButton("WEST"), BorderLayout.WEST);
        this.add(east, BorderLayout.EAST);
        this.add(center, BorderLayout.CENTER);

        // regions can be left empty, the others take the space
        center.addActionListener(e -> {
            this.remove(east);
            this.revalidate(); // recalculate the layout after adding / removing components
            this.repaint();
        });

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(500, 300);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main() {
        SwingUtilities.invokeLater(BorderLayouts::new);
    }
}
