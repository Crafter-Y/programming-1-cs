package swing.layouts;

import javax.swing.*;
import java.awt.*;

// Null layout (absolute positioning): no layout manager, every component gets an exact position
// and size with setBounds(x, y, width, height). Simple, but does NOT adapt to window resizing,
// fonts or screen sizes -> avoid in real applications.
public class NullLayouts extends JFrame {
    public NullLayouts() {
        super("Null layout (absolute positioning)");

        this.setLayout(null);

        JButton first = new JButton("x=20, y=20");
        first.setBounds(20, 20, 150, 30); // x, y, width, height

        JButton second = new JButton("x=200, y=60");
        second.setBounds(200, 60, 150, 30);

        // components without bounds have size 0x0 and are invisible!
        JButton moving = new JButton("Click to move me");
        moving.setBounds(20, 120, 150, 30);
        moving.addActionListener(e -> {
            int x = (int) (Math.random() * (this.getContentPane().getWidth() - 150));
            int y = (int) (Math.random() * (this.getContentPane().getHeight() - 30));
            moving.setLocation(x, y); // or setBounds / setSize separately
        });

        this.add(first);
        this.add(second);
        this.add(moving);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(400, 250);
        this.setResizable(false); // often used together with null layout
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main() {
        SwingUtilities.invokeLater(NullLayouts::new);
    }
}
