package swing;

import javax.swing.*;
import java.awt.*;

// JProgressBar shows progress of a longer task. The work must run in a separate thread,
// otherwise the GUI freezes and the bar is never repainted.
public class ProgressBars extends JFrame {
    public ProgressBars() {
        super("Progress Bars");
        this.setLayout(new FlowLayout());

        JProgressBar bar = new JProgressBar(0, 100); // min, max
        bar.setValue(0);
        bar.setStringPainted(true); // shows "42%"

        // indeterminate = "something is happening" animation without a known end
        JProgressBar busy = new JProgressBar();
        busy.setIndeterminate(true);

        JButton start = new JButton("Start");
        start.addActionListener(e -> {
            start.setEnabled(false);
            new Thread(() -> {
                for (int i = 0; i <= 100; i++) {
                    int progress = i;
                    // GUI updates from another thread -> hand them to the EDT
                    SwingUtilities.invokeLater(() -> bar.setValue(progress));
                    try {
                        Thread.sleep(30); // simulated work
                    } catch (InterruptedException ex) {
                        return;
                    }
                }
                SwingUtilities.invokeLater(() -> {
                    start.setEnabled(true);
                    bar.setString("Done!");
                });
            }).start();
        });

        JButton reset = new JButton("Reset");
        reset.addActionListener(e -> {
            bar.setValue(0);
            bar.setString(null); // null = show percentage again
        });

        this.add(bar);
        this.add(start);
        this.add(reset);
        this.add(busy);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(400, 120);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main() {
        SwingUtilities.invokeLater(ProgressBars::new);
    }
}
