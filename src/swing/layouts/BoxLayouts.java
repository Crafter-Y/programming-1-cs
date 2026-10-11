package swing.layouts;

import javax.swing.*;
import java.awt.*;

// BoxLayout: components in a single column (Y_AXIS) or row (X_AXIS).
// Unlike GridLayout the components keep their preferred size (up to their maximum size).
// Spacing with Box.createVerticalStrut / createHorizontalStrut (fixed) and Box.createGlue (flexible).
public class BoxLayouts extends JFrame {
    public BoxLayouts() {
        super("BoxLayout");
        this.setLayout(new GridLayout(1, 2, 10, 10));

        // ---- vertical box ----
        JPanel vertical = new JPanel();
        // BoxLayout needs the container it belongs to as the first argument
        vertical.setLayout(new BoxLayout(vertical, BoxLayout.Y_AXIS));
        vertical.setBorder(BorderFactory.createTitledBorder("Y_AXIS"));

        JButton first = new JButton("First");
        JButton second = new JButton("Second (longer)");
        JButton third = new JButton("Third");
        // alignment inside a vertical box: Component.LEFT_ALIGNMENT / CENTER_ALIGNMENT / RIGHT_ALIGNMENT
        first.setAlignmentX(Component.CENTER_ALIGNMENT);
        second.setAlignmentX(Component.CENTER_ALIGNMENT);
        third.setAlignmentX(Component.CENTER_ALIGNMENT);

        // let a button stretch to the full width
        JButton wide = new JButton("Stretched");
        wide.setMaximumSize(new Dimension(Integer.MAX_VALUE, wide.getPreferredSize().height));

        vertical.add(first);
        vertical.add(Box.createVerticalStrut(20)); // fixed 20px space
        vertical.add(second);
        vertical.add(Box.createVerticalGlue());    // pushes everything below to the bottom
        vertical.add(third);
        vertical.add(wide);

        // ---- horizontal box ----
        JPanel horizontal = new JPanel();
        horizontal.setLayout(new BoxLayout(horizontal, BoxLayout.X_AXIS));
        horizontal.setBorder(BorderFactory.createTitledBorder("X_AXIS"));

        horizontal.add(new JButton("A"));
        horizontal.add(Box.createHorizontalStrut(10));
        horizontal.add(new JButton("B"));
        horizontal.add(Box.createHorizontalGlue()); // flexible space -> C is pushed to the right
        horizontal.add(new JButton("C"));
        horizontal.add(Box.createRigidArea(new Dimension(5, 0)));

        // shortcut: Box is a container with BoxLayout already set
        // Box box = Box.createVerticalBox();  /  Box.createHorizontalBox();

        this.add(vertical);
        this.add(horizontal);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(500, 300);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main() {
        SwingUtilities.invokeLater(BoxLayouts::new);
    }
}
