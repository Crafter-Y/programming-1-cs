package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

// MouseListener: clicks, press, release, enter, exit. MouseMotionListener: move, drag.
// MouseAdapter implements all methods empty -> only override what you need.
public class MouseEvents extends JFrame {
    private final List<Point> points = new ArrayList<>();
    private final JLabel status = new JLabel("Click or drag in the white area");

    public MouseEvents() {
        super("Mouse Events");

        JPanel canvas = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.RED);
                for (Point p : points) {
                    g.fillOval(p.x - 5, p.y - 5, 10, 10);
                }
            }
        };
        canvas.setBackground(Color.WHITE);

        // MouseAdapter: only override needed methods
        MouseAdapter adapter = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String button = SwingUtilities.isLeftMouseButton(e) ? "left"
                        : SwingUtilities.isRightMouseButton(e) ? "right" : "middle";
                status.setText(button + " click at " + e.getX() + "/" + e.getY() + ", clicks: " + e.getClickCount());
                if (SwingUtilities.isRightMouseButton(e)) points.clear();
                else points.add(e.getPoint());
                canvas.repaint();
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                points.add(e.getPoint());
                canvas.repaint();
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                MouseEvents.this.setTitle("Mouse Events - " + e.getX() + "/" + e.getY());
            }
        };
        canvas.addMouseListener(adapter);       // clicks
        canvas.addMouseMotionListener(adapter); // movement
        // canvas.addMouseWheelListener(e -> System.out.println(e.getWheelRotation()));

        // the full MouseListener interface - all 5 methods must be implemented
        JButton hover = new JButton("Hover me");
        hover.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                hover.setText("Pressed");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                hover.setText("Released");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                hover.setBackground(Color.YELLOW);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hover.setBackground(null);
                hover.setText("Hover me");
            }
        });

        this.add(hover, BorderLayout.NORTH);
        this.add(canvas, BorderLayout.CENTER);
        this.add(status, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main() {
        SwingUtilities.invokeLater(MouseEvents::new);
    }
}
