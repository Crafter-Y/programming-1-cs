package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// JFrame = top-level window with title bar and border. Every Swing app needs a top-level container
// (JFrame, JDialog, JWindow). Components are added to its content pane (add() does that for you).
public class Frames extends JFrame {
    public Frames() {
        // title can be passed to the super constructor or set with setTitle
        super("Frames");
        this.setTitle("JFrame basics");

        JLabel label = new JLabel("Hello Swing!", SwingConstants.CENTER);
        this.add(label); // same as this.getContentPane().add(label)

        // what should happen when the X is clicked:
        // WindowConstants.DO_NOTHING_ON_CLOSE - nothing (handle it yourself with a WindowListener)
        // WindowConstants.HIDE_ON_CLOSE       - only hides the window (default!)
        // WindowConstants.DISPOSE_ON_CLOSE    - closes the window and frees resources, JVM exits when the last window is gone
        // WindowConstants.EXIT_ON_CLOSE       - System.exit(0)
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        // react on window events, e.g. ask before closing
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int answer = JOptionPane.showConfirmDialog(Frames.this, "Really quit?", "Quit",
                        JOptionPane.YES_NO_OPTION);
                if (answer == JOptionPane.YES_OPTION) {
                    Frames.this.dispose(); // close window + free resources
                }
            }
        });

        // size: either a fixed size ...
        this.setSize(400, 200);
        // ... or pack() which sizes the window to the preferred size of its content
        // this.pack();

        this.setMinimumSize(new Dimension(250, 120));
        this.setResizable(true);
        this.setLocationRelativeTo(null); // null = center on screen
        // this.setLocation(100, 100);     // or absolute position (top left corner of the screen is 0,0)

        // always call setVisible(true) LAST, after everything was added
        this.setVisible(true);
    }

    public static void main() {
        // Look and Feel (design) - must be set before creating components. Pick one:
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());     // looks like the OS
            // UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName()); // Java "Metal" look
            // UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            System.err.println("Could not set look and feel: " + e.getMessage());
        }

        // Swing is not thread safe: GUI code should run on the Event Dispatch Thread (EDT).
        // invokeLater schedules the constructor on the EDT. "new Frames();" directly also works in practice.
        SwingUtilities.invokeLater(Frames::new);
    }
}
