package swing.layouts;

import javax.swing.*;
import java.awt.*;

// SpringLayout: every edge (NORTH, SOUTH, EAST, WEST) of a component is attached to an edge of
// another component (or the container) with a distance ("spring").
// putConstraint(edgeOfComponent, component, distance, edgeOfOther, other)
// Very flexible but verbose - mostly used by GUI builders.
public class SpringLayouts extends JFrame {
    public SpringLayouts() {
        super("SpringLayout");

        Container pane = this.getContentPane();
        SpringLayout layout = new SpringLayout();
        pane.setLayout(layout);

        JButton first = new JButton("First");
        JButton second = new JButton("Second");
        JButton third = new JButton("Third (stretches)");
        pane.add(first);
        pane.add(second);
        pane.add(third);

        // first: 10px from the left and top edge of the container
        layout.putConstraint(SpringLayout.WEST, first, 10, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, first, 10, SpringLayout.NORTH, pane);

        // second: 10px right of first, same top
        layout.putConstraint(SpringLayout.WEST, second, 10, SpringLayout.EAST, first);
        layout.putConstraint(SpringLayout.NORTH, second, 0, SpringLayout.NORTH, first);

        // third: 20px below first, left edge = container + 10, right edge = container - 10
        // -> it stretches with the window width
        layout.putConstraint(SpringLayout.NORTH, third, 20, SpringLayout.SOUTH, first);
        layout.putConstraint(SpringLayout.WEST, third, 10, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.EAST, third, -10, SpringLayout.EAST, pane);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(400, 200);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main() {
        SwingUtilities.invokeLater(SpringLayouts::new);
    }
}
