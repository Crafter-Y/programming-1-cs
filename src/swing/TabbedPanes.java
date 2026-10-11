package swing;

import javax.swing.*;
import java.awt.*;

// JTabbedPane: several panels on top of each other, switch with tabs
public class TabbedPanes extends JFrame {
    public TabbedPanes() {
        super("Tabbed Panes");

        JTabbedPane tabs = new JTabbedPane(); // tab position: new JTabbedPane(JTabbedPane.LEFT) / TOP / BOTTOM / RIGHT

        JPanel first = new JPanel();
        first.add(new JButton("Button on tab 1"));

        JPanel second = new JPanel();
        second.add(new JTextField("Text on tab 2", 15));

        JPanel third = new JPanel();
        third.add(new JCheckBox("Check box on tab 3"));

        tabs.addTab("First", first);
        tabs.addTab("Second", null, second, "Tool tip of tab 2"); // title, icon, component, tooltip
        tabs.addTab("Third", third);
        tabs.setEnabledAt(2, false); // disable a tab

        JLabel status = new JLabel("Selected tab: First");
        tabs.addChangeListener(e -> status.setText("Selected tab: " + tabs.getTitleAt(tabs.getSelectedIndex())));

        JButton enable = new JButton("Enable third tab and switch to it");
        enable.addActionListener(e -> {
            tabs.setEnabledAt(2, true);
            tabs.setSelectedIndex(2);
        });

        JPanel bottom = new JPanel();
        bottom.add(enable);
        bottom.add(status);

        this.add(tabs, BorderLayout.CENTER);
        this.add(bottom, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(450, 250);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main() {
        SwingUtilities.invokeLater(TabbedPanes::new);
    }
}
