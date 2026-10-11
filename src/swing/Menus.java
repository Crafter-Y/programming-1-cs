package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

// Menu bar structure: JMenuBar -> JMenu -> JMenuItem (or another JMenu = submenu)
public class Menus extends JFrame {
    public Menus() {
        super("Menus");

        JLabel output = new JLabel("Use the menu", SwingConstants.CENTER);
        this.add(output);

        JMenuBar menuBar = new JMenuBar();

        // ---- File menu ----
        JMenu file = new JMenu("File");
        file.setMnemonic(KeyEvent.VK_F); // Alt+F opens the menu

        JMenuItem newItem = new JMenuItem("New");
        // accelerator = keyboard shortcut that triggers the item directly (Ctrl+N)
        newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
        newItem.addActionListener(e -> output.setText("New clicked"));

        JMenuItem open = new JMenuItem("Open");
        open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
        open.addActionListener(e -> output.setText("Open clicked"));

        JMenuItem save = new JMenuItem("Save");
        save.setEnabled(false); // greyed out

        // submenu: just add a JMenu to a JMenu
        JMenu recent = new JMenu("Recent files");
        recent.add(new JMenuItem("a.txt"));
        recent.add(new JMenuItem("b.txt"));

        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(e -> System.exit(0));

        file.add(newItem);
        file.add(open);
        file.add(save);
        file.add(recent);
        file.addSeparator(); // line between items (or file.add(new JSeparator()))
        file.add(exit);

        // ---- View menu: check box and radio button items ----
        JMenu view = new JMenu("View");

        JCheckBoxMenuItem bold = new JCheckBoxMenuItem("Bold");
        bold.addActionListener(e -> output.setFont(output.getFont().deriveFont(bold.isSelected() ? Font.BOLD : Font.PLAIN)));

        JRadioButtonMenuItem small = new JRadioButtonMenuItem("Small", true);
        JRadioButtonMenuItem large = new JRadioButtonMenuItem("Large");
        ButtonGroup sizeGroup = new ButtonGroup();
        sizeGroup.add(small);
        sizeGroup.add(large);
        small.addActionListener(e -> output.setFont(output.getFont().deriveFont(12f)));
        large.addActionListener(e -> output.setFont(output.getFont().deriveFont(30f)));

        view.add(bold);
        view.addSeparator();
        view.add(small);
        view.add(large);

        // ---- Help menu ----
        JMenu help = new JMenu("Help");
        JMenuItem about = new JMenuItem("About");
        about.addActionListener(e -> JOptionPane.showMessageDialog(this, "Menu example"));
        help.add(about);

        menuBar.add(file);
        menuBar.add(view);
        menuBar.add(help);

        // the menu bar is NOT added with add() but with setJMenuBar
        this.setJMenuBar(menuBar);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(400, 250);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main() {
        SwingUtilities.invokeLater(Menus::new);
    }
}
