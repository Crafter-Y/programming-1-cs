package swing.layouts;

import javax.swing.*;
import java.awt.*;

// Real GUIs combine layouts by nesting JPanels, each with its own layout manager.
// Typical pattern: BorderLayout for the window, FlowLayout panel for a button row,
// GridLayout panel for a form or keypad.
//
//  +------------------------------------------+
//  | NORTH: FlowLayout (toolbar buttons)      |
//  +------------+-----------------------------+
//  | WEST:      | CENTER: GridLayout(0, 2)    |
//  | BoxLayout  |   label  | field            |
//  | (menu)     |   label  | field            |
//  +------------+-----------------------------+
//  | SOUTH: FlowLayout RIGHT (OK / Cancel)    |
//  +------------------------------------------+
public class NestedLayouts extends JFrame {
    public NestedLayouts() {
        super("Nested layouts");
        this.setLayout(new BorderLayout(5, 5)); // already the default for JFrame

        // NORTH: a row of buttons
        JPanel toolbar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        toolbar.add(new JButton("New"));
        toolbar.add(new JButton("Open"));
        toolbar.add(new JButton("Save"));

        // WEST: vertical menu
        JPanel side = new JPanel();
        side.setLayout(new BoxLayout(side, BoxLayout.Y_AXIS));
        side.setBorder(BorderFactory.createTitledBorder("Menu"));
        side.add(new JButton("Home"));
        side.add(new JButton("Profile"));
        side.add(new JButton("Settings"));

        // CENTER: form with labels and fields
        JPanel form = new JPanel(new GridLayout(0, 2, 5, 5));
        form.setBorder(BorderFactory.createTitledBorder("Form"));
        JTextField name = new JTextField();
        JTextField age = new JTextField();
        form.add(new JLabel("Name:"));
        form.add(name);
        form.add(new JLabel("Age:"));
        form.add(age);

        // trick: wrap the form in a FlowLayout/BorderLayout panel so it is not stretched vertically
        JPanel formWrapper = new JPanel(new BorderLayout());
        formWrapper.add(form, BorderLayout.NORTH);

        // SOUTH: OK / Cancel aligned to the right
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton ok = new JButton("OK");
        JButton cancel = new JButton("Cancel");
        ok.addActionListener(e -> JOptionPane.showMessageDialog(this, name.getText() + " is " + age.getText()));
        cancel.addActionListener(e -> this.dispose());
        buttons.add(ok);
        buttons.add(cancel);

        this.add(toolbar, BorderLayout.NORTH);
        this.add(side, BorderLayout.WEST);
        this.add(formWrapper, BorderLayout.CENTER);
        this.add(buttons, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(500, 300);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main() {
        SwingUtilities.invokeLater(NestedLayouts::new);
    }
}
