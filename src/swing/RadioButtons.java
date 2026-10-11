package swing;

import javax.swing.*;
import java.awt.*;

// JRadioButton + ButtonGroup: exactly one option of a group can be selected.
// Without a ButtonGroup radio buttons behave like check boxes!
public class RadioButtons extends JFrame {
    public RadioButtons() {
        super("Radio Buttons");
        this.setLayout(new FlowLayout());

        JLabel result = new JLabel("Size: Medium");

        JRadioButton small = new JRadioButton("Small");
        JRadioButton medium = new JRadioButton("Medium", true); // initially selected
        JRadioButton large = new JRadioButton("Large");

        // the ButtonGroup is NOT a component - it is not added to the frame, only the buttons are
        ButtonGroup group = new ButtonGroup();
        group.add(small);
        group.add(medium);
        group.add(large);

        // one listener for all, uses the action command (= text by default)
        for (JRadioButton button : new JRadioButton[] { small, medium, large }) {
            button.addActionListener(e -> result.setText("Size: " + e.getActionCommand()));
            this.add(button);
        }

        // find the selected one later
        JButton check = new JButton("Which one?");
        check.addActionListener(e -> {
            String selected = "none";
            if (small.isSelected()) selected = "Small";
            else if (medium.isSelected()) selected = "Medium";
            else if (large.isSelected()) selected = "Large";
            // alternative: group.getSelection().getActionCommand() (only works if setActionCommand was called)
            JOptionPane.showMessageDialog(this, "Selected: " + selected);
        });

        JButton clear = new JButton("Clear");
        clear.addActionListener(e -> group.clearSelection());

        this.add(check);
        this.add(clear);
        this.add(result);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(450, 100);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main() {
        SwingUtilities.invokeLater(RadioButtons::new);
    }
}
