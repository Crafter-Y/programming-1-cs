package swing;

import javax.swing.*;
import java.awt.*;

// JToolBar: a row of buttons (usually below the menu bar). Can be dragged out if floatable.
public class ToolBars extends JFrame {
    public ToolBars() {
        super("Tool Bars");

        JTextArea area = new JTextArea();

        JToolBar toolBar = new JToolBar("Tools");
        // toolBar.setFloatable(false); // forbid dragging the toolbar out of the window

        JButton clear = new JButton("Clear");
        clear.setToolTipText("Remove all text");
        clear.addActionListener(e -> area.setText(""));

        JButton hello = new JButton("Hello");
        hello.addActionListener(e -> area.append("Hello\n"));

        JToggleButton wrap = new JToggleButton("Wrap");
        wrap.addActionListener(e -> area.setLineWrap(wrap.isSelected()));

        toolBar.add(clear);
        toolBar.add(hello);
        toolBar.addSeparator();
        toolBar.add(wrap);

        // toolbar goes to the border (NORTH) of a BorderLayout, so it can be dragged to the other borders
        this.add(toolBar, BorderLayout.NORTH);
        this.add(new JScrollPane(area), BorderLayout.CENTER);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(400, 250);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main() {
        SwingUtilities.invokeLater(ToolBars::new);
    }
}
