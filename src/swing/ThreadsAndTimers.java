package swing;

import javax.swing.*;
import java.awt.*;

// Animations / background work in Swing (like TrafficLight, DancingText):
// - All GUI code runs on ONE thread, the Event Dispatch Thread (EDT).
// - Long work (Thread.sleep, loops, file/network) inside a listener FREEZES the GUI.
// - Solution A: own Thread for the work, GUI updates via SwingUtilities.invokeLater
// - Solution B: javax.swing.Timer - calls an ActionListener every n ms on the EDT (best for animations)
public class ThreadsAndTimers extends JFrame {
    private int position = 0;

    public ThreadsAndTimers() {
        super("Threads and Timers");

        JPanel animation = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.RED);
                g.fillOval(position, this.getHeight() / 2 - 15, 30, 30);
            }
        };

        // ---- B: javax.swing.Timer (NOT java.util.Timer) ----
        Timer timer = new Timer(20, e -> {
            position = (position + 3) % animation.getWidth();
            animation.repaint();
        });
        JButton startStop = new JButton("Start/Stop timer");
        startStop.addActionListener(e -> {
            if (timer.isRunning()) timer.stop();
            else timer.start();
        });

        // ---- A: own thread ----
        JLabel counter = new JLabel("Thread: -");
        JButton threadButton = new JButton("Count with thread");
        threadButton.addActionListener(e -> {
            threadButton.setEnabled(false);
            Thread thread = new Thread(() -> {
                for (int i = 10; i >= 0; i--) {
                    int value = i;
                    SwingUtilities.invokeLater(() -> counter.setText("Thread: " + value));
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        return;
                    }
                }
                SwingUtilities.invokeLater(() -> threadButton.setEnabled(true));
            });
            thread.setDaemon(true); // thread does not keep the JVM alive after the window is closed
            thread.start();
        });

        // ---- the WRONG way: sleeping on the EDT freezes the whole window ----
        JButton freeze = new JButton("Freeze GUI for 3s (wrong!)");
        freeze.addActionListener(e -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                // ignore
            }
        });

        JPanel controls = new JPanel();
        controls.add(startStop);
        controls.add(threadButton);
        controls.add(counter);
        controls.add(freeze);

        this.add(animation, BorderLayout.CENTER);
        this.add(controls, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(650, 250);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main() {
        SwingUtilities.invokeLater(ThreadsAndTimers::new);
    }
}
