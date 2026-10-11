package swing.layouts;

import javax.swing.*;
import java.awt.*;

// FlowLayout: components are placed in a row from left to right like words in a text.
// If the row is full, it wraps to the next line. Components keep their preferred size.
// Default layout of JPanel!
public class FlowLayouts extends JFrame {
    public FlowLayouts() {
        super("FlowLayout - resize the window!");

        // alignment: FlowLayout.LEFT / CENTER (default) / RIGHT, then horizontal and vertical gap in pixels
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        for (int i = 1; i <= 8; i++) {
            this.add(new JButton("Button " + i));
        }
        this.add(new JButton("A much longer button"));

        // buttons to change the alignment at runtime
        FlowLayout layout = (FlowLayout) this.getContentPane().getLayout();
        JButton left = new JButton("Align LEFT");
        JButton center = new JButton("Align CENTER");
        JButton right = new JButton("Align RIGHT");
        left.addActionListener(e -> setAlignment(layout, FlowLayout.LEFT));
        center.addActionListener(e -> setAlignment(layout, FlowLayout.CENTER));
        right.addActionListener(e -> setAlignment(layout, FlowLayout.RIGHT));
        this.add(left);
        this.add(center);
        this.add(right);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(500, 250);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void setAlignment(FlowLayout layout, int alignment) {
        layout.setAlignment(alignment);
        // after changing the layout, tell Swing to recalculate and redraw
        this.getContentPane().revalidate();
        this.getContentPane().repaint();
    }

    public static void main() {
        SwingUtilities.invokeLater(FlowLayouts::new);
    }
}
