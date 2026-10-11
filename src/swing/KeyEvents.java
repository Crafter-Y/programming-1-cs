package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

// KeyListener: keyPressed, keyReleased, keyTyped. Only the component WITH FOCUS receives key events!
public class KeyEvents extends JFrame {
    private int x = 200;
    private int y = 150;

    public KeyEvents() {
        super("Key Events");

        JLabel info = new JLabel("Use the arrow keys", SwingConstants.CENTER);

        JPanel game = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.BLUE);
                g.fillRect(x, y, 30, 30);
            }
        };
        game.setBackground(Color.WHITE);
        game.setFocusable(true); // panels can't get focus by default

        game.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // getKeyCode() for special keys (arrows, enter, ...) -> compare with KeyEvent.VK_...
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT -> x -= 10;
                    case KeyEvent.VK_RIGHT -> x += 10;
                    case KeyEvent.VK_UP -> y -= 10;
                    case KeyEvent.VK_DOWN -> y += 10;
                    case KeyEvent.VK_ESCAPE -> dispose();
                }
                info.setText("Pressed: " + KeyEvent.getKeyText(e.getKeyCode())
                        + (e.isControlDown() ? " + Ctrl" : "") + (e.isShiftDown() ? " + Shift" : ""));
                game.repaint();
            }

            @Override
            public void keyTyped(KeyEvent e) {
                // getKeyChar() for typed characters (only in keyTyped reliable)
                System.out.println("Typed char: " + e.getKeyChar());
            }
        });

        // key listener on a text field: e.g. only allow digits
        JTextField digitsOnly = new JTextField(10);
        digitsOnly.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!Character.isDigit(e.getKeyChar())) {
                    e.consume(); // discard the key
                }
            }
        });
        JPanel top = new JPanel();
        top.add(new JLabel("Digits only:"));
        top.add(digitsOnly);

        this.add(top, BorderLayout.NORTH);
        this.add(game, BorderLayout.CENTER);
        this.add(info, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        game.requestFocusInWindow(); // give focus to the panel (after setVisible)
    }

    public static void main() {
        SwingUtilities.invokeLater(KeyEvents::new);
    }
}
