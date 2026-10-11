package swing;

import javax.swing.*;
import java.awt.*;

// JInternalFrame: a window inside a window (MDI). Internal frames live in a JDesktopPane.
public class InternalFrames extends JFrame {
    private int count = 0;

    public InternalFrames() {
        super("Internal Frames");

        JDesktopPane desktop = new JDesktopPane();

        JButton create = new JButton("New internal frame");
        create.addActionListener(e -> {
            count++;
            // title, resizable, closable, maximizable, iconifiable
            JInternalFrame frame = new JInternalFrame("Document " + count, true, true, true, true);
            frame.add(new JScrollPane(new JTextArea("Text of document " + count)));
            frame.setSize(200, 150);
            frame.setLocation(20 * count, 20 * count);
            frame.setVisible(true); // internal frames are invisible by default too
            desktop.add(frame);
            try {
                frame.setSelected(true); // bring to front / focus
            } catch (java.beans.PropertyVetoException ex) {
                // ignore
            }
        });

        this.add(create, BorderLayout.NORTH);
        this.add(desktop, BorderLayout.CENTER);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main() {
        SwingUtilities.invokeLater(InternalFrames::new);
    }
}
