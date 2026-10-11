package swing;

import javax.swing.*;
import java.awt.*;

// JSplitPane: two components side by side (or on top of each other) with a draggable divider
public class SplitPanes extends JFrame {
    public SplitPanes() {
        super("Split Panes");

        String[] files = { "a.txt", "b.txt", "c.txt" };
        JList<String> list = new JList<>(files);
        JTextArea content = new JTextArea();
        list.addListSelectionListener(e -> content.setText("Content of " + list.getSelectedValue()));

        // HORIZONTAL_SPLIT = left | right, VERTICAL_SPLIT = top / bottom
        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new JScrollPane(list), new JScrollPane(content));
        split.setDividerLocation(120);    // in pixels
        split.setOneTouchExpandable(true); // little arrows to fully collapse one side
        split.setResizeWeight(0.3);        // how extra space is distributed when resizing the window

        // split panes can be nested
        JSplitPane outer = new JSplitPane(JSplitPane.VERTICAL_SPLIT, split, new JButton("Bottom"));
        outer.setDividerLocation(200);

        this.add(outer);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(500, 300);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main() {
        SwingUtilities.invokeLater(SplitPanes::new);
    }
}
