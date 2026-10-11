package swing.layouts;

import javax.swing.*;
import java.awt.*;

// GridBagLayout: the most flexible grid. Cells can span several rows/columns, rows/columns
// can have different sizes. Every component gets a GridBagConstraints object:
// - gridx, gridy         : cell position (column, row), starting at 0
// - gridwidth, gridheight: how many cells the component spans
// - weightx, weighty     : how extra space is distributed (0 = don't grow)
// - fill                 : NONE, HORIZONTAL, VERTICAL, BOTH - stretch the component inside its cell
// - anchor               : where in the cell, e.g. CENTER, WEST, NORTHEAST
// - insets               : outer margin (top, left, bottom, right)
//
//  +------------+------------+------------+
//  | Button 1   | Button 2   | Button 3   |
//  +------------+------------+------------+
//  |       Button 4 (gridwidth = 3)       |
//  +------------+-------------------------+
//  | Button 5   |                         |
//  | (gridheight| Button 6 (width 2, fill)|
//  |  = 2)      +-------------------------+
//  |            | Button 7   | Button 8   |
//  +------------+------------+------------+
public class GridBagLayouts extends JFrame {
    public GridBagLayouts() {
        super("GridBagLayout");
        this.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(3, 3, 3, 3);
        c.weightx = 1;
        c.weighty = 1;

        // row 0: three buttons
        add(new JButton("Button 1"), c, 0, 0, 1, 1);
        add(new JButton("Button 2"), c, 1, 0, 1, 1);
        add(new JButton("Button 3"), c, 2, 0, 1, 1);

        // row 1: one button over all 3 columns
        add(new JButton("Button 4"), c, 0, 1, 3, 1);

        // row 2-3: tall button on the left, wide button on the right
        add(new JButton("Button 5"), c, 0, 2, 1, 2);
        add(new JButton("Button 6"), c, 1, 2, 2, 1);
        add(new JButton("Button 7"), c, 1, 3, 1, 1);

        // a button that does NOT fill its cell, anchored in the bottom right corner
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.SOUTHEAST;
        add(new JButton("8"), c, 2, 3, 1, 1);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(450, 300);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    // helper so we don't have to repeat 5 lines for every component
    // (the same constraints object can be reused, add() copies the values)
    private void add(Component component, GridBagConstraints c, int x, int y, int width, int height) {
        c.gridx = x;
        c.gridy = y;
        c.gridwidth = width;
        c.gridheight = height;
        this.add(component, c);
    }

    public static void main() {
        SwingUtilities.invokeLater(GridBagLayouts::new);
    }
}
