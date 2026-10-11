package swing.layouts;

import javax.swing.*;
import java.awt.*;

// GridLayout: a grid of equally sized cells, filled row by row (left to right, top to bottom).
// Every component is stretched to fill its cell.
// new GridLayout(rows, cols) - one of them may be 0 = "as many as needed"
public class GridLayouts extends JFrame {
    public GridLayouts() {
        super("GridLayout - calculator keypad");

        // 4 rows, 3 columns, 5px gaps
        this.setLayout(new GridLayout(4, 3, 5, 5));

        // a display above the keypad would need nesting (see NestedLayouts), so the typed number goes into the title
        StringBuilder typed = new StringBuilder();
        String[] keys = { "7", "8", "9", "4", "5", "6", "1", "2", "3", "C", "0", "=" };

        for (String key : keys) {
            JButton button = new JButton(key);
            button.setFont(new Font("Arial", Font.BOLD, 20));
            button.addActionListener(e -> {
                switch (key) {
                    case "C" -> typed.setLength(0);
                    case "=" -> JOptionPane.showMessageDialog(this, "Typed: " + typed);
                    default -> typed.append(key);
                }
                this.setTitle("GridLayout - " + typed);
            });
            this.add(button);
        }

        // examples:
        // new GridLayout(0, 2)  -> 2 columns, rows grow as needed (good for label/field forms)
        // new GridLayout(1, 0)  -> everything in one row
        // new GridLayout(0, 1)  -> everything in one column

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(300, 350);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main() {
        SwingUtilities.invokeLater(GridLayouts::new);
    }
}
