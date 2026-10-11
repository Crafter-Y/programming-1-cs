package swing;

import javax.swing.*;
import java.awt.*;

// JScrollPane adds scrollbars to a component that is bigger than the visible area
// (JTextArea, JList, JTable, JTree, big panels, ...)
public class ScrollPanes extends JFrame {
    public ScrollPanes() {
        super("Scroll Panes");

        // a panel with many buttons - bigger than the window
        JPanel content = new JPanel(new GridLayout(0, 5, 5, 5));
        for (int i = 1; i <= 100; i++) {
            content.add(new JButton("Button " + i));
        }

        JScrollPane scroll = new JScrollPane(content);
        // policies: _AS_NEEDED (default), _ALWAYS, _NEVER
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.getVerticalScrollBar().setUnitIncrement(16); // faster mouse wheel scrolling

        // header shown above the scrolling content
        scroll.setColumnHeaderView(new JLabel("Column header (does not scroll vertically)"));

        JButton toTop = new JButton("Scroll to top");
        toTop.addActionListener(e -> scroll.getVerticalScrollBar().setValue(0));

        this.add(scroll, BorderLayout.CENTER);
        this.add(toTop, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(500, 300);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main() {
        SwingUtilities.invokeLater(ScrollPanes::new);
    }
}
