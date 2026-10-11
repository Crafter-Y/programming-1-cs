package swing;

import javax.swing.*;
import java.awt.*;

// Drawing yourself: extend JPanel (or JComponent) and override paintComponent(Graphics).
// Coordinates start at the TOP LEFT corner (0,0), x goes right, y goes DOWN.
// Never call paintComponent yourself - call repaint() and Swing calls it.
public class Painting extends JFrame {
    private static class DrawingPanel extends JPanel {
        private Color circleColor = Color.BLUE;

        public DrawingPanel() {
            this.setPreferredSize(new Dimension(500, 400)); // use with pack()
            this.setBackground(Color.WHITE);
        }

        public void nextColor() {
            this.circleColor = this.circleColor == Color.BLUE ? Color.MAGENTA : Color.BLUE;
            this.repaint(); // triggers paintComponent
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g); // clears the background - don't forget!

            // text
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.BOLD, 18));
            g.drawString("Hello Graphics", 20, 30); // x, y of the text BASELINE

            // lines and rectangles: x, y, width, height
            g.drawLine(20, 40, 480, 40);           // x1, y1, x2, y2
            g.drawRect(20, 60, 100, 60);
            g.setColor(Color.RED);
            g.fillRect(140, 60, 100, 60);
            g.setColor(Color.GRAY);
            g.fill3DRect(260, 60, 100, 60, true);
            g.drawRoundRect(380, 60, 100, 60, 20, 20);

            // ovals / circles: bounding box x, y, width, height
            g.setColor(this.circleColor);
            g.fillOval(20, 140, 80, 80);
            g.setColor(Color.BLACK);
            g.drawOval(120, 140, 120, 80);

            // arcs: x, y, width, height, start angle, arc angle (degrees, counter clockwise, 0 = 3 o'clock)
            g.setColor(Color.ORANGE);
            g.fillArc(260, 140, 80, 80, 30, 300); // pac-man
            g.setColor(Color.BLACK);
            g.drawArc(360, 140, 80, 80, 0, 180);

            // polygon: arrays of x and y points
            int[] xs = { 70, 120, 20 };
            int[] ys = { 240, 320, 320 };
            g.setColor(Color.GREEN);
            g.fillPolygon(xs, ys, 3);

            // custom colors: new Color(r, g, b) with 0-255
            g.setColor(new Color(128, 0, 255));
            g.fillRect(150, 250, 50, 50);

            // use the panel size to draw relative to the window size
            g.setColor(Color.DARK_GRAY);
            g.drawRect(0, 0, this.getWidth() - 1, this.getHeight() - 1);

            // Graphics2D offers more, e.g. thicker lines and anti-aliasing
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setStroke(new BasicStroke(5));
            g2.setColor(Color.CYAN);
            g2.drawLine(250, 260, 450, 360);
        }
    }

    public Painting() {
        super("Painting");

        DrawingPanel panel = new DrawingPanel();
        JButton color = new JButton("Change circle color (repaint)");
        color.addActionListener(e -> panel.nextColor());

        this.add(panel, BorderLayout.CENTER);
        this.add(color, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main() {
        SwingUtilities.invokeLater(Painting::new);
    }
}
