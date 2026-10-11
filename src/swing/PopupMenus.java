package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// JPopupMenu = context menu (right click)
public class PopupMenus extends JFrame {
    public PopupMenus() {
        super("Popup Menus");

        JPanel panel = new JPanel();
        panel.add(new JLabel("Right click anywhere"));

        JPopupMenu popup = new JPopupMenu();
        JMenuItem red = new JMenuItem("Red");
        JMenuItem green = new JMenuItem("Green");
        JMenuItem reset = new JMenuItem("Reset");
        red.addActionListener(e -> panel.setBackground(Color.RED));
        green.addActionListener(e -> panel.setBackground(Color.GREEN));
        reset.addActionListener(e -> panel.setBackground(null));
        popup.add(red);
        popup.add(green);
        popup.addSeparator();
        popup.add(reset);

        // variant 1: the simple way, Swing shows it on right click by itself
        // panel.setComponentPopupMenu(popup);

        // variant 2: show it manually with a MouseListener: show(component, x, y)
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                showPopup(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                showPopup(e); // on Windows the popup trigger is on release, on Linux/Mac on press
            }

            private void showPopup(MouseEvent e) {
                if (e.isPopupTrigger()) { // or: SwingUtilities.isRightMouseButton(e)
                    popup.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });

        this.add(panel);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(400, 250);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main() {
        SwingUtilities.invokeLater(PopupMenus::new);
    }
}
